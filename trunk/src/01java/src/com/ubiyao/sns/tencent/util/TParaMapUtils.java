package com.ubiyao.sns.tencent.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.bcel.internal.classfile.Signature;
import com.ubiyao.base.tencent.util.BaseString;
import com.ubiyao.base.tencent.util.MapUtils;
import com.ubiyao.base.tencent.util.SignatureUtils;
import com.ubiyao.base.tencent.util.StringUtils;
import com.ubiyao.sns.tencent.entity.THotStatusPara;
import com.ubiyao.sns.tencent.entity.TSearchPara;
import com.ubiyao.sns.tencent.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.entity.TTimelinePara;
import com.ubiyao.sns.tencent.entity.TUserEduPara;
import com.ubiyao.sns.tencent.entity.TUserPara;
import com.ubiyao.sns.tencent.entity.TUserRelationPara;
import com.ubiyao.sns.tencent.util.TConstant;

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
    public static Map<String, String> getStandardParaMap(String appKey, String accessToken) {
        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(accessToken)) {
            return null;
        }

        Map<String, String> parasMap = new HashMap<String, String>();
        parasMap.put(TConstant.PARA_OAUTH_CONSUMER_KEY, appKey);
        parasMap.put(TConstant.PARA_OAUTH_TOKEN, accessToken);
        
        parasMap.put(TConstant.PARA_OAUTH_SIGNATURE_METHOD, TConstant.VALUE_OAUTH_SIGNATURE_METHOD);
        parasMap.put(TConstant.PARA_OAUTH_TIMESTAMP, Long.toString(((new Date()).getTime()) / 1000));
        parasMap.put(TConstant.PARA_OAUTH_NONCE, StringUtils.getRandomNumbersAndLetters(32));
        // parasMap.put(TConstant.PARA_OAUTH_TIMESTAMP, "1321153765");
        // parasMap.put(TConstant.PARA_OAUTH_NONCE, "9752880");
        parasMap.put(TConstant.PARA_OAUTH_VERSION, TConstant.VALUE_OAUTH_VERSION_2_A);
        //suhao
       /* BaseString bs=new BaseString();
        bs.setHttpMethod("POST");
        bs.setURL("https://open.t.qq.com/cgi-bin/request_token");
        bs.addParams(TConstant.PARA_OAUTH_CONSUMER_KEY, appKey);
        bs.addParams(TConstant.PARA_OAUTH_SIGNATURE_METHOD, TConstant.VALUE_OAUTH_SIGNATURE_METHOD);
        bs.addParams(TConstant.PARA_OAUTH_CALLBACK, "https://open.t.qq.com/cgi-bin/oauth2/access_token");
        bs.addParams(TConstant.PARA_OAUTH_VERSION, TConstant.VALUE_OAUTH_VERSION_2_A);
        bs.addParams(TConstant.PARA_OAUTH_TIMESTAMP, Long.toString(((new Date()).getTime()) / 1000));
        bs.addParams(TConstant.PARA_OAUTH_NONCE, StringUtils.getRandomNumbersAndLetters(32));
        String signature = SignatureUtils.getSignature(bs.getBaseString(), appKey+"&");
        parasMap.put(TConstant.PARA_OAUTH_SIGNATURE, signature);*/
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
    public static Map<String, String> getStdAndQqTTLParaMap(String appKey, String accessToken,
            TTimelinePara qqTTimelinePara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTSIParaMap(String appKey, String accessToken,
            TStatusInfoPara updateStatusInfo) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTUserParaMap(String appKey, String accessToken, TUserPara qqTUserPara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTURParaMap(String appKey, String accessToken,
            TUserRelationPara qqTUserRelationPara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTUEParaMap(String appKey, String accessToken,
            TUserEduPara qqTUserEduPara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTSearchParaMap(String appKey, String accessToken,
            TSearchPara qqTSearchPara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
    public static Map<String, String> getStdAndQqTHSParaMap(String appKey, String accessToken,
            THotStatusPara qqTHotStatusPara) {
        Map<String, String> parasMap = getStandardParaMap(appKey, accessToken);
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
