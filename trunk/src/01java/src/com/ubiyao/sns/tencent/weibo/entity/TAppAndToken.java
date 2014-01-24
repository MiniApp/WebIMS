package com.ubiyao.sns.tencent.weibo.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ubiyao.base.tencent.weibo.util.StringUtils;

/**
 * 腾讯微博 应用和token实体类，主要用在api中
 * 
 * @author Trinea 2011-9-25 下午11:41:38
 */
@Component("qqTAppAndToken")
public class TAppAndToken implements Serializable {

    private static final long serialVersionUID = 5951645915037611059L;

    /** 应用key **/
    private String appKey;
    
    private String appSecret;

    /** access token **/
    private String accessToken;

    private String openid;

    private String clientip;

    private String oauthVersion;

    private String scope;

    /**
     * 检验是否合法
     * 
     * @return
     */
    public boolean isValid() {
        return !(StringUtils.isEmpty(appKey) || StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(openid));
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

}
