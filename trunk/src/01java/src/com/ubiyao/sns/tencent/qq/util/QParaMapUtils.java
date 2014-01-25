package com.ubiyao.sns.tencent.qq.util;

import java.util.HashMap;
import java.util.Map;

import com.ubiyao.base.tencent.weibo.util.MapUtils;
import com.ubiyao.base.tencent.weibo.util.StringUtils;
import com.ubiyao.sns.tencent.qq.entity.QAddSharePara;
import com.ubiyao.sns.tencent.qq.entity.QAppAndToken;
import com.ubiyao.sns.tencent.weibo.entity.THotStatusPara;
import com.ubiyao.sns.tencent.weibo.entity.TSearchPara;
import com.ubiyao.sns.tencent.weibo.entity.TTimelinePara;
import com.ubiyao.sns.tencent.weibo.entity.TUserEduPara;
import com.ubiyao.sns.tencent.weibo.entity.TUserPara;
import com.ubiyao.sns.tencent.weibo.entity.TUserRelationPara;
import com.ubiyao.sns.tencent.weibo.util.TConstant;

/**
 * 腾讯微博api需要的参数map
 * 
 * @author Trinea 2011-11-9 上午12:04:19
 */
public class QParaMapUtils {

    /**
     * 得到使用api必须的标准参数
     * 
     * @param appKey
     * @param accessToken
     * @return
     *         <ul>
     *         <li>注意其中不包含oauth_signature参数，因为此参数需要根据传递的所有参数加密得到</li>
     *         </ul>
     */
    public static Map<String, String> getStandardParaMap(QAppAndToken qAppAndToken) {
        if (StringUtils.isEmpty(qAppAndToken.getAppKey()) || StringUtils.isEmpty(qAppAndToken.getAccessToken())) {
            return null;
        }

        Map<String, String> parasMap = new HashMap<String, String>();
        parasMap.put(TConstant.PARA_OAUTH_CONSUMER_KEY, qAppAndToken.getAppKey());
        parasMap.put(TConstant.PARA_ACCESS_TOKEN, qAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_OPEN_ID, qAppAndToken.getOpenid());
        parasMap.put(TConstant.PARA_OAUTH_VERSION, TConstant.VALUE_OAUTH_VERSION_2_A);
        return parasMap;
    }

    /**
     * 得到api必须的参数和时间线对象转换后的参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTTimelinePara
     * @return
     */
    public static Map<String, String> getStdAndQqTTLParaMap(QAppAndToken qAppAndToken,
            TTimelinePara qqTTimelinePara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTTimelineParaMap = null;
        if (qqTTimelinePara != null) {
            qqTTimelineParaMap = qqTTimelinePara.getParasMap();
        }
        if (parasMap == null) {
            return qqTTimelineParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTTimelineParaMap)) {
                parasMap.putAll(qqTTimelineParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和微博对象转换后的参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param updateStatusInfo
     * @return
     */
    public static Map<String, String> getStdAddShareParaMap(QAppAndToken qAppAndToken,
    		QAddSharePara updateAddShareInfo) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> updateAddShareInfoParaMap = null;
        if (updateAddShareInfo != null) {
        	updateAddShareInfoParaMap = updateAddShareInfo.getParasMap();
        }
        if (parasMap == null) {
            return updateAddShareInfoParaMap;
        } else {
            if (!MapUtils.isEmpty(updateAddShareInfoParaMap)) {
                parasMap.putAll(updateAddShareInfoParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和用户信息更新的参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTUserPara
     * @return
     */
    public static Map<String, String> getStdAndQqTUserParaMap(QAppAndToken qAppAndToken, TUserPara qqTUserPara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTUserParaMap = null;
        if (qqTUserPara != null) {
            qqTUserParaMap = qqTUserPara.getParasMap();
        }
        if (parasMap == null) {
            return qqTUserParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTUserParaMap)) {
                parasMap.putAll(qqTUserParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和用户关系链参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTUserEduPara
     * @return
     */
    public static Map<String, String> getStdAndQqTURParaMap(QAppAndToken qAppAndToken,
            TUserRelationPara qqTUserRelationPara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTUserRelationParaMap = null;
        if (qqTUserRelationPara != null) {
            qqTUserRelationParaMap = qqTUserRelationPara.getParasMap();
        }
        if (parasMap == null) {
            return qqTUserRelationParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTUserRelationParaMap)) {
                parasMap.putAll(qqTUserRelationParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和用户教育信息更新的参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTUserRelationPara
     * @return
     */
    public static Map<String, String> getStdAndQqTUEParaMap(QAppAndToken qAppAndToken,
            TUserEduPara qqTUserEduPara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTUserEduParaMap = null;
        if (qqTUserEduPara != null) {
            qqTUserEduParaMap = qqTUserEduPara.getParasMap();
        }
        if (parasMap == null) {
            return qqTUserEduParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTUserEduParaMap)) {
                parasMap.putAll(qqTUserEduParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和搜索参数合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTSearchPara
     * @return
     */
    public static Map<String, String> getStdAndQqTSearchParaMap(QAppAndToken qAppAndToken,
            TSearchPara qqTSearchPara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTSearchParaMap = null;
        if (qqTSearchPara != null) {
            qqTSearchParaMap = qqTSearchPara.getParasMap();
        }
        if (parasMap == null) {
            return qqTSearchParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTSearchParaMap)) {
                parasMap.putAll(qqTSearchParaMap);
            }
        }
        return parasMap;
    }

    /**
     * 得到api必须的参数和热度、趋势信息合并的map
     * 
     * @param appKey 应用的key
     * @param accessToken access Toke
     * @param qqTHotStatusPara
     * @return
     */
    public static Map<String, String> getStdAndQqTHSParaMap(QAppAndToken qAppAndToken,
            THotStatusPara qqTHotStatusPara) {
        Map<String, String> parasMap = getStandardParaMap(qAppAndToken);
        Map<String, String> qqTHotStatusParaMap = null;
        if (qqTHotStatusPara != null) {
            qqTHotStatusParaMap = qqTHotStatusPara.getParasMap();
        }
        if (parasMap == null) {
            return qqTHotStatusParaMap;
        } else {
            if (!MapUtils.isEmpty(qqTHotStatusParaMap)) {
                parasMap.putAll(qqTHotStatusParaMap);
            }
        }
        return parasMap;
    }
}
