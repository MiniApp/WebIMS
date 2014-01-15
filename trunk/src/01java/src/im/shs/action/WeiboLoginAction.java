package im.shs.action;

import im.shs.service.TctService;
import im.shs.service.WeiBoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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

import com.opensymphony.xwork2.ActionSupport;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.ubiyao.sns.tencent.util.THttpClient;

@Component("weiBoLoginAction")
@Scope("prototype")
public class WeiboLoginAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private static final long serialVersionUID = 1L;

    private final Log logger = LogFactory.getLog(WeiboLoginAction.class);

    private HttpServletResponse response;

    private HttpServletRequest request;

    private String url;

    private String access_token;

    private String expires_in;

    private String urlTokens;

    private String openid;

    private String openkey;

    private String refresh_token;

    private String state;

    private String name;

    private String nick;

    @Resource(name = "weiboService")
    private WeiBoService weiboService;

    @Resource(name = "tctService")
    private TctService tctService;

    @SuppressWarnings("rawtypes")
    public String tencentWeiboLoginInit() {
        Map map = new HashMap();
        Cookie allCookie[] = request.getCookies();

        if (allCookie != null && allCookie.length != 0) {
            for (int i = 0; i < allCookie.length; i++) {
                String keyname = allCookie[i].getName();
                if ("accessToken".equals(keyname)) {
                    if (!"".equals(allCookie[i].getValue())) {
                        map.put("clientAccessToken", allCookie[i].getValue());
                    }

                }
                /*if ("tctUserName".equals(keyname)) {
                    map.put("tctUserName", allCookie[i].getValue());
                }*/
            }
        }
        if (!"".equals(map.get("clientAccessToken"))) {
            if (weiboService.checkTencentLogin(map)) {
                url = "";
                return "tencentWeibo";
            } else {
                url = weiboService.tencentWeiboLoginInit();
                return "tencentWeiboLoginInitRedirect";
            }
        } else {
            url = weiboService.tencentWeiboLoginInit();
            return "tencentWeiboLoginInitRedirect";
        }

        /* url = weiboService.tencentWeiboLoginInit();
         return "tencentWeiboLoginInitRedirect";*/
    }

    public String tencentWeiboLogin() throws UnsupportedEncodingException {
        /* String code_temp = request.getParameter("code");// 访问授权链接后腾讯微博返回的一个随机code值
         logger.info("Code is : " + code_temp);*/
        Map<String, Object> map = weiboService.tencentWeiboLogin();
        this.urlTokens = (String) map.get("urlTokens");
        logger.info("urlTokens is : " + urlTokens);
        Cookie accessToken = new Cookie("accessToken", (String) map.get("accessToken"));
        accessToken.setMaxAge(60 * 60 * 24 * 93);
        Cookie tctUerName = new Cookie("tctUserName", (String) map.get("name"));
        tctUerName.setMaxAge(60 * 60 * 24 * 93);
        response.addCookie(accessToken);
        //response.addCookie(tctUerName);
        return "tencentWeiboLoginSuccess";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String tencentWeibo() {
        Map map = new HashMap();
        Cookie allCookie[] = request.getCookies();

        if (allCookie != null && allCookie.length != 0) {
            for (int i = 0; i < allCookie.length; i++) {
                String keyname = allCookie[i].getName();
                if ("accessToken".equals(keyname)) {
                    map.put("clientAccessToken", allCookie[i].getValue());
                }
                /*if ("tctUserName".equals(keyname)) {
                    map.put("tctUserName", allCookie[i].getValue());
                }*/
            }
        }
        if (weiboService.checkTencentLogin(map)) {
            request.getSession().setAttribute("clientAccessToken", map.get("clientAccessToken"));
            return "tencentWeiboSuccess";
        } else {
            return "tencentWeiboFail";
        }
        //return "tencentWeiboSuccess";
    }

    public String tencentWeiboLogout() {
        request.getSession().removeAttribute("clientAccessToken");
        request.getSession().removeAttribute("accessToken");
        Cookie[] cookies = request.getCookies();
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = new Cookie("accessToken", null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        } catch (Exception ex) {
        }
        return "tencentWeiboLogoutSucc";
    }

    public String testTLoginInit() {
        url = tctService.tencentWeiboLoginInit();
         
        /*NameValuePair client_id = new NameValuePair("client_id", "801456520");
        NameValuePair response_type = new NameValuePair("response_type", "token");
        NameValuePair redirect_uri = new NameValuePair("redirect_uri", "http://127.0.0.1:8080/web/testTLogin");
        NameValuePair[] params = new NameValuePair[] { client_id, response_type, redirect_uri };
        String sr = this.doHttpClient("https://open.t.qq.com/cgi-bin/oauth2/authorize", params);*/
        return "tencentWeiboLoginInitRedirect";
    }

    public String testTLogin() {
        this.access_token = request.getParameter("access_token");
        this.expires_in = request.getParameter("expires_in");
        this.openid = request.getParameter("openid");
        this.openkey = request.getParameter("openkey");
        this.refresh_token = request.getParameter("refresh_token");
        this.name = request.getParameter("name");
        System.out.println("accessToken:" + this.access_token + "\n");
        urlTokens = "http://127.0.0.1:8080/web/testTLogin";
        
        return "tencentWeiboLoginSuccess";
    }
    
    public String testLoginCheck() {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("Name:" + name);
        try {
            PrintWriter out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "testLoginCheckSuccess";
    }

    public String test() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        tctService.addStatus();
        return "test";
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
    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    private static void init(OAuthV2 oAuth) {
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI_SUCC");
        oAuth.setClientId(client_id_temp);
        oAuth.setClientSecret(client_secret_temp);
        oAuth.setRedirectUri(redirect_uri_temp);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
