/**    
 * Class Name：	
 *			AppConst.java
 * Version：	1.1   
 * Date：	2013-12-30       
 * Copyright	
 */
package com.t.bean;

import java.io.Serializable;

/**    
 *         
 * Class Name：
 *			AppConst    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-30 下午5:21:49    
 * @Version	
 *     
 */
public class AuthBean implements Serializable {
    private static final long serialVersionUID = 5951645915037611059L;
    //Step 1 ：请求code
    private String clientId;
    private String responseType;
    private String redirectUri;
    
    private String code;
    private String openid;
    private String openkey;
    
    //Step 2 ：请求accesstoken
    private String clientSecret;
    private String grantType;
    private String state;
    
    private String accessToken;
    private String expiresIn;
    private String refreshToken;
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getResponseType() {
        return responseType;
    }
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
    public String getRedirectUri() {
        return redirectUri;
    }
    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getOpenkey() {
        return openkey;
    }
    public void setOpenkey(String openkey) {
        this.openkey = openkey;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public String getGrantType() {
        return grantType;
    }
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
