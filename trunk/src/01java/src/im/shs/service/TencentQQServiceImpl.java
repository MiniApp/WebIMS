package im.shs.service;

import im.shs.action.WeiboLoginAction;
import im.shs.base.AbstractService;
import im.shs.base.util.StringUtils;
import im.shs.bean.TUserLoginBean;
import im.shs.model.TUserLginInfo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.ubiyao.sns.tencent.qq.entity.QAddSharePara;
import com.ubiyao.sns.tencent.qq.entity.QAppAndToken;
import com.ubiyao.sns.tencent.qq.service.TQQSdkServiceImpl;
import com.ubiyao.sns.tencent.qq.util.QConstant;
import com.ubiyao.sns.tencent.weibo.entity.TStatus;

/**    
 *         
 * Class Name：
 *			TencentQQServiceImpl    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2014-1-24 下午1:19:52    
 * @Version	
 *     
 */
@Service("tctQQService")
public class TencentQQServiceImpl extends AbstractService implements TencentQQService {
    private final Log logger = LogFactory.getLog(WeiboLoginAction.class);

    ResourceBundle resource = ResourceBundle.getBundle("tencentQQConfig");// 这个配置文件是我自己创建的

    /** 应用key **/
    String QQT_APP_KEY = resource.getString("client_ID");

    /** 应用secret **/
    public String QQT_APP_SECRET = resource.getString("client_SERCRET");

    QAppAndToken qAppAndToken;

    @Resource(name = "qqSdkService")
    private TQQSdkServiceImpl qqSdkService;

    List<TStatus> statusList;

    public void initInfoByLogin(TUserLoginBean bean) {
        qAppAndToken = new QAppAndToken();
        qAppAndToken.setAppKey(QQT_APP_KEY);
        qAppAndToken.setAccessToken(bean.getAccessToken());
        qAppAndToken.setOpenid(bean.getOpenid());

        qqSdkService.setQAppAndToken(qAppAndToken);
        statusList = new ArrayList<TStatus>();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void initInfoBySave(TUserLoginBean bean) {
        qAppAndToken = new QAppAndToken();
        qAppAndToken.setAppKey(QQT_APP_KEY);
        qAppAndToken.setAccessToken(bean.getAccessToken());
        Map map = new HashMap();
        map.put("name", bean.getName());
        map.put("access_token", bean.getAccessToken());
        TUserLginInfo po = this.getPersist().findObjectByFields(TUserLginInfo.class, map);
        if (null != po) {
            qAppAndToken.setOpenid(po.getOpenid()); 
        }

        qqSdkService.setQAppAndToken(qAppAndToken);
        statusList = new ArrayList<TStatus>();
    }

    
    @Override
    public String tencentQQLoginInit() {
        //ResourceBundle resource = ResourceBundle.getBundle("tencentQQConfig");// 这个配置文件是我自己创建的
        String client_ID = resource.getString("client_ID");
        String redirect_URI = resource.getString("redirect_URI");
        String authorizeURL = resource.getString("authorizeURL");
        //String state = resource.getString("state");

        StringBuffer url = new StringBuffer();
        url.append(authorizeURL);
        url.append("?client_id=");
        url.append(client_ID);
        url.append("&response_type=token&redirect_uri=");
        url.append(redirect_URI);
        logger.info("Tencent QQ address:" + url);
        return url.toString();
    }


	/**    
	 * Method：	getUserInfo
	 *
	 * Description：	
	 *			描述
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws JSONException 
	 * @Param  	name
	 *			参数 
	 * @Return	String DOM对象    
	 * @Author	suhao 
	 * @Since   
	 */
	@Override
	public String getUserInfo() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException {
		qAppAndToken = new QAppAndToken();
		qAppAndToken.setAppKey("101012073");
		qAppAndToken.setOpenid("0EFD8AF8DF8AC6FA5186EC31800FDD62");
		qAppAndToken.setAccessToken("41A76D4375591AD9ACE74E3BFCFBC0BF");
		qqSdkService.setQAppAndToken(qAppAndToken);
		logger.info(StringUtils.toString(qqSdkService.getUserInfo()));

		return qqSdkService.getUserInfo("json");
	}

	/**    
	 * Method：	addShare
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
	public String addShare() {
		qAppAndToken = new QAppAndToken();
		qAppAndToken.setAppKey("101012073");
		qAppAndToken.setOpenid("0EFD8AF8DF8AC6FA5186EC31800FDD62");
		qAppAndToken.setAccessToken("41A76D4375591AD9ACE74E3BFCFBC0BF");
		qqSdkService.setQAppAndToken(qAppAndToken);
		QAddSharePara para = new QAddSharePara();
		para.setTitle("test");
		para.setUrl("http://wephi.com");
		para.setComment("Hello World");
		para.setSite("半杯烟火");
		para.setFormat("json");
		para.setFromurl("http://wephi.com");
		return qqSdkService.addShare(QConstant.ADD_SHARE, para);
	}
}
