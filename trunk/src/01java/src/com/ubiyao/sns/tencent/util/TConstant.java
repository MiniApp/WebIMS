package com.ubiyao.sns.tencent.util;

public class TConstant {

    /** ��Ϣ���� **/
    public final static int    UPDATE_STATUS_SUCC_WHAT               = 70;
    public final static int    UPDATE_STATUS_FAIL_WHAT               = -70;
    public final static int    COMMENT_STATUS_SUCC_WHAT              = 71;
    public final static int    COMMENT_STATUS_FAIL_WHAT              = -71;
    public final static int    REPOST_STATUS_SUCC_WHAT               = 72;
    public final static int    REPOST_STATUS_FAIL_WHAT               = -72;
    public static String       OPERATOR_FAIL_REASON                  = "";

    /** OAuth��֤���� **/
    public final static String GET_REQUEST_TOKEN_URL                 = "http://open.t.qq.com/cgi-bin/request_token";
    public final static String GET_AUTHORIZATION_URL                 = "http://open.t.qq.com/cgi-bin/authorize";
    public final static String GET_ACCESS_TOKEN_URL                  = "http://open.t.qq.com/cgi-bin/access_token";

    /** ÿҳ״̬�ĸ��� **/
    public static int          STATUS_COUNT_PER_PAGE                 = 20;

    /** apiʹ��ʱ�ı�׼���� **/
    public static String       PARA_OAUTH_CONSUMER_KEY               = "oauth_consumer_key";
    public static String       PARA_OAUTH_NONCE                      = "oauth_nonce";
    public static String       PARA_OAUTH_SIGNATURE                  = "oauth_signature";
    public static String       PARA_OAUTH_SIGNATURE_METHOD           = "oauth_signature_method";
    public static String       PARA_OAUTH_TIMESTAMP                  = "oauth_timestamp";
    public static String       PARA_OAUTH_TOKEN                      = "oauth_token";
    public static String       PARA_OAUTH_VERSION                    = "oauth_version";

    /** apiʹ�õĲ��ֱ�׼����ֵ **/
    public static String       VALUE_OAUTH_VERSION                   = "1.0";
    public static String       VALUE_OAUTH_SIGNATURE_METHOD          = "HMAC-SHA1";

    /** apiʹ��ʱ��������� **/
    public static String       PARA_OAUTH_VERIFIER                   = "oauth_verifier";
    public static String       PARA_OAUTH_TOKEN_SECRET               = "oauth_token_secret";
    public static String       PARA_OAUTH_CALLBACK                   = "oauth_callback";
    public static String       PARA_FORMAT                           = "format";

    /**
     * ΢��ʱ�����й�apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E6%97%B6%E9%97%B4%E7%BA%BF
     **/
    /** ��ҳʱ���� **/
    public static String       GET_HOME_TL_URL                       = "http://open.t.qq.com/api/statuses/home_timeline";
    /** �㲥����ʱ���� **/
    public static String       GET_PUBLIC_TL_URL                     = "http://open.t.qq.com/api/statuses/public_timeline";
    /** �����û�����ʱ���� **/
    public static String       GET_USER_TL_URL                       = "http://open.t.qq.com/api/statuses/user_timeline";
    /** �û��ἰʱ���� **/
    public static String       GET_MENTIONS_TL_URL                   = "http://open.t.qq.com/api/statuses/mentions_timeline";
    /** ����ʱ���� **/
    public static String       GET_TOPIC_TL_URL                      = "http://open.t.qq.com/api/statuses/ht_timeline";
    /** �ҷ���ʱ���� **/
    public static String       GET_BROADCAST_TL_URL                  = "http://open.t.qq.com/api/statuses/broadcast_timeline";
    /** �ر�������˷���ʱ���� **/
    public static String       GET_SPECIAL_TL_URL                    = "http://open.t.qq.com/api/statuses/special_timeline";
    /** �����ʱ���� **/
    public static String       GET_AREA_TL_URL                       = "http://open.t.qq.com/api/statuses/area_timeline";
    /** ��ҳʱ�������� **/
    public static String       GET_HOME_TL_IDS_URL                   = "http://open.t.qq.com/api/statuses/home_timeline_ids";
    /** �����û�����ʱ�������� **/
    public static String       GET_USER_TL_IDS_URL                   = "http://open.t.qq.com/api/statuses/user_timeline_ids";
    /** �ҷ���ʱ�������� **/
    public static String       GET_BROADCAST_TL_IDS_URL              = "http://open.t.qq.com/api/statuses/broadcast_timeline_ids";
    /** �û��ἰʱ�������� **/
    public static String       GET_MENTIONS_TL_IDS_URL               = "http://open.t.qq.com/api/statuses/mentions_timeline_ids";
    /** ���û�����ʱ���� **/
    public static String       GET_USERS_TL_URL                      = "http://open.t.qq.com/api/statuses/users_timeline";
    /** ���û�����ʱ�������� **/
    public static String       GET_USERS_TL_IDS_URL                  = "http://open.t.qq.com/api/statuses/users_timeline_ids";
    /** ��ȡvip�û�����΢������Ϣ **/
    public static String       GET_VIP_STATUS_TL_URL                 = "http://open.t.qq.com/api/status/home_timeline_vip";

