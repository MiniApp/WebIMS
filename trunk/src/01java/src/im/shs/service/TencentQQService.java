package im.shs.service;

import im.shs.bean.TUserLoginBean;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**    
 *         
 * Class Name：
 *			TencentQQService    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2014-1-24 下午1:19:39    
 * @Version	
 *     
 */
public interface TencentQQService {
    public void addStatus(TUserLoginBean bean, Boolean isLogin) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException;
    public String tencentQQLoginInit();
    public String checkUserLoginInfo(TUserLoginBean bean);
    public void addUserLoginInfo(TUserLoginBean bean);
    public void mergeUserLoginInfo(TUserLoginBean bean);
    @SuppressWarnings("rawtypes")
    public Boolean checkTencentLogin(Map map);
    public void batchAddStatus();
}
