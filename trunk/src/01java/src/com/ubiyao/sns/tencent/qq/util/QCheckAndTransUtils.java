package com.ubiyao.sns.tencent.qq.util;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.ubiyao.base.tencent.weibo.util.StringUtils;
import com.ubiyao.sns.tencent.weibo.entity.TStatus;
import com.ubiyao.sns.tencent.weibo.entity.TTopicSimple;
import com.ubiyao.sns.tencent.weibo.entity.TUpdateNumInfo;
import com.ubiyao.sns.tencent.weibo.entity.TUser;
import com.ubiyao.sns.tencent.weibo.util.TTransformUtils;

/**
 * 腾讯微博检查返回的结果是否正确，正确的话进行格式转换类
 * 
 * @author Trinea 2011-11-9 上午12:03:38
 */
public class QCheckAndTransUtils {

    /**
     * 检查修改操作是否正确返回，依据服务器返回的字符串中包含msg字段，若该字段为ok，则表示成功
     * 
     * @param response 服务器返回的字符串
     * @return 正确返回true
     */
    public static boolean checkModifyResult(JSONObject responseObj) {
        if (responseObj == null) {
            return false;
        }

        /** 当 msg等于ok **/
        try {
            return QConstant.RET_VALUE_MSG_NULL.equals(responseObj.getString(QConstant.RET_PARA_MSG));
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 检查修改操作是否正确返回，依据服务器返回的字符串中包含msg字段，若该字段为ok，则表示成功
     * 
     * @param response 服务器返回的字符串
     * @return 正确返回true
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QCheckAndTransUtils#checkModifyResult(JSONObject)}</li>
     *         </ul>
     */
    public static boolean checkModifyResult(String response) {
        if (StringUtils.isEmpty(response)) {
            return false;
        }
        try {
            return checkModifyResult(new JSONObject(response));
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 将从服务器返回的微博列表信息转换成QqTStatus lilst
     * 
     * @param statusesObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link TTransformUtils#transTLStatusesToList(String)}</li>
     *         </ul>
     */
    public static List<TStatus> transStatusesToList(String statusesJsonStr) {
        if (!QCheckAndTransUtils.checkModifyResult(statusesJsonStr)) {
            return null;
        }
        return TTransformUtils.transTLStatusesToList(statusesJsonStr);
    }

    /**
     * 将从服务器返回的用户列表信息转换成QqTUser lilst
     * 
     * @param useresObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link TTransformUtils#transUsersToList(String)}</li>
     *         </ul>
     */
    public static List<TUser> transUsersToList(String useresJsonStr) {
        if (!QCheckAndTransUtils.checkModifyResult(useresJsonStr)) {
            return null;
        }
        return TTransformUtils.transUsersToList(useresJsonStr);
    }

    /**
     * 将从服务器返回的用户姓名列表信息转换成String lilst
     * 
     * @param useresObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link TTransformUtils#transUserNamesToList(String)}</li>
     *         </ul>
     */
    public static List<String> transUserNamesToList(String userNamesJsonStr) {
        if (!QCheckAndTransUtils.checkModifyResult(userNamesJsonStr)) {
            return null;
        }
        return TTransformUtils.transUserNamesToList(userNamesJsonStr);
    }

    /**
     * 将从服务器返回的主题信息转换成QqTTopicSimple lilst
     * 
     * @param topicsJsonStr
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link TTransformUtils#transTopicsToList(String)}</li>
     *         </ul>
     */
    public static List<TTopicSimple> transTopicsToList(String topicsJsonStr) {
        if (!QCheckAndTransUtils.checkModifyResult(topicsJsonStr)) {
            return null;
        }
        return TTransformUtils.transTopicsToList(topicsJsonStr);
    }

    /**
     * 将从服务器返回的数据更新信息转换成QqTUpdateNumInfo
     * 
     * @param updateNumInfo
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link TTransformUtils#transQqTUpdateNumInfo(String)}</li>
     *         </ul>
     */
    public static TUpdateNumInfo transQqTUpdateNumInfo(String updateNumInfo) {
        if (!QCheckAndTransUtils.checkModifyResult(updateNumInfo)) {
            return null;
        }
        return TTransformUtils.transQqTUpdateNumInfo(updateNumInfo);
    }
}
