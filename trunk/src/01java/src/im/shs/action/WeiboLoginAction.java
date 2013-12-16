package im.shs.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import im.shs.service.WeiBoService;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tencent.weibo.api.StatusesAPI;
import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;

@Component("weiBoLoginAction")
@Scope("prototype")
public class WeiboLoginAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;

    private HttpServletRequest request;

    private String url;

    private String urlTokens;

    private String code;

    private String openid;

    private String openkey;

    private String state;

    private static OAuthV2 oAuth = new OAuthV2();

    @Resource(name = "weiboService")
    private WeiBoService weiboService;

    public String tencentWeiboLoginInit() {
        url = weiboService.tencentWeiboLoginInit();
        /*try {
        	response.sendRedirect(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }*/
        return "tencentWeiboLoginInitRedirect";
    }

    public String tencentWeiboLogin() throws UnsupportedEncodingException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        weiboService.tencentWeiboLogin();
        init(oAuth);
        //ActionContext context=ActionContext.getContext(); //得到Action执行的上下文

        //Map request=(Map)context.get("request");//得到HttpServletRequest的Map对象
        String code_temp = request.getParameter("code");// 访问授权链接后腾讯微博返回的一个随机code值
        System.out.println(code_temp);

        // 读取资源文件
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI");
        String redirect_uri_succ_temp = resource.getString("redirect_URI_SUCC");
        String grant_type_temp = resource.getString("grant_TYPE");
        String state_temp = resource.getString("state");
        String authorizeURL_temp = resource.getString("authorizeURL");

        // 根据授权之后产生的随机code我要再访问的地址
        String url = resource.getString("accessTokenURL");

        // 用httpclient模拟post方式访问,设置post方式 传递的参数
        NameValuePair client_id = new NameValuePair("client_id", client_id_temp);
        NameValuePair client_secret = new NameValuePair("client_secret", client_secret_temp);
        NameValuePair redirect_uri = new NameValuePair("redirect_uri", redirect_uri_temp);
        NameValuePair grant_type = new NameValuePair("grant_type", grant_type_temp);
        NameValuePair code = new NameValuePair("code", code_temp);
        NameValuePair state = new NameValuePair("state", state_temp);
        NameValuePair[] params = new NameValuePair[] { client_id, client_secret, redirect_uri, grant_type, code, state };
        String result = this.doHttpClient(url, params);
        System.out.println("result:" + result);
        int isExist = result.indexOf("nick");//nick用户昵称

        if (isExist != -1) {
            // 授权成功
            if (null != result && !"".equals(result)) {

                Map<String, Object> code_map = new HashMap<String, Object>();

                if (null != result && !"".equals(result)) {

                    String[] keyAndValue = result.split("&");
                    for (int i = 0; i < keyAndValue.length; i++) {
                        String temp_String = keyAndValue[i];
                        String[] keyOrValue = temp_String.split("=");
                        code_map.put(keyOrValue[0], keyOrValue[1]);
                    }

                }
                /*NameValuePair authorizeURL = new NameValuePair("authorizeURL", authorizeURL_temp);
                NameValuePair response_type = new NameValuePair("response_type", (String) code_map.get("access_token"));
                NameValuePair[] paramsA = new NameValuePair[] { authorizeURL, client_id, response_type, redirect_uri };
                *///String resultA = this.doHttpClient(authorizeURL.toString(), paramsA);
                StringBuffer urlToken = new StringBuffer();
                urlToken.append(authorizeURL_temp);
                urlToken.append("?client_id=");
                urlToken.append(client_id_temp);
                urlToken.append("&response_type=code"/*+(String) code_map.get("access_token")*/+ "&redirect_uri=");
                urlToken.append(redirect_uri_succ_temp);
                this.urlTokens = "http://127.0.0.1:8080/web/tencentWeibo";//urlToken.toString();
                System.out.println("urlToken:" + this.urlTokens);
                String s = (String) code_map.get("nick");
                byte[] tmpByteArray = s.getBytes("iso-8859-1");
                s = new String(tmpByteArray, "UTF-8");
                System.out.println("==========我的昵称: " + s);
                oAuth.setOpenid((String) code_map.get("openid"));
                String responseData = result;
                if (OAuthV2Client.parseAccessTokenAndOpenId(responseData, oAuth)) {
                    System.out.println("Get Access Token Successfully");
                    StatusesAPI statusesAPI = new StatusesAPI(oAuth.getOauthVersion());
                    String response;
                    String format = "json";
                    String clientip = "127.0.0.1";
                    String jing = "";
                    String wei = "";
                    String syncflag = "";
                    String pageflag = "0";
                    String pagetime = "0";
                    String reqnum = "5";
                    String lastid = "'0";
                    String contenttype = "0";
                    String content = "3";// 注意：因为后台会对微博内容进行判重，所以在重复测试时加上变换部分++++++++
                    String twitterid = "0";
                    String fopenids = "";
                    String fopenid = "";
                    String reid = null;
                    String ids = null;
                    String id = null;
                    String names = "api_weibo,t-qq-com,vvtest1";
                    String name = "t-qq-com";
                    String flag = "2";
                    String keyword = "微博";
                    String pagesize = "5";
                    String page = "0";
                    String searchtype = "0";
                    String msgtype = "0";
                    String sorttype = "0";
                    String type = "0";
                    String op = "0";
                    String starttime = "";
                    String endtime = "";
                    String province = "";
                    String city = "";
                    String longitue = "";
                    String latitude = "";
                    String radius = "";
                    String startindex = "0";
                    String mode = "0";
                    String install = "0";
                    String picpath = System.getProperty("user.dir") + "\\src\\main\\resources\\logo_QWeibo.jpg";
                    try {
                        //String d = statusesAPI.homeTimeline(oAuth, format, pageflag, pagetime, reqnum, type, contenttype);
                        String m = statusesAPI.broadcastTimeline(oAuth, format, pageflag, pagetime, reqnum, lastid, type, contenttype);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Fail to Get Access Token");
                }
            }

        }

        return "tencentWeiboLoginSuccess";
    }

    public String tencentWeibo() {

        return "tencentWeiboSuccess";
    }

    public String sinaWeiBoLogin() {

        return null;
    }

    public String qqWeiBoShow() {
        //weiboService.showQQInfo();
        return "qqWeiBoShow";
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 调用httpClient
     * @param url 要访问的地址
     * @param params 要携带的参数
     * @return
     */
    private String doHttpClient(String url, NameValuePair[] params) {
        PostMethod post = new PostMethod(url);

        post.setRequestBody(params);

        HttpClient client = new HttpClient();

        String str_result = ""; // 页面返回结果

        try {
            client.executeMethod(post); // 执行post方法
            str_result = post.getResponseBodyAsString();
            return str_result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }

        return "";

    }

    private static void init(OAuthV2 oAuth) {
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI_SUCC");
        oAuth.setClientId(client_id_temp);
        oAuth.setClientSecret(client_secret_temp);
        oAuth.setRedirectUri(redirect_uri_temp);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenkey() {
        return openkey;
    }

    public void setOpenkey(String openkey) {
        this.openkey = openkey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrlTokens() {
        return urlTokens;
    }

    public void setUrlTokens(String urlTokens) {
        this.urlTokens = urlTokens;
    }
}
