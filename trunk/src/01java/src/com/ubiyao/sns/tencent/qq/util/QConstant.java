package com.ubiyao.sns.tencent.qq.util;

public class QConstant {

    /** 消息句柄部分 **/
    public final static int    UPDATE_STATUS_SUCC_WHAT               = 70;
    public final static int    UPDATE_STATUS_FAIL_WHAT               = -70;
    public final static int    COMMENT_STATUS_SUCC_WHAT              = 71;
    public final static int    COMMENT_STATUS_FAIL_WHAT              = -71;
    public final static int    REPOST_STATUS_SUCC_WHAT               = 72;
    public final static int    REPOST_STATUS_FAIL_WHAT               = -72;
    public static String       OPERATOR_FAIL_REASON                  = "";

    /** OAuth认证部分 **/
    public final static String GET_AUTHORIZATION_URL                 = "https://graph.qq.com/oauth2.0/authorize";
    public final static String GET_ACCESS_TOKEN_URL                  = "https://open.t.qq.com/cgi-bin/oauth2/access_token";
    public final static String GET_OPENID_URL                        = "https://graph.qq.com/oauth2.0/me";
}
