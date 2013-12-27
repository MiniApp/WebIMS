package com.ubiyao.base.tencent.util;

import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.ubiyao.sns.tencent.util.Base64Encoder;

/**    
 *         
 * Class Name：
 *			SignatureUtils    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-24 下午5:19:25    
 * @Version	
 *     
 */
public class SignatureUtils {
	
	//签名
	public static String getSignature(String baseString,String key){
		String returnStr="";
		Mac mac = null;
		byte[] byteHMAC = null;
		try {
			mac = Mac.getInstance("HmacSHA1");
			SecretKeySpec spec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			mac.init(spec);
			byteHMAC = mac.doFinal(baseString.getBytes());
			returnStr = Base64Encoder.encode(byteHMAC);
			//returnStr=URLEncoder.encode(returnStr,ENCODING);
		} catch (Exception e1) {
			returnStr="error";
			e1.printStackTrace();
		}
		return returnStr;
	}
	
	/*
	 * 获取随机字符串
	 * 实现方法很多，也很简单，但是对这种简单的东西，开发者有时候就是不想去敲键盘
	 * 但是不敲就做不下去，本来在此愿意成全和我一样有此烦恼的开发者
	 */
	public static String getRandomString(int len){
		String returnStr="";
		char[] ch=new char[len];
		Random rd=new Random();
		for(int i=0;i<len;i++){
			ch[i]=(char)(rd.nextInt(9)+97);
		}
		returnStr=new String(ch);
		return returnStr;
	}
}
