package com.ubiyao.sns.tencent.qq.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.ubiyao.base.tencent.weibo.util.JSONUtils;
import com.ubiyao.base.tencent.weibo.util.StringUtils;
import com.ubiyao.sns.tencent.qq.entity.QUserInfo;
import com.ubiyao.sns.tencent.weibo.entity.TResponse;

/**
 * 腾讯微博转换函数
 * 
 * @author Trinea 2011-10-27 上午12:09:37
 */
public class QTransformUtils {

    /**
     * 将从服务器返回的信息转换成QqTResponse
     * <ul>
     * <li>注意：不包含主体data的解析，需要自己set</li>
     * </ul>
     * 
     * @param responseObj
     * @return
     */
    public static TResponse transResponse(JSONObject responseObj) {
        if (responseObj == null) {
            return null;
        }

        TResponse qqTResponse = new TResponse();
        qqTResponse.setReturnStatus(JSONUtils.getInt(responseObj, "ret", -1));
        qqTResponse.setErrorCode(JSONUtils.getInt(responseObj, "errcode", -1));
        qqTResponse.setMessage(JSONUtils.getString(responseObj, "msg", ""));
        return qqTResponse;
    }

    /**
     * 将从服务器返回的信息转换成QqTResponse
     * 
     * @param responseStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transResponse(JSONObject)}</li>
     *         </ul>
     */
    public static TResponse transResponse(String responseStr) {
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }

        try {
            return transResponse(new JSONObject(responseStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户信息转换为对应的QUserInfo
     * 
     * @param userInfoObj 用户信息JsonObject
     * @return
     */
    public static QUserInfo transUserInfo(JSONObject userInfoObj) {
        if (userInfoObj == null) {
            return null;
        }

        QUserInfo user = new QUserInfo();
        user.setNickName(JSONUtils.getString(userInfoObj, "nickname", ""));
        user.setFigureUrl(JSONUtils.getString(userInfoObj, "figureurl", ""));
        user.setFigureUrl1(JSONUtils.getString(userInfoObj, "figureurl_1", ""));
        user.setFigureUrl2(JSONUtils.getString(userInfoObj, "figureurl_2", ""));
        user.setFigureUrlQq1(JSONUtils.getString(userInfoObj, "figureurl_qq_1", ""));
        user.setFigureUrlQq2(JSONUtils.getString(userInfoObj, "figureurl_qq_2", ""));
        user.setGender(JSONUtils.getString(userInfoObj, "gender", "男"));
        user.setIsYellowVip(JSONUtils.getString(userInfoObj, "is_yellow_vip", ""));
        user.setVip(JSONUtils.getString(userInfoObj, "vip", ""));
        user.setYellowVipLevel(JSONUtils.getString(userInfoObj, "yellow_vip_level", ""));
        user.setLevel(JSONUtils.getString(userInfoObj, "level", ""));
        user.setIsYellowYearVip(JSONUtils.getString(userInfoObj, "is_yellow_year_vip", ""));
        
        return user;
    }


}