    /**
     * ΢��ʱ�����й�apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** ��ҳ��ʶ��0����һҳ��1�����·�ҳ��2���Ϸ�ҳ�� **/
    public static String       PARA_PAGE_FLAG                        = "pageflag";
    /** ��ҳ��ʼʱ�䣨��һҳ ʱ��0������ҳ������һ�����󷵻ص����һ����¼ʱ�䣩 **/
    public static String       PARA_PAGE_TIME                        = "pagetime";
    /** ��һҳ ʱ��0,�������·�ҳ������һ�����󷵻ص����һ����¼id����ҳ�� **/
    public static String       PARA_LAST_ID                          = "lastid";
    /** ��Ҫ��ȡ���û��û����˽�Ž����� **/
    public static String       PARA_USER_NAME                        = "name";
    /** ��Ҫ��ȡ��һ���û��û��� **/
    public static String       PARA_USER_NAMES                       = "names";
    /** ��Ҫ��ȡ���û�open id **/
    public static String       PARA_USER_OPEN_ID                     = "fopenid";
    /** ��Ҫ��ȡ��һ���û�open id **/
    public static String       PARA_USER_OPEN_IDS                    = "fopenids";
    /** ÿ�������¼������1-70���� **/
    public static String       PARA_PAGE_REQ_NUM                     = "reqnum";
    /** ��ȡ����, 0x1 ԭ������ 0x2 ת�� 0x8 �ظ� 0x10 �ջ� 0x20 �ἰ 0x40 ���� , ������ȡ���������|��(0x1|0x2) �õ�3��type=3����,�����ʾ��ȡ�������� **/
    public static String       PARA_STATUS_TYPE                      = "type";
    /** ���ݹ��� �����ʾ�������� 1-���ı� 2-������ 4ͼƬ 8-����Ƶ 0x10-����Ƶ **/
    public static String       PARA_CONTENT_TYPE                     = "contenttype";
    /** Ȩ�ޱ�ʶ 1 ��ʾֻ��ʾ�ҷ���� **/
    public static String       PARA_ACCESS_LEVEL                     = "accesslevel";
    /** ��¼����ʼλ�ã���һ����������0��������������ϴη��ص�pos�� **/
    public static String       PARA_POSITION                         = "pos";
    /** ��ʶ0 ת���б?1�����б� 2 ������ת���б� **/
    public static String       PARA_REPOST_OR_COMMENT_FLAG           = "flag";
    /** ת�����߻ظ�����id��Դ΢��id�� **/
    public static String       PARA_ROOT_ID                          = "rootid";
    /** 1-100����0,�������·�ҳ������һ�����󷵻ص����һ����¼id����ҳ�� **/
    public static String       PARA_TWITTER_ID                       = "twitterid";
    /** ��ȡ�ղص�΢���б�ʱʹ�ã����·�ҳ��ʼʱ�䣨��һҳ ʱ��0������ҳ������һ�����󷵻ص�nexttimeʱ�䣩 **/
    public static String       PARA_NEXT_TIME                        = "nexttime";
    /** ��ȡ�ղص�΢���б�ʱʹ�ã����·� **/
    public static String       PARA_PREV_TIME                        = "prevtime";

