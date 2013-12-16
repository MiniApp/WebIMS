package im.shs.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import im.shs.service.UserServiceImpl;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private final Log logger = LogFactory.getLog(WeiboLoginAction.class);
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
        String code_temp = request.getParameter("code");// 访问授权链接后腾讯微博返回的一个随机code值
        logger.info("Code is : " + code_temp);
        Map<String, Object> map = weiboService.tencentWeiboLogin(code_temp);
        this.urlTokens = (String) map.get("urlTokens");

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
