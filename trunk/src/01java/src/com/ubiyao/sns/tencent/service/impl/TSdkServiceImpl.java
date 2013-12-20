package com.ubiyao.sns.tencent.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ubiyao.base.tencent.util.HttpUtils;
import com.ubiyao.base.tencent.util.JSONUtils;
import com.ubiyao.base.tencent.util.MapUtils;
import com.ubiyao.base.tencent.util.StringUtils;
import com.ubiyao.sns.tencent.entity.TAppAndToken;
import com.ubiyao.sns.tencent.entity.THotStatusPara;
import com.ubiyao.sns.tencent.entity.TListData;
import com.ubiyao.sns.tencent.entity.TResponse;
import com.ubiyao.sns.tencent.entity.TSearchPara;
import com.ubiyao.sns.tencent.entity.TSign;
import com.ubiyao.sns.tencent.entity.TStatus;
import com.ubiyao.sns.tencent.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.entity.TTimelinePara;
import com.ubiyao.sns.tencent.entity.TTopicSimple;
import com.ubiyao.sns.tencent.entity.TUpdateNumInfo;
import com.ubiyao.sns.tencent.entity.TUser;
import com.ubiyao.sns.tencent.entity.TUserEduPara;
import com.ubiyao.sns.tencent.entity.TUserPara;
import com.ubiyao.sns.tencent.entity.TUserRelation;
import com.ubiyao.sns.tencent.entity.TUserRelationPara;
import com.ubiyao.sns.tencent.entity.TVideoInfo;
import com.ubiyao.sns.tencent.service.TSdkService;
import com.ubiyao.sns.tencent.util.TCheckAndTransUtils;
import com.ubiyao.sns.tencent.util.TConstant;
import com.ubiyao.sns.tencent.util.TParaMapUtils;
import com.ubiyao.sns.tencent.util.TSignAndHttpUtils;
import com.ubiyao.sns.tencent.util.TTransformUtils;

@Service("tSdkService")
public class TSdkServiceImpl implements TSdkService {

    /** 应用和用户相关信息 **/
    @Resource(name = "qqTAppAndToken")
    private TAppAndToken qqTAppAndToken;

    @Override
    public TAppAndToken getQqTAppAndToken() {
        return qqTAppAndToken;
    }

    @Override
    public void setQqTAppAndToken(TAppAndToken qqTAppAndToken) {
        this.qqTAppAndToken = qqTAppAndToken;
    }