    /**
     * ΢��ʱ�����й�apiʹ��ʱ�Ĳ��ֲ���ֵ
     **/
    /** {@link TConstant#GET_COMMENTS_URL} flag:��ʶ0 ת���б?1�����б� 2 ������ת���б� **/
    public static int          VALUE_REPOST_FLAG                     = 0;
    public static int          VALUE_COMMENT_FLAG                    = 1;
    public static int          VALUE_REPOST_AND_COMMENT_FLAG         = 2;
    public static int          VALUE_PAGE_REQ_NUM                    = 20;
    public static int          VALUE_FIRST_PAGE                      = 0;
    public static int          VALUE_NEXT_PAGE                       = 1;
    public static int          VALUE_LAST_PAGE                       = 2;

    /**
     * ΢��ʱ�����й�apiʹ��ʱ�Ĳ��ֲ���ֵ
     **/
    /** ��ȡ����, 0x0 ��ȡ�������� **/
    public static int          VALUE_STATUS_TYPE_TL_ALL              = 0x0;
    /** ��ȡ����, 0x1 ԭ������ **/
    public static int          VALUE_STATUS_TYPE_TL_ORIGINAL         = 0x1;
    /** ��ȡ����, 0x2 ת�� **/
    public static int          VALUE_STATUS_TYPE_TL_REPOST           = 0x2;
    /** ��ȡ����, 0x8 �ظ� **/
    public static int          VALUE_STATUS_TYPE_TL_REPLY            = 0x8;
    /** ��ȡ����, 0x10 �ջ� **/
    public static int          VALUE_STATUS_TYPE_TL_NULL_COMMENT     = 0x10;
    /** ��ȡ����, 0x20 �ἰ **/
    public static int          VALUE_STATUS_TYPE_TL_Mention          = 0x20;
    /** ��ȡ����, 0x40 ���� **/
    public static int          VALUE_STATUS_TYPE_TL_COMMENT          = 0x40;

    /**
     * ���ݹ������� �����ʾ�������� 1-���ı� 2-������ 4ͼƬ 8-����Ƶ 0x10-����Ƶ
     */
    /** ���ݹ�������, 0x0 ��ȡ�������� **/
    public static int          VALUE_CONTENT_TYPE_TL_ALL             = 0x0;
    /** ���ݹ�������, 0x1 ���ı� **/
    public static int          VALUE_CONTENT_TYPE_TL_TEXT            = 0x1;
    /** ���ݹ�������, 0x2 ������ **/
    public static int          VALUE_CONTENT_TYPE_TL_LINK            = 0x2;
    /** ���ݹ�������, 0x4 ��ͼƬ **/
    public static int          VALUE_CONTENT_TYPE_TL_PICTURE         = 0x4;
    /** ���ݹ�������, 0x8 ����Ƶ **/
    public static int          VALUE_CONTENT_TYPE_TL_VIDEO           = 0x8;
    /** ���ݹ�������, 0x10 ����Ƶ **/
    public static int          VALUE_CONTENT_TYPE_TL_MUSIC           = 0x10;
    /** Ȩ�ޱ�ʶ 1 ��ʾֻ��ʾ�ҷ���� **/
    public static int          VALUE_ACCESS_LEVEL_TL_MINE            = 1;

