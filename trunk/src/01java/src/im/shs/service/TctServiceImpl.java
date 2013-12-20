/**    
 * Class Name：	
 *			TestQTServiceImpl.java
 * Version：	1.1   
 * Date：	2013-12-20       
 * Copyright	
 */
package im.shs.service;

import im.shs.base.AbstractService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
    ResourceBundle resource = ResourceBundle.getBundle("tencentWeiboConfig");// 这个配置文件是我自己创建的

    /** 应用key **/
    String QQT_APP_KEY = resource.getString("client_ID");

    /** 应用secret **/
    String QQT_APP_SECRET = resource.getString("client_SERCRET");

    /** 用户accesstoken **/
    String ACCESS_TOKEN = "38fc777338dfb01ea1a23ab163c15e77";

    /** 用户tokenSecret **/
    String TOKEN_SECRET = "***";

    @Resource(name = "qqTAppAndToken")
    TAppAndToken qqTAppAndToken;

    @Resource(name = "tSdkService")
    private TSdkServiceImpl tSdkService;

    List<TStatus> statusList;

    public void init() {
        //qqTAppAndToken = new TAppAndToken();
        qqTAppAndToken.setAppKey(QQT_APP_KEY);
        qqTAppAndToken.setAppSecret(QQT_APP_SECRET);
        qqTAppAndToken.setAccessToken(ACCESS_TOKEN);
        qqTAppAndToken.setTokenSecret(TOKEN_SECRET);

        tSdkService = new TSdkServiceImpl();
        tSdkService.setQqTAppAndToken(qqTAppAndToken);
        statusList = new ArrayList<TStatus>();
    }

    /**    
     * Method：	addStatus
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
    public void addStatus() {
        TStatusInfoPara status = new TStatusInfoPara();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        status.setStatusContent(dateStr+" ^_^");
        /** 设置精度和纬度，可不设置 **/
        status.setLatitude(23.4);
        status.setLongitude(110.5);
        tSdkService.addStatus(status);
        System.out.println("1122 " + tSdkService.addStatus(status));
    }

    
}