    @Override
    public String getTimeLineCommonStr(String url, TTimelinePara qqTTimelinePara) {
        if (StringUtils.isEmpty(url) || qqTTimelinePara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTTLParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTTimelinePara);

        return TSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TStatus> getTimeLineCommon(String url, TTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transStatusesToList(getTimeLineCommonStr(url, qqTTimelinePara));
    }

    @Override
    public TResponse getTimeLineCommonRes(String url, TTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = getTimeLineCommonStr(url, qqTTimelinePara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
                qqTListData.setRelatedUser(TTransformUtils.transQqTrelatedUser(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public String getHomeTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getHomeTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getHomeTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getPublicTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getPublicTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getPublicTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUserTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getUserTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getUserTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getMentionsTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getMentionsTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getMentionsTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getTopicTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getTopicTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getTopicTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getBroadcastTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getBroadcastTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getBroadcastTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getSpecialTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getSpecialTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getSpecialTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getAreaTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getAreaTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getAreaTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getHomeTLIdsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getHomeTLIds(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getHomeTLIdsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUserTLIdsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getUserTLIds(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getUserTLIdsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getBroadcastTLIdsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getBroadcastTLIds(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getBroadcastTLIdsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getMentionsTLIdsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getMentionsTLIds(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getMentionsTLIdsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getUsersTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getUsersTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getUsersTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUsersTLIdsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getUsersTLIds(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getUsersTLIdsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getVipStatusTLStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getVipStatusTL(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getVipStatusTLRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getStatus(String format, long statusId) {
        if (statusId < 0 || StringUtils.isEmpty(format) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_STATUS_ID, Long.toString(statusId));

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_STATUS_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public TStatus getStatus(long statusId) {
        String status = getStatus(TConstant.VALUE_FORMAT_JSON, statusId);
        if (!StringUtils.isEmpty(status) && TCheckAndTransUtils.checkModifyResult(status)) {
            return TTransformUtils.transStatus(JSONUtils.getJSONObject(status, "data", null));
        }
        return null;
    }

    @Override
    public TResponse getStatusRes(long statusId) {
        String response = getStatus(TConstant.VALUE_FORMAT_JSON, statusId);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transStatus(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String addStatusCommonStr(String addStatusUrl, TStatusInfoPara status) {
        if (status == null || qqTAppAndToken == null || !qqTAppAndToken.isValid() || StringUtils.isEmpty(addStatusUrl)) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTSIParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), status);
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }

        if (status.isContainImage()) {
            Map<String, String> filePathMap = new HashMap<String, String>();
            filePathMap.put(TConstant.PARA_PICTURE, status.getImageFilePath());
            return TSignAndHttpUtils.signAndHttpPostWithFile(addStatusUrl, filePathMap, parasMap, qqTAppAndToken);
        } else {
            return TSignAndHttpUtils.signAndHttpPostEncodeParas(addStatusUrl, parasMap, qqTAppAndToken);
        }
    }

    @Override
    public boolean addStatusCommon(String addStatusUrl, TStatusInfoPara status) {
        if (status == null) {
            return false;
        }

        status.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.checkModifyResult(addStatusCommonStr(addStatusUrl, status));
    }

    @Override
    public TResponse addStatusCommonRes(String addStatusUrl, TStatusInfoPara status) {
        if (status == null) {
            return null;
        }

        status.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = addStatusCommonStr(addStatusUrl, status);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public String addStatusStr(TStatusInfoPara status) {
        if (status == null) {
            return null;
        }
        return addStatusCommonStr((status.isContainImage() ? TConstant.ADD_STATUS_WITH_PIC_URL
                : TConstant.ADD_STATUS_URL), status);

    }

    @Override
    public boolean addStatus(TStatusInfoPara status) {
        if (status == null) {
            return false;
        }

        return addStatusCommon((status.isContainImage() ? TConstant.ADD_STATUS_WITH_PIC_URL
                : TConstant.ADD_STATUS_URL), status);
    }

    @Override
    public TResponse addStatusRes(TStatusInfoPara status) {
        if (status == null) {
            return null;
        }

        return addStatusCommonRes((status.isContainImage() ? TConstant.ADD_STATUS_WITH_PIC_URL
                : TConstant.ADD_STATUS_URL), status);
    }

    @Override
    public String addStatusStr(String content, String imagePath) {
        TStatusInfoPara status = new TStatusInfoPara();
        status.setStatusContent(content);
        if (StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatusStr(status);
    }

    @Override
    public boolean addStatus(String content, String imagePath) {
        TStatusInfoPara status = new TStatusInfoPara();
        status.setStatusContent(content);
        if (!StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatus(status);
    }

    @Override
    public TResponse addStatusRes(String content, String imagePath) {
        TStatusInfoPara status = new TStatusInfoPara();
        status.setStatusContent(content);
        if (StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatusRes(status);
    }

    @Override
    public String repostStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public boolean repost(TStatusInfoPara status) {
        return addStatusCommon(TConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public TResponse repostRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public String replyStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public boolean reply(TStatusInfoPara status) {
        return addStatusCommon(TConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public TResponse replyRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public String commentStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public boolean comment(TStatusInfoPara status) {
        return addStatusCommon(TConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public TResponse commentRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public String addMusicStatusStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public boolean addMusicStatus(TStatusInfoPara status) {
        return addStatusCommon(TConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public TResponse addMusicStatusRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public String addVideoStatusStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public boolean addVideoStatus(TStatusInfoPara status) {
        return addStatusCommon(TConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public TResponse addVideoStatusRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public String getStatusCommentsCommonStr(int repostOrCommentFlag, TTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommonStr(TConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getStatusCommentsCommon(int repostOrCommentFlag, TTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(TConstant.VALUE_FORMAT_JSON);
        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommon(TConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getStatusCommentsCommonRes(int repostOrCommentFlag, TTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(TConstant.VALUE_FORMAT_JSON);
        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommonRes(TConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public String getStatusCommentsStr(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(TConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getStatusComments(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(TConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public TResponse getStatusCommentsRes(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(TConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public String getStatusRepostsStr(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(TConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getStatusReposts(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(TConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public TResponse getStatusRepostsRes(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(TConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public String getStatusCommentsAndRepostsStr(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(TConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getStatusCommentsAndReposts(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(TConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public TResponse getStatusCommentsAndRepostsRes(TTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(TConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public String getVideoInfo(String format, String videoUrl) {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(videoUrl) || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_VIDEO_URL, videoUrl);

        return TSignAndHttpUtils.signAndHttpPostEncodeParas(TConstant.GET_VIDEO_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public TVideoInfo getVideoInfo(String videoUrl) {
        String videoInfo = getVideoInfo(TConstant.VALUE_FORMAT_JSON, videoUrl);
        if (StringUtils.isEmpty(videoInfo) || !TCheckAndTransUtils.checkModifyResult(videoInfo)) {
            return null;
        }
        return TTransformUtils.transVideoInfo(JSONUtils.getJSONObject(videoInfo, "data", null));
    }

    @Override
    public TResponse getVideoInfoRes(String videoUrl) {
        String response = getVideoInfo(TConstant.VALUE_FORMAT_JSON, videoUrl);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transVideoInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getStatusByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_STATUS_IDS, ids);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_STATUS_BY_IDS_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TStatus> getStatusByIds(String ids) {
        return TCheckAndTransUtils.transStatusesToList(getStatusByIdsStr(TConstant.VALUE_FORMAT_JSON, ids));
    }

    @Override
    public TResponse getStatusByIdsRes(String ids) {

        String response = getStatusByIdsStr(TConstant.VALUE_FORMAT_JSON, ids);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getReRepostCountByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_STATUS_IDS, ids);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_RE_REPOST_COUNT_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public Map<Long, Integer> getReRepostCountByIds(String ids) {
        return TTransformUtils
                .transStatusesReCountToMap(getReRepostCountByIdsStr(TConstant.VALUE_FORMAT_JSON, ids));
    }

    public TResponse getReRepostCountByIdsRes(String ids) {
        String response = getReRepostCountByIdsStr(TConstant.VALUE_FORMAT_JSON, ids);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transStatusesReCountToMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String addEmotionStr(TStatusInfoPara status) {
        return addStatusCommonStr(TConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public boolean addEmotion(TStatusInfoPara status) {
        return addStatusCommon(TConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public TResponse addEmotionRes(TStatusInfoPara status) {
        return addStatusCommonRes(TConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public String operateStatusCommonStr(String url, String format, long statusId) {
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(format) || statusId < 0 || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, TConstant.VALUE_FORMAT_JSON);
        parasMap.put(TConstant.PARA_STATUS_ID, Long.toString(statusId));

        return TSignAndHttpUtils.signAndHttpPostEncodeParas(url, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean operateStatusCommon(String url, long statusId) {
        return TCheckAndTransUtils.checkModifyResult(operateStatusCommonStr(url, TConstant.VALUE_FORMAT_JSON,
                statusId));
    }

    @Override
    public TResponse operateStatusCommonRes(String url, long statusId) {
        String response = operateStatusCommonStr(url, TConstant.VALUE_FORMAT_JSON, statusId);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public boolean delete(long statusId) {
        return operateStatusCommon(TConstant.DELETE_STATUS_URL, statusId);
    }

    @Override
    public TResponse deleteRes(long statusId) {
        return operateStatusCommonRes(TConstant.DELETE_STATUS_URL, statusId);
    }

    @Override
    public String getRepostAndCommentCount(String format, String statusIds, int flag) {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(statusIds) || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_RE_COUNTIDS, statusIds);
        parasMap.put(TConstant.PARA_RE_COUNT_FLAG, Integer.toString(flag));

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_REPOST_AND_COMMENT_COUNT_URL, parasMap,
                qqTAppAndToken);
    }

    @Override
    public List<TStatus> getRepostAndCommentCount(String statusIds, int flag) {
        if (TConstant.VALUE_RE_COUNT_FLAG_ALL == flag) {
            return getRepostAndCommentCount(statusIds);
        } else if (TConstant.VALUE_RE_COUNT_FLAG_REPOST == flag) {
            return TTransformUtils.transCommentCountMapToList(getRepostOrCommentCount(statusIds, flag));
        } else if (TConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
            return TTransformUtils.transRepostCountMapToList(getRepostOrCommentCount(statusIds, flag));
        }
        return null;
    }

    @Override
    public TResponse getRepostAndCommentCountRes(String statusIds, int flag) {

        String response = getRepostAndCommentCount(TConstant.VALUE_FORMAT_JSON, statusIds, flag);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            if (TConstant.VALUE_RE_COUNT_FLAG_ALL == flag) {
                qqTResponse.setData(TTransformUtils.transStatusesReCountToList(response));
            } else if (TConstant.VALUE_RE_COUNT_FLAG_REPOST == flag
                    || TConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
                qqTResponse.setData(TTransformUtils.transStatusesReCountToMap(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public List<TStatus> getRepostAndCommentCount(String statusIds) {
        String reCount = getRepostAndCommentCount(TConstant.VALUE_FORMAT_JSON, statusIds,
                TConstant.VALUE_RE_COUNT_FLAG_ALL);
        if (StringUtils.isEmpty(reCount) || !TCheckAndTransUtils.checkModifyResult(reCount)) {
            return null;
        }

        return TTransformUtils.transStatusesReCountToList(reCount);
    }

    @Override
    public TResponse getRepostAndCommentCountRes(String statusIds) {

        String response = getRepostAndCommentCount(TConstant.VALUE_FORMAT_JSON, statusIds,
                TConstant.VALUE_RE_COUNT_FLAG_ALL);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transStatusesReCountToList(response));
        }
        return qqTResponse;
    }

    @Override
    public Map<Long, Integer> getRepostOrCommentCount(String statusIds, int flag) {

        String reCount = getRepostAndCommentCount(TConstant.VALUE_FORMAT_JSON, statusIds, flag);
        if (StringUtils.isEmpty(reCount) || !TCheckAndTransUtils.checkModifyResult(reCount)) {
            return null;
        }

        if (TConstant.VALUE_RE_COUNT_FLAG_REPOST == flag || TConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
            return TTransformUtils.transStatusesReCountToMap(reCount);
        }
        return null;
    }

    @Override
    public TResponse getRepostOrCommentCountRes(String statusIds, int flag) {

        String response = getRepostAndCommentCount(TConstant.VALUE_FORMAT_JSON, statusIds, flag);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            if (TConstant.VALUE_RE_COUNT_FLAG_REPOST == flag || TConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
                qqTResponse.setData(TTransformUtils.transStatusesReCountToMap(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public String getSelfInfo(String format) {
        if (StringUtils.isEmpty(format) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_SELF_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public TUser getSelfInfo() {
        String selfInfo = getSelfInfo(TConstant.VALUE_FORMAT_JSON);
        if (StringUtils.isEmpty(selfInfo) || !TCheckAndTransUtils.checkModifyResult(selfInfo)) {
            return null;
        }
        return TTransformUtils.transUserInfo(JSONUtils.getJSONObject(selfInfo, "data", null));
    }

    @Override
    public TResponse getSelfInfoRes() {
        String response = getSelfInfo(TConstant.VALUE_FORMAT_JSON);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String updateSelfInfoStr(TUserPara qqTUserPara) {
        if (qqTUserPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTUserParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTUserPara);
        return TSignAndHttpUtils.signAndHttpPostEncodeParas(TConstant.UPDATE_USER_INFO_URL, parasMap,
                qqTAppAndToken);
    }

    @Override
    public boolean updateSelfInfo(TUserPara qqTUserPara) {
        if (qqTUserPara != null) {
            qqTUserPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        }
        return TCheckAndTransUtils.checkModifyResult(updateSelfInfoStr(qqTUserPara));
    }

    @Override
    public TResponse updateSelfInfoRes(TUserPara qqTUserPara) {
        if (qqTUserPara != null) {
            qqTUserPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        }
        return TTransformUtils.transResponse(updateSelfInfoStr(qqTUserPara));
    }

    @Override
    public String updateSelfHeadStr(String format, String headImagePath) {
        if (StringUtils.isEmpty(headImagePath) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);

        Map<String, String> filePathList = new HashMap<String, String>();
        filePathList.put(TConstant.PARA_USER_ICON, headImagePath);
        return TSignAndHttpUtils.signAndHttpPostWithFile(TConstant.UPDATE_USER_HEAD_INFO_URL, filePathList,
                parasMap, qqTAppAndToken);
    }

    @Override
    public boolean updateSelfHead(String headImagePath) {
        return TCheckAndTransUtils.checkModifyResult(updateSelfHeadStr(TConstant.VALUE_FORMAT_JSON, headImagePath));
    }

    @Override
    public TResponse updateSelfHeadRes(String headImagePath) {
        return TTransformUtils.transResponse(updateSelfHeadStr(TConstant.VALUE_FORMAT_JSON, headImagePath));
    }

    @Override
    public String updateSelfEduInfoStr(TUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTUEParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTUserEduPara);
        return TSignAndHttpUtils.signAndHttpPost(TConstant.UPDATE_USER_EDU_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean updateSelfEduInfo(TUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara != null) {
            qqTUserEduPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        }
        return TCheckAndTransUtils.checkModifyResult(updateSelfEduInfoStr(qqTUserEduPara));
    }

    @Override
    public TResponse updateSelfEduInfoRes(TUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara != null) {
            qqTUserEduPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        }
        return TTransformUtils.transResponse(updateSelfEduInfoStr(qqTUserEduPara));
    }

    @Override
    public String getOtherUserInfo(String format, String userName, String userOpenId) {
        if ((StringUtils.isEmpty(userName) && StringUtils.isEmpty(userOpenId)) || StringUtils.isEmpty(format)
                || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (parasMap == null) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_OPEN_ID, userOpenId);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_OTHER_USER_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public TUser getOtherUserInfo(String userName, String userOpenId) {
        String selfInfo = getOtherUserInfo(TConstant.VALUE_FORMAT_JSON, userName, userOpenId);
        if (StringUtils.isEmpty(selfInfo) || !TCheckAndTransUtils.checkModifyResult(selfInfo)) {
            return null;
        }
        return TTransformUtils.transUserInfo(JSONUtils.getJSONObject(selfInfo, "data", null));
    }

    @Override
    public TResponse getOtherUserInfoRes(String userName, String userOpenId) {
        String response = getOtherUserInfo(TConstant.VALUE_FORMAT_JSON, userName, userOpenId);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getOtherUsersInfo(String format, String userNames, String userOpenIds) {
        if ((StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userOpenIds)) || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, TConstant.PARA_USER_NAMES, userNames);
        MapUtils.putMapNotEmptyValue(parasMap, TConstant.PARA_USER_OPEN_IDS, userOpenIds);
        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_OTHER_USERS_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TUser> getOtherUsersInfo(String userNames, String userOpenIds) {
        return TCheckAndTransUtils.transUsersToList(getOtherUsersInfo(TConstant.VALUE_FORMAT_JSON, userNames,
                userOpenIds));
    }

    @Override
    public TResponse getOtherUsersInfoRes(String userNames, String userOpenIds) {
        String response = getOtherUsersInfo(TConstant.VALUE_FORMAT_JSON, userNames, userOpenIds);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String verifyAccountStr(String format, String userName, String userId) {
        if ((StringUtils.isEmpty(userName) && StringUtils.isEmpty(userId)) || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (parasMap == null) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, TConstant.VALUE_FORMAT_JSON);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_VERIFY_ACCOUNT_NAME, userName);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_VERIFY_ACCOUNT_ID, userId);

        return TSignAndHttpUtils.signAndHttpPostEncodeParas(TConstant.VERIFY_ACCOUNT_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean verifyAccount(String userName, String userId) {
        TResponse qqTResponse = verifyAccountRes(userName, userId);
        return qqTResponse == null ? null : ((Boolean) qqTResponse.getData()).booleanValue();
    }

    @Override
    public TResponse verifyAccountRes(String userName, String userId) {
        String response = verifyAccountStr(TConstant.VALUE_FORMAT_JSON, userName, userId);
        TResponse qqTResponse = TTransformUtils.transResponse(response);

        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transVerifyResult(JSONUtils.getJSONObject(response, "data", null)));
            qqTResponse.setInfo(TTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "info", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getUserRelationsCommonStr(String url, TUserRelationPara qqTUserRelationPara) {
        if (StringUtils.isEmpty(url) || qqTUserRelationPara == null || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTURParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTUserRelationPara);
        return TSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TUser> getUserRelationsCommon(String url, TUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transUsersToList(getUserRelationsCommonStr(url, qqTUserRelationPara));
    }

    @Override
    public TResponse getUserRelationsCommonRes(String url, TUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = getUserRelationsCommonStr(url, qqTUserRelationPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public List<String> getUserRelationsNameCommon(String url, TUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transUserNamesToList(getUserRelationsCommonStr(url, qqTUserRelationPara));
    }

    @Override
    public TResponse getUserRelationsNameCommonRes(String url, TUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = getUserRelationsCommonStr(url, qqTUserRelationPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transUserNamesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getSelfFansStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfFans(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansStrRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfFans(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansNamesStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfFansNames(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommon(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansNamesRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommonRes(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansNamesStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfFansNames(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommon(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansNamesRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommonRes(TConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfInterested(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfInterested(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedNamesStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfInterestedNames(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommon(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedNamesRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommonRes(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedNamesStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfInterestedNames(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommon(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedNamesRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommonRes(TConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfBlackListStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfBlackList(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfBlackListRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfBlackListStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfBlackList(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfBlackListRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfSpecialInterestedStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfSpecialInterested(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfSpecialInterestedRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfSpecialInterestedStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfSpecialInterested(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfSpecialInterestedRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserFansStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserFans(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserFansRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserFansStr(String format, String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserFans(String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserFansRes(String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserInterestedStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserInterested(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserInterestedRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserInterestedStr(String format, String userName, String userOpenId, int reqNumber,
            int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserInterested(String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserInterestedRes(String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserSpecialInterestedStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserSpecialInterested(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserSpecialInterestedRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserSpecialInterestedStr(String format, String userName, String userOpenId, int reqNumber,
            int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getOtherUserSpecialInterested(String userName, String userOpenId, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getOtherUserSpecialInterestedRes(String userName, String userOpenId, int reqNumber,
            int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansSimpleInfoStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfFansSimpleInfo(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansSimpleInfoRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansSimpleInfoStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfFansSimpleInfo(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfFansSimpleInfoRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedSimpleInfoStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfInterestedSimpleInfo(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedSimpleInfoRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedSimpleInfoStr(String format, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getSelfInterestedSimpleInfo(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getSelfInterestedSimpleInfoRes(int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getMutualInterestedStr(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getMutualInterested(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getMutualInterestedRes(TUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getMutualInterestedStr(String format, String userName, int reqNumber, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<TUser> getMutualInterested(int reqNumber, String userName, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public TResponse getMutualInterestedRes(int reqNumber, String userName, int startIndex) {
        TUserRelationPara qqTUserRelationPara = new TUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(TConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String relationWithOtherCommonStr(String format, String url, String userName, String userOpenId) {
        if (StringUtils.isEmpty(url) || (StringUtils.isEmpty(userName) && StringUtils.isEmpty(userOpenId))
                || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_ID, userOpenId);
        return TSignAndHttpUtils.signAndHttpPostEncodeParas(url, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean relationWithOtherCommon(String url, String userName, String userOpenId) {
        return TCheckAndTransUtils.checkModifyResult(relationWithOtherCommonStr(TConstant.VALUE_FORMAT_JSON, url,
                userName, userOpenId));
    }

    @Override
    public TResponse relationWithOtherCommonRes(String url, String userName, String userOpenId) {
        return TTransformUtils.transResponse(relationWithOtherCommonStr(TConstant.VALUE_FORMAT_JSON, url, userName,
                userOpenId));
    }

    @Override
    public String interestedInOther(String format, String userNames, String userOpenIds) {
        if ((StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userOpenIds)) || qqTAppAndToken == null
                || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);
        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userNames);
        //-- MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_IDS, userOpenIds);
        return TSignAndHttpUtils.signAndHttpPostEncodeParas(TConstant.ADD_FRIEND_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean interestedInOther(String userNames, String userOpenIds) {
        return TCheckAndTransUtils.checkModifyResult(interestedInOther(TConstant.VALUE_FORMAT_JSON, userNames,
                userOpenIds));
    }

    @Override
    public TResponse interestedInOtherRes(String userNames, String userOpenIds) {
        return TTransformUtils
                .transResponse(interestedInOther(TConstant.VALUE_FORMAT_JSON, userNames, userOpenIds));
    }

    @Override
    public String cancelInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, TConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean cancelInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(TConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public TResponse cancelInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(TConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String specialInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, TConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean specialInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(TConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public TResponse specialInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(TConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String cancelSpecialInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, TConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean cancelSpecialInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(TConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public TResponse cancelSpecialInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(TConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String addOtherToBlackList(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, TConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public boolean addOtherToBlackList(String userName, String userOpenId) {
        return relationWithOtherCommon(TConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public TResponse addOtherToBlackListRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(TConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public String deleteFromBlackList(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, TConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public boolean deleteFromBlackList(String userName, String userOpenId) {
        return relationWithOtherCommon(TConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public TResponse deleteFromBlackListRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(TConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public String checkRelationWithSelf(String format, String userNames, String userIds, int flag) {
        if (StringUtils.isEmpty(format) || (StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userIds))
                || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(TConstant.PARA_FORMAT, format);

        //--MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_NAMES, userNames);
        //-- MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_IDS, userIds);

        parasMap.put(TConstant.PARA_RELATION_FLAG, Integer.toString(flag));

        return TSignAndHttpUtils.signAndHttpGet(TConstant.CHECK_RELATION_WITH_SELF_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TUserRelation> getIsFanAndInterested(String userNames, String userIds) {
        String relationStr = checkRelationWithSelf(TConstant.VALUE_FORMAT_JSON, userNames, userIds,
                TConstant.VALUE_BOTH_RELATION_FLAG);
        if (StringUtils.isEmpty(relationStr) || !TCheckAndTransUtils.checkModifyResult(relationStr)) {
            return null;
        }

        return TTransformUtils.transUserRelationToList(relationStr);
    }

    @Override
    public TResponse getIsFanAndInterestedRes(String userNames, String userIds) {
        String response = checkRelationWithSelf(TConstant.VALUE_FORMAT_JSON, userNames, userIds,
                TConstant.VALUE_BOTH_RELATION_FLAG);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transUserRelationToList(response));
        }
        return qqTResponse;
    }

    @Override
    public Map<String, Boolean> getIsFanOrInterested(String userNames, String userIds, int flag) {

        String relationStr = checkRelationWithSelf(TConstant.VALUE_FORMAT_JSON, userNames, userIds, flag);
        if (StringUtils.isEmpty(relationStr) || !TCheckAndTransUtils.checkModifyResult(relationStr)) {
            return null;
        }

        if (TConstant.VALUE_FANS_RELATION_FLAG == flag || TConstant.VALUE_INTERESTED_RELATION_FLAG == flag) {
            return TTransformUtils.transUserRelationToMap(relationStr);
        }
        return null;
    }

    @Override
    public TResponse getIsFanOrInterestedRes(String userNames, String userIds, int flag) {
        String response = checkRelationWithSelf(TConstant.VALUE_FORMAT_JSON, userNames, userIds, flag);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transUserRelationToMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String sendMessageStr(TStatusInfoPara message) {
        return addStatusCommonStr(TConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public boolean sendMessage(TStatusInfoPara message) {
        return addStatusCommon(TConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public TResponse sendMessageRes(TStatusInfoPara message) {
        return addStatusCommonRes(TConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public boolean deleteMessage(long messageId) {
        return operateStatusCommon(TConstant.DELETE_MESSAGE_URL, messageId);
    }

    @Override
    public TResponse deleteMessageRes(long messageId) {
        return operateStatusCommonRes(TConstant.DELETE_MESSAGE_URL, messageId);
    }

    @Override
    public String getReceiveMessagesStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getReceiveMessages(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getReceiveMessagesRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public String getSendMessagesStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getSendMessages(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getSendMessagesRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public String searchCommonStr(String url, TSearchPara qqTSearchPara) {
        if (StringUtils.isEmpty(url) || qqTSearchPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTSearchParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTSearchPara);
        return TSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TUser> searchUserCommon(String url, TSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transUsersToList(searchCommonStr(url, qqTSearchPara));
    }

    @Override
    public TResponse searchUserCommonRes(String url, TSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = searchCommonStr(url, qqTSearchPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String searchUserStr(TSearchPara qqTSearchPara) {
        return searchCommonStr(TConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public List<TUser> searchUser(TSearchPara qqTSearchPara) {
        return searchUserCommon(TConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public TResponse searchUserRes(TSearchPara qqTSearchPara) {
        return searchUserCommonRes(TConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public String searchStatusStr(TSearchPara qqTSearchPara) {
        return searchCommonStr(TConstant.SEARCH_STATUS_URL, qqTSearchPara);
    }

    @Override
    public List<TStatus> searchStatus(TSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transStatusesToList(searchStatusStr(qqTSearchPara));
    }

    @Override
    public TResponse searchStatusRes(TSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = searchStatusStr(qqTSearchPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String searchUserByTagStr(TSearchPara qqTSearchPara) {
        return searchCommonStr(TConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public List<TUser> searchUserByTag(TSearchPara qqTSearchPara) {
        return searchUserCommon(TConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public TResponse searchUserByTagRes(TSearchPara qqTSearchPara) {
        return searchUserCommonRes(TConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public String getHotCommonStr(String url, THotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStdAndQqTHSParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken(), qqTHotStatusPara);
        return TSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);

    }

    @Override
    public String getHotTopicsStr(THotStatusPara qqTHotStatusPara) {
        return getHotCommonStr(TConstant.GET_HOT_TOPICS_URL, qqTHotStatusPara);
    }

    @Override
    public List<TTopicSimple> getHotTopics(THotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transTopicsToList(getHotTopicsStr(qqTHotStatusPara));
    }

    @Override
    public TResponse getHotTopicsRes(THotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = getHotTopicsStr(qqTHotStatusPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTopicsToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getHotRepostsStr(THotStatusPara qqTHotStatusPara) {
        return getHotCommonStr(TConstant.GET_HOT_REPOSTS_URL, qqTHotStatusPara);
    }

    @Override
    public List<TStatus> getHotReposts(THotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        return TCheckAndTransUtils.transStatusesToList(getHotRepostsStr(qqTHotStatusPara));
    }

    @Override
    public TResponse getHotRepostsRes(THotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(TConstant.VALUE_FORMAT_JSON);
        String response = getHotRepostsStr(qqTHotStatusPara);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getUpdateInfoNumStr(String format, boolean isClear, int clearType) {
        if (qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_REQ_TYPE, Integer.toString((isClear ? 1 : 0)));
        parasMap.put(TConstant.PARA_CLEAR_TYPE, Integer.toString(clearType));

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_UPDATE_INFO_NUM_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public TUpdateNumInfo getUpdateInfoNum(boolean isClear, int clearType) {
        return TCheckAndTransUtils.transQqTUpdateNumInfo(getUpdateInfoNumStr(TConstant.VALUE_FORMAT_JSON, isClear,
                clearType));
    }

    @Override
    public TResponse getUpdateInfoNumRes(boolean isClear, int clearType) {
        String response = getUpdateInfoNumStr(TConstant.VALUE_FORMAT_JSON, isClear, clearType);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transQqTUpdateNumInfo(response));
        }
        return qqTResponse;
    }

    @Override
    public boolean collect(long statusId) {
        return operateStatusCommon(TConstant.COLLECT_STATUS_URL, statusId);
    }

    @Override
    public TResponse collectRes(long statusId) {
        return operateStatusCommonRes(TConstant.COLLECT_STATUS_URL, statusId);
    }

    @Override
    public boolean unCollect(long statusId) {
        return operateStatusCommon(TConstant.UNCOLLECT_STATUS_URL, statusId);
    }

    @Override
    public TResponse unCollectRes(long statusId) {
        return operateStatusCommonRes(TConstant.UNCOLLECT_STATUS_URL, statusId);
    }

    @Override
    public boolean subscribeTopic(long topicId) {
        return operateStatusCommon(TConstant.SUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public TResponse subscribeTopicRes(long topicId) {
        return operateStatusCommonRes(TConstant.SUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public boolean unSubscribeTopic(long topicId) {
        return operateStatusCommon(TConstant.UNSUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public TResponse unSubscribeTopicRes(long topicId) {
        return operateStatusCommonRes(TConstant.UNSUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public String getCollectStatusesStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getCollectStatuses(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getCollectStatusesRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public String getCollectTopicsStr(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(TConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public List<TStatus> getCollectTopics(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(TConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public TResponse getCollectTopicsRes(TTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(TConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public String getTopicIdByNamesStr(String format, String names) {
        if (StringUtils.isEmpty(names) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_TOPIC_NAMES, names);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_TOPIC_ID_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public Map<String, String> getTopicIdByNames(String names) {
        String topicStr = getTopicIdByNamesStr(TConstant.VALUE_FORMAT_JSON, names);
        if (!TCheckAndTransUtils.checkModifyResult(topicStr)) {
            return null;
        }
        return TTransformUtils.transTopicInfoIntoMap(topicStr);
    }

    @Override
    public TResponse getTopicIdByNamesRes(String names) {

        String response = getTopicIdByNamesStr(TConstant.VALUE_FORMAT_JSON, names);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transTopicInfoIntoMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String getTopicInfoByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_TOPIC_IDS, ids);

        return TSignAndHttpUtils.signAndHttpGet(TConstant.GET_TOPIC_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<TStatus> getTopicInfoByIds(String ids) {
        return TCheckAndTransUtils.transStatusesToList(getTopicInfoByIdsStr(TConstant.VALUE_FORMAT_JSON, ids));
    }

    @Override
    public TResponse getTopicInfoByIdsRes(String ids) {

        String response = getTopicInfoByIdsStr(TConstant.VALUE_FORMAT_JSON, ids);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            TListData qqTListData = TTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(TTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;

    }

    @Override
    public String addTag(String format, String tagName) {
        if (StringUtils.isEmpty(tagName) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_TAG_NAME, tagName);

        return TSignAndHttpUtils.signAndHttpPostEncodeParas(TConstant.ADD_TAG_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean addTag(String tagName) {
        return TCheckAndTransUtils.checkModifyResult(addTag(TConstant.VALUE_FORMAT_JSON, tagName));
    }

    @Override
    public TResponse addTagRes(String tagName) {
        String response = addTag(TConstant.VALUE_FORMAT_JSON, tagName);
        TResponse qqTResponse = TTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(TTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public String deleteTag(String format, String tagId) {
        if (StringUtils.isEmpty(tagId) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                qqTAppAndToken.getAccessToken());
        parasMap.put(TConstant.PARA_FORMAT, format);
        parasMap.put(TConstant.PARA_TAG_ID, tagId);

        return TSignAndHttpUtils.signAndHttpPost(TConstant.DELETE_TAG_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean deleteTag(String tagId) {
        return TCheckAndTransUtils.checkModifyResult(deleteTag(TConstant.VALUE_FORMAT_JSON, tagId));
    }

    @Override
    public TResponse deleteTagRes(String tagId) {
        return TTransformUtils.transResponse(deleteTag(TConstant.VALUE_FORMAT_JSON, tagId));
    }

    @Override
    public Map<String, String> getUnAuthorizedRequestToken(String callBackUrl) {
        Map<String, String> parasMap = new HashMap<String, String>();
        parasMap.put(TConstant.PARA_OAUTH_CONSUMER_KEY, qqTAppAndToken.getAppKey());
        parasMap.put(TConstant.PARA_OAUTH_SIGNATURE_METHOD, TConstant.VALUE_OAUTH_SIGNATURE_METHOD);
        parasMap.put(TConstant.PARA_OAUTH_TIMESTAMP, Long.toString(((new Date()).getTime()) / 1000));
        //--parasMap.put(QqTConstant.PARA_OAUTH_NONCE, StringUtils.getRandomNumbersAndLetters(32));
        parasMap.put(TConstant.PARA_OAUTH_CALLBACK, callBackUrl);
        parasMap.put(TConstant.PARA_OAUTH_VERSION, TConstant.VALUE_OAUTH_VERSION);

        TSign qqTSign = new TSign();
        qqTSign.setBaseUrl(TConstant.GET_REQUEST_TOKEN_URL);
        qqTSign.setHttpMethod(HttpUtils.HTTP_GET_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(TConstant.PARA_OAUTH_SIGNATURE, TSignAndHttpUtils.signature(qqTSign));

        /** response格式类似oauth_token=hdk48Djdsa&oauth_token_secret=xyz4992k83j47x0b&oauth_callback_confirmed=true **/
        String response = HttpUtils.httpGetEncodeParas(TConstant.GET_REQUEST_TOKEN_URL, parasMap);
        return StringUtils.isEmpty(response) ? null : HttpUtils.getParasMap(response);
    }

    @Override
    public Map<String, String> getAuthorizedRequestToken(String query) {
        /** response格式类似oauth_token=hdk48Djdsa&oauth_verifier=473f82d3 **/
        return (StringUtils.isEmpty(query)) ? null : HttpUtils.getParasMap(query);
    }

    @Override
    public Map<String, String> getAccessToken(String oauthToken, String oauthVerifier, String requestTokenSecret) {
        if (StringUtils.isEmpty(oauthToken) || StringUtils.isEmpty(oauthVerifier)) {
            return null;
        }

        Map<String, String> parasMap = TParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(), oauthToken);
        parasMap.put(TConstant.PARA_OAUTH_VERIFIER, oauthVerifier);
        TSign qqTSign = new TSign();
        qqTSign.setBaseUrl(TConstant.GET_ACCESS_TOKEN_URL);
        qqTSign.setHttpMethod(HttpUtils.HTTP_GET_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(requestTokenSecret);
        qqTSign.setParasMap(parasMap);
        parasMap.put(TConstant.PARA_OAUTH_SIGNATURE, TSignAndHttpUtils.signature(qqTSign));

        /** response格式类似oauth_token=nnch734d00ls2jdk&oauth_token_secret=pdkkdhi9sl3r4s00 **/
        String response = HttpUtils.httpGetEncodeParas(TConstant.GET_ACCESS_TOKEN_URL, parasMap);
        return StringUtils.isEmpty(response) ? null : HttpUtils.getParasMap(response);
    }
}
