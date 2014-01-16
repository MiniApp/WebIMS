/**    
 * Class Name：	
 *			TestQTServiceImpl.java
 * Version：	1.1   
 * Date：	2013-12-20       
 * Copyright	
 */
package im.shs.service;

import im.shs.action.WeiboLoginAction;
import im.shs.base.AbstractService;
import im.shs.bean.TUserLoginBean;
import im.shs.model.TUserLginInfo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ubiyao.base.tencent.util.HttpClientUtil;
import com.ubiyao.sns.tencent.entity.TAppAndToken;
import com.ubiyao.sns.tencent.entity.TStatus;
import com.ubiyao.sns.tencent.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.service.impl.TSdkServiceImpl;

/**    
 *         
 * Class Name：
 *			TestQTServiceImpl    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-20 下午2:41:20    
 * @Version	
 *     
 */
@Service("tctService")
public class TctServiceImpl extends AbstractService implements TctService {
    private final Log logger = LogFactory.getLog(WeiboLoginAction.class);
    ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的

    /** 应用key **/
    String QQT_APP_KEY = resource.getString("client_ID");

    /** 应用secret **/
    String QQT_APP_SECRET = resource.getString("client_SERCRET");

    /** 用户accesstoken **/
    String ACCESS_TOKEN = "38fc777338dfb01ea1a23ab163c15e77";
    String OPEN_ID = "3a813b88f49fd49170bb32190f96a6b7";

    /** 用户tokenSecret **/
    String TOKEN_SECRET = "AfdQ24Hk";

    TAppAndToken qqTAppAndToken;
    @Resource(name="tSdkService")
    private TSdkServiceImpl tSdkService;

    List<TStatus> statusList;

    public void init() {
        qqTAppAndToken = new TAppAndToken();
        qqTAppAndToken.setAppKey(QQT_APP_KEY);
        qqTAppAndToken.setAccessToken(ACCESS_TOKEN);
        qqTAppAndToken.setOpenid(OPEN_ID);
        qqTAppAndToken.setScope("all");

        tSdkService = new TSdkServiceImpl();
        tSdkService.setQqTAppAndToken(qqTAppAndToken);
        statusList = new ArrayList<TStatus>();
    }

    /**    
     * Method：	addStatus
     *
     * Description：	
     *			描述
     * @throws UnsupportedEncodingException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeyException 
     * @Param  	name
     *			参数 
     * @Return	String DOM对象    
     * @Author	suhao 
     * @Since   
     */
    @Override
    public void addStatus() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    	init();
    	TStatusInfoPara status = new TStatusInfoPara();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        status.setStatusContent("呵呵");
        /** 设置音乐地址 **/
        tSdkService.addStatus(status);
/*
        status.setStatusContent("发表视频微博");
        *//** 设置视频地址 **//*
        status.setVideoUrl("http://v.youku.com/v_show/id_XMjUzOTg3MDY0.html");
        String s2 = tSdkService.addVideoStatusStr(status);
        System.out.println(s1 + "\n"+ s2);
        
        ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的
        String client_id_temp = resource.getString("client_ID");
        String client_secret_temp = resource.getString("client_SERCRET");
        String redirect_uri_temp = resource.getString("redirect_URI");
        String redirect_uri_succ_temp = resource.getString("redirect_URI_SUCC");
        String grant_type_temp = resource.getString("grant_TYPE");
        String state_temp = resource.getString("state");
        String url = resource.getString("accessTokenURL");
        NameValuePair client_id = new NameValuePair("client_id", client_id_temp);
        NameValuePair client_secret = new NameValuePair("client_secret", client_secret_temp);
        NameValuePair redirect_uri = new NameValuePair("redirect_uri", redirect_uri_temp);
        NameValuePair grant_type = new NameValuePair("grant_type", grant_type_temp);
        NameValuePair code = new NameValuePair("code", "1c249a4d9ac5ad3ece1cfd1ad0c398b5");
        NameValuePair state = new NameValuePair("state", state_temp);
        NameValuePair[] params = new NameValuePair[] { client_id, client_secret, redirect_uri, grant_type, code, state };
        String result = this.doHttpClient(url, params);
        logger.info("result:" + result);*/
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
    private Map getUrl(){
        
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
        NameValuePair client_id_p = new NameValuePair("client_id", client_ID);
        NameValuePair response_type_p = new NameValuePair("response_type", "code");
        NameValuePair redirect_uri_p = new NameValuePair("redirect_uri", redirect_URI);
        NameValuePair state_p = new NameValuePair("state", state);
        NameValuePair[] params = new NameValuePair[] { client_id_p, response_type_p, redirect_uri_p, state_p };
        Map map = new HashMap();
        map.put("url", authorizeURL);
        map.put("params", params);
        return map;
    } 
    
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
        logger.info("Tencent Weibo address:" + url);
        return url.toString();
    }

    /**    
     * Method：	saveUserLoginInfo
     *
     * Description：	
     *			描述
     * @Param  	name
     *			参数 
     * @Return	String DOM对象    
     * @Author	suhao 
     * @Since   
     */
    @Override
    public void saveUserLoginInfo(TUserLoginBean bean) {
        TUserLginInfo po = this.getPersist().findObjectByField(TUserLginInfo.class, "name", bean.getName());
        
        if (null != po) {
            po.setAccessToken(bean.getAccessToken());
            po.setExpiresIn(bean.getExpiresIn());
            po.setName(bean.getName());
            po.setNick(bean.getNick());
            po.setOpenid(bean.getOpenid());
            po.setOpenkey(bean.getOpenkey());
            po.setRefreshToken(bean.getRefreshToken());
            //po.setExpiresDate(new Date());
            this.getPersist().merge(po);
        } else {
            TUserLginInfo ponew = new TUserLginInfo();
            ponew.setAccessToken(bean.getAccessToken());
            ponew.setExpiresIn(bean.getExpiresIn());
            ponew.setName(bean.getName());
            ponew.setNick(bean.getNick());
            ponew.setOpenid(bean.getOpenid());
            ponew.setOpenkey(bean.getOpenkey());
            ponew.setRefreshToken(bean.getRefreshToken());
            ponew.setExpiresDate(new Date());
            this.getPersist().persist(ponew);
        }
        
    }
    
}
