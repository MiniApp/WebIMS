package com.ubiyao.sns.tencent.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ubiyao.base.tencent.util.StringUtils;

/**
 * 腾讯微博 应用和token实体类，主要用在api中
 * 
 * @author Trinea 2011-9-25 下午11:41:38
 */
@Component("qqTAppAndToken")
public class TAppAndToken implements Serializable {

    private static final long serialVersionUID = 5951645915037611059L;

    /** 应用key **/
    private String            appKey;
    /** 应用密码 **/
    private String            appSecret;
    /** access token **/
    private String            accessToken;
    private String			  openid;
    private String 			  oauthVersion;
    private String			  scope;
    /** token 密码 ，可为空 **/
    private String            tokenSecret;

    /**
     * 检验是否合法
     * 
     * @return
     */
    public boolean isValid() {
        return !(StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret) || StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(tokenSecret));
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOauthVersion() {
		return oauthVersion;
	}

	public void setOauthVersion(String oauthVersion) {
		this.oauthVersion = oauthVersion;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
