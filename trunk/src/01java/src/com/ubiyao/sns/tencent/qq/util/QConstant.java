package com.ubiyao.sns.tencent.qq.util;

public class QConstant {

	/** 消息句柄部分 **/
	public final static int	UPDATE_STATUS_SUCC_WHAT			= 70;
	public final static int UPDATE_STATUS_FAIL_WHAT			= -70;
	public final static int COMMENT_STATUS_SUCC_WHAT		= 71;
	public final static int COMMENT_STATUS_FAIL_WHAT		= -71;
	public final static int REPOST_STATUS_SUCC_WHAT			= 72;
	public final static int REPOST_STATUS_FAIL_WHAT			= -72;
	public static String	OPERATOR_FAIL_REASON			= "";

	/** OAuth认证部分 **/
	public final static String GET_AUTHORIZATION_URL		= "https://graph.qq.com/oauth2.0/authorize";
	public final static String GET_ACCESS_TOKEN_URL			= "https://open.t.qq.com/cgi-bin/oauth2/access_token";
	public final static String GET_OPENID_URL				= "https://graph.qq.com/oauth2.0/me";

	/** 发表微博api使用时的部分参数值 **/
	public final static String VALUE_FORMAT_JSON			= "json";
	public final static String VALUE_FORMAT_XML				= "xml";
	
	/** api 返回的部分参数 **/
	public final static String RET_PARA_MSG					= "msg";
	public final static String RET_PARA_RET					= "ret";

	/** api 返回的部分参数正常值 **/
	public final static String RET_VALUE_MSG				= "ok";
	public final static String RET_VALUE_MSG_NULL			= "";
	public final static int RET_VALUE_RET					= 0;

	/** API部分 **/
	public final static String GET_USER_INFO				= "https://graph.qq.com/user/get_user_info";
	public final static String ADD_SHARE 					= "https://graph.qq.com/share/add_share";
}
