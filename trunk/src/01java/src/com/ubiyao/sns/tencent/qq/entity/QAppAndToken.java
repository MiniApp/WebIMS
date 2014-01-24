package com.ubiyao.sns.tencent.qq.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ubiyao.base.tencent.weibo.util.StringUtils;

/**
 * 腾讯微博 应用和token实体类，主要用在api中
 * 
 * @author Trinea 2011-9-25 下午11:41:38
 */
@Component("qAppAndToken")
public class QAppAndToken implements Serializable {

    private static final long serialVersionUID = 5951645915037611059L;

    /** 应用key **/
    private String appKey;

    /** access token **/
    private String accessToken;

    private String openid;

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


}
