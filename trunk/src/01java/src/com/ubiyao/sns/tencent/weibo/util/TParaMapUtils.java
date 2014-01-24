package com.ubiyao.sns.tencent.weibo.util;

import java.util.HashMap;
import java.util.Map;

import com.ubiyao.base.tencent.weibo.util.MapUtils;
import com.ubiyao.base.tencent.weibo.util.StringUtils;
import com.ubiyao.sns.tencent.weibo.entity.TAppAndToken;
import com.ubiyao.sns.tencent.weibo.entity.THotStatusPara;
import com.ubiyao.sns.tencent.weibo.entity.TSearchPara;
import com.ubiyao.sns.tencent.weibo.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.weibo.entity.TTimelinePara;
import com.ubiyao.sns.tencent.weibo.entity.TUserEduPara;
import com.ubiyao.sns.tencent.weibo.entity.TUserPara;
import com.ubiyao.sns.tencent.weibo.entity.TUserRelationPara;

/**
 * 腾讯微博api需要的参数map
 * 
 * @author Trinea 2011-11-9 上午12:04:19
 */
public class TParaMapUtils {

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
    public static Map<String, String> getStandardParaMap(TAppAndToken qqTAppAndToken) {
        if (StringUtils.isEmpty(qqTAppAndToken.getAppKey()) || StringUtils.isEmpty(qqTAppAndToken.getAccessToken())) {
            return null;
        }

        Map<String, String> parasMap = new HashMap<String, String>();
        parasMap.put(TConstant.PARA_OAUTH_CONSUMER_KEY, qqTAppAndToken.getAppKey());
        parasMap.put(TConstant.PARA_ACCESS_TOKEN, qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_OPEN_ID, qqTAppAndToken.getOpenid());
        parasMap.put(TConstant.PARA_SCOPE, qqTAppAndToken.getScope());
        parasMap.put(TConstant.PARA_CLIENT_IP, qqTAppAndToken.getClientip());
        //parasMap.put(TConstant.PARA_FORMAT, TConstant.VALUE_FORMAT_JSON);
        //parasMap.put("syncflag", "0");
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
    public static Map<String, String> getStdAndQqTTLParaMap(TAppAndToken qqTAppAndToken,
            TTimelinePara qqTTimelinePara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
    public static Map<String, String> getStdAndQqTSIParaMap(TAppAndToken qqTAppAndToken,
            TStatusInfoPara updateStatusInfo) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
        Map<String, String> updateStatusInfoParaMap = null;
        if (updateStatusInfo != null) {
            updateStatusInfoParaMap = updateStatusInfo.getParasMap();
        }
        if (parasMap == null) {
            return updateStatusInfoParaMap;
        } else {
            if (!MapUtils.isEmpty(updateStatusInfoParaMap)) {
                parasMap.putAll(updateStatusInfoParaMap);
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
    public static Map<String, String> getStdAndQqTUserParaMap(TAppAndToken qqTAppAndToken, TUserPara qqTUserPara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
    public static Map<String, String> getStdAndQqTURParaMap(TAppAndToken qqTAppAndToken,
            TUserRelationPara qqTUserRelationPara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
    public static Map<String, String> getStdAndQqTUEParaMap(TAppAndToken qqTAppAndToken,
            TUserEduPara qqTUserEduPara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
    public static Map<String, String> getStdAndQqTSearchParaMap(TAppAndToken qqTAppAndToken,
            TSearchPara qqTSearchPara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
    public static Map<String, String> getStdAndQqTHSParaMap(TAppAndToken qqTAppAndToken,
            THotStatusPara qqTHotStatusPara) {
        Map<String, String> parasMap = getStandardParaMap(qqTAppAndToken);
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
