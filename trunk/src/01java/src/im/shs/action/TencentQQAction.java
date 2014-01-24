package im.shs.action;

import im.shs.base.Constants;
import im.shs.bean.TUserLoginBean;
import im.shs.service.TencentQQService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

@Component("tencentQQAction")
@Scope("prototype")
public class TencentQQAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
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
        url = tctQQService.tencentQQLoginInit();
        return "tencentQQLoginInitRedirect";
        
    }

    public String tencentQQLogin() {

        return "tencentQQLoginSuccess";
    }

    public String tencentQQLoginCheck() {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            TUserLoginBean bean = new TUserLoginBean();
            bean.setAccessToken(access_token);
            bean.setExpiresIn(Integer.parseInt(expires_in));
            bean.setName(name);

            bean.setNick(URLDecoder.decode(nick, "UTF-8"));

            bean.setOpenid(openid);
            bean.setOpenkey(openkey);
            bean.setRefreshToken(refresh_token);
            
            if (Constants.RESULT_NEED_TO_ADD.equals(tctQQService.checkUserLoginInfo(bean))) {
                tctQQService.addUserLoginInfo(bean);
            } else if (Constants.RESULT_NEED_TO_MERGE.equals(tctQQService.checkUserLoginInfo(bean))) {
                tctQQService.mergeUserLoginInfo(bean);
            }

            String accessTokenVal = (String) request.getSession().getAttribute("accessToken");
            String userNameVal = (String) request.getSession().getAttribute("userName");
            Boolean isLogin = false;
            if (!"".equals(accessTokenVal) && !"".equals(userNameVal)) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("clientUserName", userNameVal);
                map.put("clientAccessToken", accessTokenVal);
                if (null != map.get("clientAccessToken")) {
                    isLogin = tctQQService.checkTencentLogin(map);
                }
            }

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
                tctQQService.addStatus(albean, false);
            } else {
                tctQQService.addStatus(bean, true);
            }
            Cookie accessToken = new Cookie("accessToken", bean.getAccessToken());
            accessToken.setMaxAge(60 * 60 * 24 * 93);
            Cookie uerName = new Cookie("userName", bean.getName());
            uerName.setMaxAge(60 * 60 * 24 * 93);
            response.addCookie(accessToken);
            response.addCookie(uerName);

            out.println("{\"welcome\":\"welcome\"}");
            //out.write("["+json.toString()+"]");
            out.flush();
            out.close();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String tencentQQShow() {
        Map<String, String> map = new HashMap<String, String>();
        Cookie allCookie[] = request.getCookies();

        if (allCookie != null && allCookie.length != 0) {
            for (int i = 0; i < allCookie.length; i++) {
                String keyname = allCookie[i].getName();
                if ("accessToken".equals(keyname)) {
                    map.put("clientAccessToken", allCookie[i].getValue());
                }
                if ("userName".equals(keyname)) {
                    map.put("clientUserName", allCookie[i].getValue());
                }
            }
        }
        if (null != map.get("clientAccessToken") && null != map.get("clientUserName") && tctQQService.checkTencentLogin(map)) {
            request.getSession().setAttribute("clientAccessToken", map.get("clientAccessToken"));
            return "tencentWeiboSuccess";
        } else {
            return "tencentWeiboFail";
        }
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
