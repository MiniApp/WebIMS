package im.shs.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Service;

import com.tencent.weibo.oauthv2.OAuthV2;
@Service("weiboService")
public class WeiBoServiceImpl implements WeiBoService {
	private static OAuthV2 oAuth = new OAuthV2();
	@Override
	public String tencentWeiboLoginInit(){
		ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
		String client_ID = resource.getString("client_ID");
		String redirect_URI = resource.getString("redirect_URI");
		String authorizeURL = resource.getString("authorizeURL");
		String state = resource.getString("state");

		StringBuffer url = new StringBuffer();
		url.append(authorizeURL);
		url.append("?client_id=");
		url.append(client_ID);
		url.append("&response_type=code&redirect_uri=");
		url.append(redirect_URI);
		url.append("&state=");
		url.append(state);
		System.out.println("==========:"+url);
		return url.toString(); 
	}
	@Override
	public void tencentWeiboLogin() {
		
	}
}