    /**
     * ΢�����apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    /** ��ȡһ��΢����� **/
    public static String       GET_STATUS_URL                        = "http://open.t.qq.com/api/t/show";
    /** ����һ��΢���� **/
    public static String       ADD_STATUS_URL                        = "http://open.t.qq.com/api/t/add";
    /** ɾ��һ��΢�� **/
    public static String       DELETE_STATUS_URL                     = "http://open.t.qq.com/api/t/del";
    /** ת��һ��΢�� **/
    public static String       REPOST_STATUS_URL                     = "http://open.t.qq.com/api/t/re_add";
    /** �ظ�һ��΢�� **/
    public static String       REPLY_STATUS_URL                      = "http://open.t.qq.com/api/t/reply";
    /** ����һ����ͼƬ��΢�� **/
    public static String       ADD_STATUS_WITH_PIC_URL               = "http://open.t.qq.com/api/t/add_pic";
    /** ת���������� **/
    public static String       GET_REPOST_AND_COMMENT_COUNT_URL      = "http://open.t.qq.com/api/t/re_count";
    /** ��ȡ����΢����ת��������б� **/
    public static String       GET_COMMENTS_URL                      = "http://open.t.qq.com/api/t/re_list";
    /** ����һ��΢�� **/
    public static String       COMMENT_STATUS_URL                    = "http://open.t.qq.com/api/t/comment";
    /** ��������΢�� **/
    public static String       ADD_MUSIC_STATUS_URL                  = "http://open.t.qq.com/api/t/add_music";
    /** ������Ƶ΢�� **/
    public static String       ADD_VIDEO_STATUS_URL                  = "http://open.t.qq.com/api/t/add_video";
    /** ��ȡ��Ƶ��Ϣ **/
    public static String       GET_VIDEO_INFO_URL                    = "http://open.t.qq.com/api/t/getvideoinfo";
    /** ���΢��id������ȡ΢������ **/
    public static String       GET_STATUS_BY_IDS_URL                 = "http://open.t.qq.com/api/t/list";
    /** ��ȡת�����ٴ�ת���� **/
    public static String       GET_RE_REPOST_COUNT_URL               = "http://open.t.qq.com/api/t/sub_re_count";
    /** ������������ **/
    public static String       ADD_EMOTION_STATUS_URL                = "http://open.t.qq.com/api/t/add_emotion";

    /**
     * ΢�����apiʹ��ʱ�Ĳ��ֲ���
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    public static String       PARA_CONTENT                          = "content";
    public static String       PARA_LONGITUDE                        = "jing";
    public static String       PARA_LATITUDE                         = "wei";
    public static String       PARA_CLIENT_IP                        = "clientip";
    public static String       PARA_MUSIC_URL                        = "url";
    public static String       PARA_MUSIC_TITLE                      = "title";
    public static String       PARA_MUSIC_AUTHOR                     = "author";
    public static String       PARA_VIDEO_URL                        = "url";
    public static String       PARA_REPLY_ID                         = "reid";
    public static String       PARA_PICTURE                          = "pic";
    public static String       PARA_RE_COUNTIDS                      = "ids";
    public static String       PARA_RE_COUNT_FLAG                    = "flag";
    public static String       PARA_STATUS_IDS                       = "ids";
    public static String       PARA_SIGN_TYPE                        = "signtype";

    /**
     * ΢�����apiʹ��ʱ�Ĳ��ֲ���ֵ
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    /** ת����������api,0��ȡת������1��������, 2���߶�ȡ **/
    public static int          VALUE_RE_COUNT_FLAG_REPOST            = 0;
    public static int          VALUE_RE_COUNT_FLAG_COMMENT           = 1;
    public static int          VALUE_RE_COUNT_FLAG_ALL               = 2;

    /** ����΢��apiʹ��ʱ�Ĳ��ֲ���ֵ **/
    public static String       VALUE_FORMAT_JSON                     = "json";
    public static String       VALUE_FORMAT_XML                      = "xml";
    public static String       VALUE_CLIENT_IP                       = "127.0.0.1";

    public static String       PARA_STATUS_ID                        = "id";

    /**
     * ΢�����api���ص�json key
     */
    public static String       JSON_VIDEO_MINIPIC                    = "minipic";
    public static String       JSON_VIDEO_PLAYER                     = "player";
    public static String       JSON_VIDEO_REAL                       = "real";
    public static String       JSON_VIDEO_SHORT                      = "short";
    public static String       JSON_VIDEO_TITLE                      = "title";

