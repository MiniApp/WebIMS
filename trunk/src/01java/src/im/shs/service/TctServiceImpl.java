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
    String OPEN_ID = "3a813b88f49fd49170bb32190f96a6b7";

    /** 用户tokenSecret **/
    String TOKEN_SECRET = "***";

    TAppAndToken qqTAppAndToken;
    @Resource(name="tSdkService")
    private TSdkServiceImpl tSdkService;

    List<TStatus> statusList;

    public void init() {
        qqTAppAndToken = new TAppAndToken();
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
    	init();
    	TStatusInfoPara status = new TStatusInfoPara();
        status.setStatusContent("发表音乐微博");
        /** 设置音乐地址 **/
        status.setMusicUrl("http://201112.wma.9ku.com/file2/183/182737.mp3");
        status.setMusicAuthor("张芸京");
        status.setMusicTitle("偏爱");
        String s1 = tSdkService.addMusicStatusStr(status);

        status.setStatusContent("发表视频微博");
        /** 设置视频地址 **/
       /* status.setVideoUrl("http://v.youku.com/v_show/id_XMjUzOTg3MDY0.html");
        String s2 = tSdkService.addVideoStatusStr(status);*/
        System.out.println(s1 + "\n"/*+ s2*/);
    }
}
