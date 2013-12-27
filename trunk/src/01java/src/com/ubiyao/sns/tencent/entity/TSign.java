package com.ubiyao.sns.tencent.entity;

import java.io.Serializable;
import java.util.Map;

import com.ubiyao.base.tencent.util.MapUtils;
import com.ubiyao.base.tencent.util.StringUtils;

/**
 * 腾讯微博 签名实体类
 * 
 * @author Trinea 2011-9-22 上午12:42:23
 */
public class TSign implements Serializable {

    private static final long   serialVersionUID = 5163404287174100668L;

    /** 根url **/
    private String              baseUrl;
    /** url提交方式 **/
    private String              httpMethod;
    /** 应用密码 **/
    private String              appSecret;
    /** token 密码 ，可为空 **/
    private String              tokenSecret;
    //shuao add start
    private String              openid;
    private String              appKey;
    private String              accessToken;
    //shuao add end
    /** 参数map **/
    private Map<String, String> parasMap;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public Map<String, String> getParasMap() {
        return parasMap;
    }

    public void setParasMap(Map<String, String> parasMap) {
        this.parasMap = parasMap;
    }

    /**
     * 检验是否合法
     * 
     * @return
     */
    public boolean isValid() {
        return !(StringUtils.isEmpty(baseUrl) || StringUtils.isEmpty(httpMethod) || StringUtils.isEmpty(appSecret) || MapUtils.isEmpty(parasMap));
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

}