    /**
     * ΢���ʻ����apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3
     */
    /** ��ȡ�Լ�����ϸ���� **/
    public static String       GET_SELF_INFO_URL                     = "http://open.t.qq.com/api/user/info";
    /** �����û���Ϣ **/
    public static String       UPDATE_USER_INFO_URL                  = "http://open.t.qq.com/api/user/update";
    /** �����û�ͷ����Ϣ **/
    public static String       UPDATE_USER_HEAD_INFO_URL             = "http://open.t.qq.com/api/user/update_head";
    /** �����û�������Ϣ **/
    public static String       UPDATE_USER_EDU_INFO_URL              = "http://open.t.qq.com/api/user/update_edu";
    /** ��ȡ���������� **/
    public static String       GET_OTHER_USER_INFO_URL               = "http://open.t.qq.com/api/user/other_info";
    /** ��ȡһ���˵ļ����� **/
    public static String       GET_OTHER_USERS_INFO_URL              = "http://open.t.qq.com/api/user/infos";
    /** ��ȡһ���˵ļ����� **/
    public static String       GET_SEVERAL_USER_INFOS_URL            = "http://open.t.qq.com/api/user/infos";
    /** ��֤�˻��Ƿ�Ϸ� **/
    public static String       VERIFY_ACCOUNT_URL                    = "http://open.t.qq.com/api/user/verify";

    /** ΢���ʻ����apiʹ��ʱ�Ĳ��ֲ��� **/
    public static String       PARA_NICK                             = "nick";
    public static String       PARA_SEX                              = "sex";
    public static String       PARA_BIRTH_YEAR                       = "year";
    public static String       PARA_BIRTH_MONTH                      = "month";
    public static String       PARA_BIRTH_DAY                        = "day";
    public static String       PARA_COUNTRY_CODE                     = "countrycode";
    public static String       PARA_PROVINCE_CODE                    = "provincecode";
    public static String       PARA_CITY_CODE                        = "citycode";
    public static String       PARA_INTRODUCTION                     = "introduction";
    public static String       PARA_USER_ICON                        = "pic";
    public static String       PARA_USER_EDU_FEILD_ID                = "feildid";
    public static String       PARA_USER_EDU_YEAR                    = "year";
    public static String       PARA_USER_EDU_SCHOOL_ID               = "schoolid";
    public static String       PARA_USER_EDU_DEPARTMENT_ID           = "departmentid";
    public static String       PARA_USER_EDU_LEVEL                   = "level";
    public static String       PARA_VERIFY_ACCOUNT_NAME              = "name";
    public static String       PARA_VERIFY_ACCOUNT_ID                = "fopenid";

    /**
     * ΢����ϵ�����apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E5%85%B3%E7%B3%BB%E9%93%BE%E7%9B%B8%E5%85%B3
     */
    /** �ҵ������б� **/
    public static String       GET_SELF_FANS_URL                     = "http://open.t.qq.com/api/friends/fanslist";
    /** �ҵ����������б� **/
    public static String       GET_SELF_FANS_NAMES_URL               = "http://open.t.qq.com/api/friends/fanslist_name";
    /** ����������б� **/
    public static String       GET_SELF_INTERESTED_URL               = "http://open.t.qq.com/api/friends/idollist";
    /** ��������������б� **/
    public static String       GET_SELF_INTERESTED_NAMES_URL         = "http://open.t.qq.com/api/friends/idollist_name";
    /** �����б� **/
    public static String       GET_SELF_BLACK_LIST_URL               = "http://open.t.qq.com/api/friends/blacklist";
    /** �ҵ������б?����Ϣ��200���� **/
    public static String       GET_SELF_FANS_SIMPLE_URL              = "http://open.t.qq.com/api/friends/fanslist_s";
    /** �ҵ������б?����Ϣ��200���� **/
    public static String       GET_SELF_INTERESTED_SIMPLE_URL        = "http://open.t.qq.com/api/friends/idollist_s";
    /** �ر������б� **/
    public static String       GET_SELF_SPECIAL_INTERESTED_URL       = "http://open.t.qq.com/api/friends/speciallist";
    /** ����ĳ���û� **/
    public static String       ADD_FRIEND_URL                        = "http://open.t.qq.com/api/friends/add";
    /** ȡ������ĳ���û� **/
    public static String       DELETE_FRIEND_URL                     = "http://open.t.qq.com/api/friends/del";
    /** �ر�����ĳ���û� **/
    public static String       ADD_SPECIAL_FRIEND_URL                = "http://open.t.qq.com/api/friends/addspecial";
    /** ȡ���ر�����ĳ���û� **/
    public static String       DELETE_SPECIAL_FRIEND_URL             = "http://open.t.qq.com/api/friends/delspecial";
    /** ���ĳ���û������� **/
    public static String       ADD_OTHER_TO_BLACK_LIST_URL           = "http://open.t.qq.com/api/friends/addblacklist";
    /** �Ӻ�����ɾ��ĳ���û� **/
    public static String       DELETE_OTHER_FROM_BLACK_LIST_URL      = "http://open.t.qq.com/api/friends/delblacklist";
    /** ����Ƿ��ҵ����ڻ�������� **/
    public static String       CHECK_RELATION_WITH_SELF_URL          = "http://open.t.qq.com/api/friends/check";
    /** �����ʻ������б� **/
    public static String       GET_OTHER_USER_FANS_URL               = "http://open.t.qq.com/api/friends/user_fanslist";
    /** �����ʻ���������б� **/
    public static String       GET_OTHER_USER_INTERESTED_URL         = "http://open.t.qq.com/api/friends/user_idollist";
    /** �����ʻ��ر���������б� **/
    public static String       GET_OTHER_USER_SPECIAL_INTERESTED_URL = "http://open.t.qq.com/api/friends/user_speciallist";
    /** �����ϵ���б� **/
    public static String       GET_Mutual_INTERESTED_URL             = "http://open.t.qq.com/api/friends/mutual_list";

