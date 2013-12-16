package im.shs.service;

import im.shs.action.WeiboLoginAction;
import im.shs.bean.WeiBoContentBean;

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

import com.tencent.weibo.api.StatusesAPI;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;

@Service("weiboService")
public class WeiBoServiceImpl implements WeiBoService {
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
        url.append("&response_type=code&redirect_uri=");
        url.append(redirect_URI);
        url.append("&state=");
        url.append(state);
        logger.info("Tencent Weibo address:" + url);
        return url.toString();
    }

    @Override
	public Map<String, Object> tencentWeiboLogin(String code_temp) throws UnsupportedEncodingException {
	    init(oAuth);
	    Map<String, Object> returnData= new HashMap<String, Object>();
	    String urlTokens = "";
	    String m = "";
	    WeiBoContentBean bean = new WeiBoContentBean();
	    // 读取资源文件
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI");
        String redirect_uri_succ_temp = resource.getString("redirect_URI_SUCC");
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
        NameValuePair code = new NameValuePair("code", code_temp);
        NameValuePair state = new NameValuePair("state", state_temp);
        NameValuePair[] params = new NameValuePair[] { client_id, client_secret, redirect_uri, grant_type, code, state };
        String result = this.doHttpClient(url, params);
        logger.info("result:" + result);
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
                urlTokens = redirect_uri_succ_temp;
                logger.info("urlToken:" + urlTokens);
                String s = (String) code_map.get("nick");
                byte[] tmpByteArray = s.getBytes("iso-8859-1");
                s = new String(tmpByteArray, "UTF-8");
                logger.info("Nick name: " + s);
                oAuth.setOpenid((String) code_map.get("openid"));
                String responseData = result;
                if (OAuthV2Client.parseAccessTokenAndOpenId(responseData, oAuth)) {
                    logger.info("Get Access Token Successfully!");
                    StatusesAPI statusesAPI = new StatusesAPI(oAuth.getOauthVersion());
                    //String response;
                    String format = "json";
                    /*String clientip = "127.0.0.1";
                    String jing = "";
                    String wei = "";
                    String syncflag = "";*/
                    String pageflag = "0";
                    String pagetime = "0";
                    String reqnum = "5";
                    String lastid = "'0";
                    String contenttype = "0";
                    /*String content = "3";// 注意：因为后台会对微博内容进行判重，所以在重复测试时加上变换部分++++++++
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
                    String sorttype = "0";*/
                    String type = "0";
                    /*String op = "0";
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
                    */
                    try {
                        m = statusesAPI.broadcastTimeline(oAuth, format, pageflag, pagetime, reqnum, lastid, type, contenttype);
                        logger.info(m);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    logger.info("Fail to Get Access Token!");
                }
            }
        }
        
        returnData.put("urlTokens", urlTokens);
        returnData.put("data", m);
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
}