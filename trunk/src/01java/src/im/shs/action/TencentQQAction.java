package im.shs.action;

import im.shs.service.TencentQQService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ubiyao.sns.tencent.qq.util.QConstant;
import com.ubiyao.sns.tencent.weibo.util.THttpClient;

@Component("tencentQQAction")
@Scope("prototype")
public class TencentQQAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private static final long serialVersionUID = 1L;

	private final Log logger = LogFactory.getLog(TencentQQAction.class);

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

    @Resource(name = "tctQQService")
    private TencentQQService tctQQService;

    public String tencentQQLoginInit() {
    	logger.info("tencentQQLoginInit start");
        url = tctQQService.tencentQQLoginInit();
        return "tencentQQLoginInitRedirect";
        
    }

    public String tencentQQLogin() {

        return "tencentQQLoginSuccess";
    }
    
    public String tencentQQOpenID() throws Exception {
        
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            StringBuffer queryString = new StringBuffer();
            queryString.append("access_token=");
            queryString.append(access_token);
            THttpClient hc = new THttpClient();
            String s = hc.simpleHttpGet(QConstant.GET_OPENID_URL, queryString.toString());
            String c = s.substring(s.indexOf("{"), s.lastIndexOf("}")+1);
            out.println(c);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    

    public String tencentQQShow() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException {
        //String s = tctQQService.getUserInfo();
        
        //logger.info("UserInfo:" + s);
        String a = tctQQService.addShare();
        logger.info("AddShare:" + a);
        return "tencentQQShow";
    }

    public String tencentQQLogout() {
        request.getSession().removeAttribute("clientAccessToken");
        request.getSession().removeAttribute("accessToken");
        Cookie[] cookies = request.getCookies();
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie accessToken = new Cookie("accessToken", null);
                accessToken.setMaxAge(0);
                response.addCookie(accessToken);
                
                Cookie userName = new Cookie("userName", null);
                userName.setMaxAge(0);
                response.addCookie(userName);
            }
        } catch (Exception ex) {
        }
        return "tencentWeiboLogoutSucc";
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
