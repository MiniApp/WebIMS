package im.shs.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;

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
    public String tencentQQLoginInit();
    public String getUserInfo() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException;
    public String addShare();
}
