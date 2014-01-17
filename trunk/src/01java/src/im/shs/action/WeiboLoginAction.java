package im.shs.action;

import im.shs.bean.TUserLoginBean;
import im.shs.service.TctService;
import im.shs.service.WeiBoService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String tencentWeiboLoginInit() {
        Map map = new HashMap();
        Cookie cookie[] = request.getCookies();

        if (cookie != null && cookie.length != 0) {
            for (int i = 0; i < cookie.length; i++) {
                String keyname = cookie[i].getName();
                if ("accessToken".equals(keyname)) {
                    if (!"".equals(cookie[i].getValue())) {
                        map.put("clientAccessToken", cookie[i].getValue());
                    }

                }
                if ("userName".equals(keyname)) {
                    if (!"".equals(cookie[i].getValue())) {
                        map.put("clientUserName", cookie[i].getValue());
                    }
                }
            }
        }
        if (!"".equals(map.get("clientAccessToken"))) {
            if (tctService.checkTencentLogin(map)) {
                url = "";
                request.setAttribute("accessToken", map.get("clientAccessToken"));
                request.setAttribute("userName", map.get("clientUserName"));
                return "tencentWeibo";
            } else {
                url = tctService.tencentWeiboLoginInit();
                return "tencentWeiboLoginInitRedirect";
            }
        } else {
            url = tctService.tencentWeiboLoginInit();
            return "tencentWeiboLoginInitRedirect";
        }

    }

    public String tencentWeiboLogin() {
        /*TUserLoginBean bean = new TUserLoginBean();
        bean.setAccessToken(access_token);
        bean.setExpiresIn(Integer.parseInt(expires_in));
        bean.setName(name);
        bean.setNick(nick);
        bean.setOpenid(openid);
        bean.setOpenkey(openkey);
        bean.setRefreshToken(refresh_token);
        
        tctService.saveUserLoginInfo(bean);
        try {
            tctService.addStatus();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Cookie accessToken = new Cookie("accessToken", bean.getAccessToken());
        accessToken.setMaxAge(60 * 60 * 24 * 93);
        Cookie tctUerName = new Cookie("tctUserName", bean.getName());
        tctUerName.setMaxAge(60 * 60 * 24 * 93);
        response.addCookie(accessToken);
        response.addCookie(tctUerName);*/
        
        return "tencentWeiboLoginSuccess";
    }
    
    public String tencentWeiboLoginCheck() {
        System.out.println("access_token:" + access_token + "\nexpires_in:" + expires_in);
        TUserLoginBean bean = new TUserLoginBean();
        bean.setAccessToken(access_token);
        bean.setExpiresIn(Integer.parseInt(expires_in));
        bean.setName(name);
        try {
            bean.setNick(URLDecoder.decode(nick, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        bean.setOpenid(openid);
        bean.setOpenkey(openkey);
        bean.setRefreshToken(refresh_token);
        
        tctService.saveUserLoginInfo(bean);
        
        String accessTokenVal = (String) request.getAttribute("accessToken");
        String userNameVal = (String) request.getAttribute("userName");
        Boolean isLogin = false;
        if (!"".equals(accessTokenVal) && !"".equals(userNameVal)) {
            Map map = new HashMap();
            map.put("clientUerName", userNameVal);
            map.put("clientAccessToken", accessTokenVal);
            isLogin = tctService.checkTencentLogin(map);
        }
        
        try {
            if (isLogin) {
                TUserLoginBean albean = new TUserLoginBean();
                Cookie cookie[] = request.getCookies();

                if (cookie != null && cookie.length != 0) {
                    for (int i = 0; i < cookie.length; i++) {
                        String keyname = cookie[i].getName();
                        if ("accessToken".equals(keyname)) {
                            if (!"".equals(cookie[i].getValue())) {
                                albean.setAccessToken(cookie[i].getValue());
                            }

                        }
                        if ("userName".equals(keyname)) {
                            if (!"".equals(cookie[i].getValue())) {
                                albean.setName(cookie[i].getValue());
                            }
                        }
                    }
                }
                tctService.addStatus(albean, false);
            } else {
                tctService.addStatus(bean, true);
            }
           
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Cookie accessToken = new Cookie("accessToken", bean.getAccessToken());
        accessToken.setMaxAge(60 * 60 * 24 * 93);
        //Cookie uerName = new Cookie("userName", bean.getName());
        //uerName.setMaxAge(60 * 60 * 24 * 93);
        response.addCookie(accessToken);
        //response.addCookie(uerName);
        
        return null;
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
                if ("userName".equals(keyname)) {
                    map.put("clientUerName", allCookie[i].getValue());
                }
            }
        }
        if (tctService.checkTencentLogin(map)) {
            request.getSession().setAttribute("clientAccessToken", map.get("clientAccessToken"));
            return "tencentWeiboSuccess";
        } else {
            return "tencentWeiboFail";
        }
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
         
        return "tencentWeiboLoginInitRedirect";
    }

    public String testTLogin() {
        urlTokens = "http://127.0.0.1:8080/web/testTLogin";
        
        return "tencentWeiboLoginSuccess";
    }
    
    public String testLoginCheck() {
        System.out.println("access_token:" + access_token + "\nexpires_in:" + expires_in);
        TUserLoginBean bean = new TUserLoginBean();
        bean.setAccessToken(access_token);
        bean.setExpiresIn(Integer.parseInt(expires_in));
        /*String result = "";
        int p = 0;
        if (name != null && name.length() > 0) {
            name = name.toLowerCase();
            p = name.indexOf("%e");
            if (p == -1)
                return name;
            while (p != -1) {
                result += name.substring(0, p);
                name = name.substring(p, name.length());
                if (name == "" || name.length() < 9)
                    return result;
                result += CodeToWord(name.substring(0, 9));
                name = name.substring(9, name.length());
                p = name.indexOf("%e");
            }
        }
        name = result + name;*/
        try {
            bean.setName(URLDecoder.decode(name, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        bean.setNick(nick);
        bean.setOpenid(openid);
        bean.setOpenkey(openkey);
        bean.setRefreshToken(refresh_token);
        
        tctService.saveUserLoginInfo(bean);
        try {
            tctService.addStatus(bean, true);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
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