    /** ΢����ϵ�����apiʹ��ʱ�Ĳ��ֲ��� **/
    /** ������� **/
    public static String       PARA_REQ_NUM                          = "reqnum";
    /** ��ʼλ��(��һҳ��0���������·�ҳ���[reqnum*(page-1)]) **/
    public static String       PARA_START_INDEX                      = "startindex";
    /** �û��ʻ����ѡ�� **/
    public static String       PARA_RELATION_USER_NAMES              = "names";
    /** �û�openid(��ѡ),name��fopenid����ѡһ������ͬʱ��������nameֵΪ�� **/
    public static String       PARA_RELATION_USER_OPEN_ID            = "fopenid";
    /** �û�openids(��ѡ),name��fopenids����ѡһ������ͬʱ��������nameֵΪ�� **/
    public static String       PARA_RELATION_USER_OPEN_IDS           = "fopenids";
    /** **/
    public static String       PARA_RELATION_FLAG                    = "flag";

    /** ΢����ϵ�����apiʹ��ʱ�Ĳ��ֲ��� ֵ **/
    /** ������ڱ�־ **/
    public static int          VALUE_FANS_RELATION_FLAG              = 0;
    /** ���������˱�־ **/
    public static int          VALUE_INTERESTED_RELATION_FLAG        = 1;
    /** ���ֹ�ϵ������־ **/
    public static int          VALUE_BOTH_RELATION_FLAG              = 2;

    /**
     * ΢��˽�����apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3
     */
    /** ��˽�� **/
    public static String       SEND_MESSAGE_URL                      = "http://open.t.qq.com/api/private/add";
    /** ɾ��һ��˽�� **/
    public static String       DELETE_MESSAGE_URL                    = "http://open.t.qq.com/api/private/del";
    /** �ռ��� **/
    public static String       GET_RECEIVE_MESSAGES_URL              = "http://open.t.qq.com/api/private/recv";
    /** ������ **/
    public static String       GET_SEND_MESSAGES_URL                 = "http://open.t.qq.com/api/private/send";

    /**
     * ΢���������apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E6%90%9C%E7%B4%A2%E7%9B%B8%E5%85%B3
     */
    /** �����û� **/
    public static String       SEARCH_USER_URL                       = "http://open.t.qq.com/api/search/user";
    /** ����΢�� **/
    public static String       SEARCH_STATUS_URL                     = "http://open.t.qq.com/api/search/t";
    /** ͨ���ǩ�����û� **/
    public static String       SEARCH_USER_BY_TAG_URL                = "http://open.t.qq.com/api/search/userbytag";

