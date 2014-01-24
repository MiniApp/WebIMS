package im.shs.service;

import im.shs.action.WeiboLoginAction;
import im.shs.base.AbstractService;
import im.shs.model.TUserLginInfo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.tencent.weibo.oauthv2.OAuthV2;

@Service("weiboService")
public class WeiBoServiceImpl extends AbstractService implements WeiBoService {
    private final Log logger = LogFactory.getLog(WeiboLoginAction.class);

    private static OAuthV2 oAuth = new OAuthV2();

    @Override
    public String tencentWeiboLoginInit() {
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_ID = resource.getString("client_ID");
        String redirect_URI = resource.getString("redirect_URI");
        String authorizeURL = resource.getString("authorizeURL");
        String state = resource.getString("state");

        StringBuffer url = new StringBuffer();
        url.append(authorizeURL);
        url.append("?client_id=");
        url.append(client_ID);
        url.append("&response_type=token&redirect_uri=");
        url.append(redirect_URI);
        url.append("&state=");
        url.append(state);
        logger.info("Tencent Weibo address:" + url);
        return url.toString();
    }

    @Override
	public Map<String, Object> tencentWeiboLogin() throws UnsupportedEncodingException {
	    init(oAuth);
	    Map<String, Object> returnData= new HashMap<String, Object>();
	    // 读取资源文件
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI");
        String grant_type_temp = resource.getString("grant_TYPE");
        String state_temp = resource.getString("state");
        //String authorizeURL_temp = resource.getString("authorizeURL");

        // 根据授权之后产生的随机code我要再访问的地址
        String url = resource.getString("accessTokenURL");

        // 用httpclient模拟post方式访问,设置post方式 传递的参数
        NameValuePair client_id = new NameValuePair("client_id", client_id_temp);
        NameValuePair client_secret = new NameValuePair("client_secret", client_secret_temp);
        NameValuePair redirect_uri = new NameValuePair("redirect_uri", redirect_uri_temp);
        NameValuePair grant_type = new NameValuePair("grant_type", grant_type_temp);
        //NameValuePair code = new NameValuePair("code", code_temp);
        NameValuePair state = new NameValuePair("state", state_temp);
        NameValuePair[] params = new NameValuePair[] { client_id, client_secret, redirect_uri, grant_type, state };
        String result = this.doHttpClient(url, params);
        logger.info("result:" + result);

        return returnData;
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Boolean checkTencentLogin(Map map){
        Map params = new HashMap();
        //params.put("name", map.get("tctUserName"));
        params.put("access_token", map.get("clientAccessToken"));
        TUserLginInfo po = (TUserLginInfo) this.getPersist().findObjectByField(TUserLginInfo.class, "access_token", map.get("clientAccessToken"));
        if (null != po) {
            return true;
        } else {
            return false;
        }
    }
}