package im.shs.service;

import im.shs.action.WeiboLoginAction;
import im.shs.base.AbstractService;
import im.shs.base.Constants;
import im.shs.base.util.DateUtil;
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.ubiyao.sns.tencent.weibo.entity.TAppAndToken;
import com.ubiyao.sns.tencent.weibo.entity.TStatus;
import com.ubiyao.sns.tencent.weibo.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.weibo.service.impl.TSdkServiceImpl;

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

    TAppAndToken qqTAppAndToken;

    @Resource(name = "tSdkService")
    private TSdkServiceImpl tSdkService;

    List<TStatus> statusList;

    public void initInfoByLogin(TUserLoginBean bean) {
        qqTAppAndToken = new TAppAndToken();
        qqTAppAndToken.setAppKey(QQT_APP_KEY);
        qqTAppAndToken.setAccessToken(bean.getAccessToken());
        qqTAppAndToken.setOpenid(bean.getOpenid());
        qqTAppAndToken.setScope("all");

        tSdkService.setQqTAppAndToken(qqTAppAndToken);
        statusList = new ArrayList<TStatus>();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void initInfoBySave(TUserLoginBean bean) {
        qqTAppAndToken = new TAppAndToken();
        qqTAppAndToken.setAppKey(QQT_APP_KEY);
        qqTAppAndToken.setAccessToken(bean.getAccessToken());
        Map map = new HashMap();
        map.put("name", bean.getName());
        map.put("access_token", bean.getAccessToken());
        TUserLginInfo po = this.getPersist().findObjectByFields(TUserLginInfo.class, map);
        if (null != po) {
            qqTAppAndToken.setOpenid(po.getOpenid()); 
        }
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
    public void addStatus(TUserLoginBean bean, Boolean isLogin) throws InvalidKeyException, NoSuchAlgorithmException,
            UnsupportedEncodingException {
        if (!isLogin) {
            initInfoByLogin(bean);
        } else {
            initInfoBySave(bean);
        }
        TStatusInfoPara status = new TStatusInfoPara();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        status.setStatusContent(sdf.format(new Date()));
        /** 设置音乐地址 **/
        tSdkService.addStatus(status);
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
     * Method：  checkUserLoginInfo
     *
     * Description： 
     *          描述
     * @Param   name
     *          参数 
     * @Return  String DOM对象    
     * @Author  suhao 
     * @Since   
     */
    @Override
    public String checkUserLoginInfo(TUserLoginBean bean) {
        TUserLginInfo po = this.getPersist().findObjectByField(TUserLginInfo.class, "name", bean.getName());
        if (null == po) {
            return Constants.RESULT_NEED_TO_ADD;
        } else {
            HashMap<String, String> para = new HashMap<String, String>();
            para.put("name", bean.getName());
            para.put("access_token", bean.getAccessToken());
            TUserLginInfo pos = this.getPersist().findObjectByFields(TUserLginInfo.class, para);
            if (null == pos) {
                return Constants.RESULT_NEED_TO_MERGE;
            }
        }
        return null;
    }
    
    /**    
     * Method：	addUserLoginInfo
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
    public void addUserLoginInfo(TUserLoginBean bean) {
        TUserLginInfo po = new TUserLginInfo();
        po.setAccessToken(bean.getAccessToken());
        po.setExpiresIn(bean.getExpiresIn());
        po.setName(bean.getName());
        po.setNick(bean.getNick());
        po.setOpenid(bean.getOpenid());
        po.setOpenkey(bean.getOpenkey());
        po.setRefreshToken(bean.getRefreshToken());
        po.setExpiresDate(new Date());
        this.getPersist().persist(po);
    }
    
    /**    
     * Method：  mergeUserLoginInfo
     *
     * Description： 
     *          描述
     * @Param   name
     *          参数 
     * @Return  String DOM对象    
     * @Author  suhao 
     * @Since   
     */
    @Override
    public void mergeUserLoginInfo(TUserLoginBean bean) {
        TUserLginInfo po = this.getPersist().findObjectByField(TUserLginInfo.class, "name", bean.getName());
        po.setAccessToken(bean.getAccessToken());
        po.setExpiresIn(bean.getExpiresIn());
        po.setName(bean.getName());
        po.setNick(bean.getNick());
        po.setOpenid(bean.getOpenid());
        po.setOpenkey(bean.getOpenkey());
        po.setRefreshToken(bean.getRefreshToken());
        po.setUpdateTime(DateUtil.getNow());
        //pos.setExpiresDate(new Date());
        
        this.getPersist().merge(po);
    }

    /**    
     * Method：	checkTencentLogin
     *
     * Description：	
     *			描述
     * @Param  	name
     *			参数 
     * @Return	String DOM对象    
     * @Author	suhao 
     * @Since   
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Boolean checkTencentLogin(Map map) {
        Map params = new HashMap();
        params.put("name", map.get("clientUserName"));
        params.put("access_token", map.get("clientAccessToken"));
        TUserLginInfo po = (TUserLginInfo) this.getPersist().findObjectByFields(TUserLginInfo.class, params);
        if (null != po) {
            return true;
        } else {
            return false;
        }
    }

	/**    
	 * Method：	batchAddStatus
	 *
	 * Description：	
	 *			描述
	 * @Param  	name
	 *			参数 
	 * @Return	String DOM对象    
	 * @Author	suhao 
	 * @Since   
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void batchAddStatus() {
		List<TUserLoginBean> ul = (List<TUserLoginBean>) this.getPersist().findListBySqlMap("tencent.getUserList", null);
		
		for (TUserLoginBean bean : ul) {
			qqTAppAndToken = new TAppAndToken();
	        qqTAppAndToken.setAppKey(QQT_APP_KEY);
	        qqTAppAndToken.setAccessToken(bean.getAccessToken());
	        qqTAppAndToken.setOpenid(bean.getOpenid());
	        qqTAppAndToken.setScope("all");

	        tSdkService.setQqTAppAndToken(qqTAppAndToken);
	        
	        TStatusInfoPara status = new TStatusInfoPara();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        status.setStatusContent(sdf.format(new Date()));
	        try {
				tSdkService.addStatus(status);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
}