    /**
     * ΢���������apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** �����ؼ��� **/
    public static String       PARA_KEYWORD                          = "keyword";
    /** ÿҳ��С **/
    public static String       PARA_PAGE_SIZE                        = "pagesize";
    /** ҳ�� **/
    public static String       PARA_PAGE                             = "page";

    /**
     * ΢���ȶȣ��������apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E7%83%AD%E5%BA%A6%EF%BC%8C%E8%B6%8B%E5%8A%BF
     */
    /** �����Ȱ� **/
    public static String       GET_HOT_TOPICS_URL                    = "http://open.t.qq.com/api/trends/ht";
    /** ת���Ȱ� **/
    public static String       GET_HOT_REPOSTS_URL                   = "http://open.t.qq.com/api/trends/t";

    /**
     * ΢���ȶȣ��������apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** �������� 1 ������2 �����ؼ��� 3 �������Ͷ��� **/
    public static String       PARA_HOT_SEARCH_TYPE                  = "type";
    /** ������� **/
    public static String       PARA_REQ_NUMBER                       = "reqnum";
    /** ����λ�ã���һ������ʱ��0���������ϴη��ص�pos **/
    public static String       PARA_LAST_POSITION                    = "pos";

    /**
     * ΢����ݸ������apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E6%95%B0%E6%8D%AE%E6%9B%B4%E6%96%B0%E7%9B%B8%E5%85%B3/%E6%9F%A5%E7%9C%8B%E6%
     * 95%B0%E6%8D%AE%E6%9B%B4%E6%96%B0%E6%9D%A1%E6%95%B0
     */
    /** �鿴��ݸ������� **/
    public static String       GET_UPDATE_INFO_NUM_URL               = "http://open.t.qq.com/api/info/update";

    /**
     * ΢����ݸ������apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** �������� 0��ֻ�����������������1�����������Ը��������� **/
    public static String       PARA_REQ_TYPE                         = "op";
    /** 5 ��ҳδ����Ϣ����61-100������ 7 ˽��ҳ��Ϣ���� 8 ���������� 9 ��ҳ�㲥��ԭ���ģ� **/
    public static String       PARA_CLEAR_TYPE                       = "type";

    /** ΢����ݸ������apiʹ��ʱ�Ĳ��ֲ���ֵ **/
    /**
     * 5-��ҳδ����Ϣ����6-@ҳδ����Ϣ����7-˽��ҳ��Ϣ����8-����������9-��ҳ�㲥��ԭ���ģ�
     */
    /** ΢����ݸ��� 5-��ҳδ����Ϣ���� **/
    public static int          VALUE_CLEAR_TYPE_HOME_PAGE            = 5;
    /** ΢����ݸ��� 6-@ҳδ����Ϣ���� **/
    public static int          VALUE_CLEAR_TYPE_AT                   = 6;
    /** ΢����ݸ��� 7-˽��ҳ��Ϣ���� **/
    public static int          VALUE_CLEAR_TYPE_PRIVATE_MSG          = 7;
    /** ΢����ݸ��� 8-���������� **/
    public static int          VALUE_CLEAR_TYPE_NEW_FANS             = 8;
    /** ΢����ݸ��� 9-��ҳ�㲥��ԭ���ģ� **/
    public static int          VALUE_CLEAR_TYPE_HOME_BROADCAST       = 9;

    /**
     * ΢������ղ����apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E6%95%B0%E6%8D%AE%E6%94%B6%E8%97%8F
     */
    /** �ղ�һ��΢�� **/
    public static String       COLLECT_STATUS_URL                    = "http://open.t.qq.com/api/fav/addt";
    /** ȡ���ղ�һ��΢�� **/
    public static String       UNCOLLECT_STATUS_URL                  = "http://open.t.qq.com/api/fav/delt";
    /** �ղص�΢���б� **/
    public static String       GET_COLLECT_STATUS_URL                = "http://open.t.qq.com/api/fav/list_t";
    /** ���Ļ��� **/
    public static String       SUBSCRIBE_TOPIC_URL                   = "http://open.t.qq.com/api/fav/addht";
    /** ȡ���Ļ��� **/
    public static String       UNSUBSCRIBE_TOPIC_URL                 = "http://open.t.qq.com/api/fav/delht";
    /** ��ȡ�Ѷ��Ļ����б� **/
    public static String       GET_SUBSCRIBE_TOPICS_URL              = "http://open.t.qq.com/api/fav/list_ht";

