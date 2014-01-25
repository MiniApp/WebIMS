package com.ubiyao.sns.tencent.qq.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ubiyao.base.tencent.weibo.util.JSONUtils;
import com.ubiyao.base.tencent.weibo.util.MapUtils;
import com.ubiyao.base.tencent.weibo.util.StringUtils;
import com.ubiyao.sns.tencent.qq.entity.QAddSharePara;
import com.ubiyao.sns.tencent.qq.entity.QAppAndToken;
import com.ubiyao.sns.tencent.qq.entity.QUserInfo;
import com.ubiyao.sns.tencent.qq.util.QCheckAndTransUtils;
import com.ubiyao.sns.tencent.qq.util.QConstant;
import com.ubiyao.sns.tencent.qq.util.QParaMapUtils;
import com.ubiyao.sns.tencent.qq.util.QSignAndHttpUtils;
import com.ubiyao.sns.tencent.qq.util.QTransformUtils;
import com.ubiyao.sns.tencent.weibo.util.TConstant;

@Service("qqSdkService")
public class TQQSdkServiceImpl implements TQQSdkService {

    /** 应用和用户相关信息 **/
    @Resource(name = "qAppAndToken")
    private QAppAndToken qAppAndToken;

	/**    
	 * Method：	getQAppAndToken
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
	public QAppAndToken getQAppAndToken() {
		return qAppAndToken;
	}

	/**    
	 * Method：	setQAppAndToken
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
	public void setQAppAndToken(QAppAndToken qAppAndToken) {
		this.qAppAndToken = qAppAndToken;
	}

	/**    
	 * Method：	getSelfInfo
	 * 
	 * Description：	
	 *			描述
	 * @throws JSONException 
	 * @Param  	name
	 *			参数 
	 * @Return	String DOM对象   
	 * @Author	suhao 
	 * @Since   
	 */
	public String getUserInfo(String format) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException {
        if (StringUtils.isEmpty(format) || qAppAndToken == null || !qAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QParaMapUtils.getStandardParaMap(qAppAndToken);
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        String jsonStr = QSignAndHttpUtils.signAndHttpGet(QConstant.GET_USER_INFO, parasMap, qAppAndToken);
        JSONObject jsonObj = new JSONObject(jsonStr);

        return jsonObj.toString();
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
	public QUserInfo getUserInfo() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException {
		String selfInfo = getUserInfo(QConstant.VALUE_FORMAT_JSON);
        if (StringUtils.isEmpty(selfInfo) || !QCheckAndTransUtils.checkModifyResult(selfInfo)) {
            return null;
        }
        return QTransformUtils.transUserInfo(JSONUtils.getJSONObject(selfInfo, null));
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
	public String addShare(String addUrl, QAddSharePara para) {
		if (para == null || qAppAndToken == null || !qAppAndToken.isValid() || StringUtils.isEmpty(addUrl)) {
            return null;
        }
		Map<String, String> parasMap = QParaMapUtils.getStdAddShareParaMap(qAppAndToken, para);
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
		
		return QSignAndHttpUtils.signAndHttpPostEncodeParas(addUrl, parasMap, qAppAndToken);
	}

}
