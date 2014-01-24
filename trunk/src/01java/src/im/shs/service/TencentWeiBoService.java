/**    
 * Class Name：	
 *			TctService.java
 * Version：	1.1   
 * Date：	2013-12-20       
 * Copyright	
 */
package im.shs.service;

import im.shs.bean.TUserLoginBean;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.ubiyao.sns.tencent.weibo.entity.TStatus;

/**    
 *         
 * Class Name：
 *			TencentWeiBoService    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2014-1-24 下午1:20:17    
 * @Version	
 *     
 */
public interface TencentWeiBoService {
    public void addStatus(TUserLoginBean bean, Boolean isLogin) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException;
	public List<TStatus> getBroadcastTL()throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException;
    public String tencentWeiboLoginInit();
    public String checkUserLoginInfo(TUserLoginBean bean);
    public void addUserLoginInfo(TUserLoginBean bean);
    public void mergeUserLoginInfo(TUserLoginBean bean);
    @SuppressWarnings("rawtypes")
    public Boolean checkTencentLogin(Map map);
    public void batchAddStatus();
}
