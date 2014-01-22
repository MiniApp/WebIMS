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

import com.ubiyao.sns.tencent.entity.TStatus;

/**    
 *         
 * Class Name：
 *			TctService    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-20 下午3:12:57    
 * @Version	
 *     
 */
public interface TctService {
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
