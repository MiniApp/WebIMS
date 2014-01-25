package com.ubiyao.sns.tencent.qq.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;

import com.ubiyao.sns.tencent.qq.entity.QAddSharePara;
import com.ubiyao.sns.tencent.qq.entity.QAppAndToken;
import com.ubiyao.sns.tencent.qq.entity.QUserInfo;

public interface TQQSdkService {

    /**
     * 得到应用和用户相关信息
     * 
     * @return
     */
    public QAppAndToken getQAppAndToken();

    /**
     * 设置应用和用户相关信息
     * 
     * @param qqTAppAndToken
     */
    public void setQAppAndToken(QAppAndToken qAppAndToken);
    public String getUserInfo(String format)  throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException;
    public QUserInfo getUserInfo() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, JSONException;
    public String addShare(String addUrl, QAddSharePara para);
}