    /**
     * ΢���������apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E8%AF%9D%E9%A2%98%E7%9B%B8%E5%85%B3
     */
    /** ��ݻ�����Ʋ�ѯ����id **/
    public static String       GET_TOPIC_ID_URL                      = "http://open.t.qq.com/api/ht/ids";
    /** ��ݻ���id��ȡ���������Ϣ **/
    public static String       GET_TOPIC_INFO_URL                    = "http://open.t.qq.com/api/ht/info";

    /**
     * ΢���������apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** ���������б?abc,efg,�� **/
    public static String       PARA_TOPIC_NAMES                      = "httexts";
    /** ����id�б?�Զ��ŷָ�����12345,12345 **/
    public static String       PARA_TOPIC_IDS                        = "ids";

    /**
     * ΢����ǩ���apiʹ��ʱ��url
     * http://wiki.open.t.qq.com/index.php/%E8%AF%9D%E9%A2%98%E7%9B%B8%E5%85%B3
     */
    /** ��ӱ�ǩ **/
    public static String       ADD_TAG_URL                           = "http://open.t.qq.com/api/tag/add";
    /** ɾ���ǩ **/
    public static String       DELETE_TAG_URL                        = "http://open.t.qq.com/api/tag/del";

    /**
     * ΢����ǩ���apiʹ��ʱ�Ĳ��ֲ���
     **/
    /** ��ǩ���� **/
    public static String       PARA_TAG_NAME                         = "tag";
    /** ��ǩid **/
    public static String       PARA_TAG_ID                           = "tagid";

    /** mac ����ʱ���㷨 **/
    public static String       MAC_ALGORITHM                         = "HmacSHA1";
    /** ����ʱ��encoding�ַ� **/
    public static String       MAC_ENCODING                          = "US-ASCII";

    /** api ���صĲ��ֲ��� **/
    public static String       RET_PARA_MSG                          = "msg";
    public static String       RET_PARA_RET                          = "ret";

    /** api ���صĲ��ֲ�����ֵ **/
    public static String       RET_VALUE_MSG                         = "ok";
    public static int          RET_VALUE_RET                         = 0;

    /** api ���ص�json���е��ֶ� **/

    /** ����ͷ��ͼƬ��С���ƣ� ����20��30��40��50��100����http://open.t.qq.com/resource.php?i=2,1#faq_common ��5�� **/
    public static int          HEAD_ICON_SIZE_20                     = 20;
    public static int          HEAD_ICON_SIZE_30                     = 30;
    public static int          HEAD_ICON_SIZE_40                     = 40;
    public static int          HEAD_ICON_SIZE_50                     = 50;
    public static int          HEAD_ICON_SIZE_100                    = 100;

    /** ����ͼƬ�Ĵ�С���ƣ�����120��160��460��2000����http://open.t.qq.com/resource.php?i=2,1#faq_common ��6�� **/
    public static int          IMAGE_SIZE_60                         = 60;
    public static int          IMAGE_SIZE_120                        = 120;
    public static int          IMAGE_SIZE_240                        = 240;
    public static int          IMAGE_SIZE_460                        = 460;
    public static int          IMAGE_SIZE_2000                       = 2000;

    /**
     * api���ص�״̬����
     * 1-ԭ�����?2-ת�ء�3-˽�� 4-�ظ� 5-�ջ� 6-�ἰ 7-����
     **/
    public static int          VALUE_STATUS_TYPE_ORIGINAL            = 1;
    public static int          VALUE_STATUS_TYPE_REPOST              = 2;
    public static int          VALUE_STATUS_TYPE_PRIVATE_MSG         = 3;
    public static int          VALUE_STATUS_TYPE_REPLY               = 4;
    public static int          VALUE_STATUS_TYPE_NULL_COMMENT        = 5;
    public static int          VALUE_STATUS_TYPE_Mention             = 6;
    public static int          VALUE_STATUS_TYPE_COMMENT             = 7;
}
