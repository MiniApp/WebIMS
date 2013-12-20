package im.shs.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_t_user")
public class TUser implements Serializable {

    private static final long    serialVersionUID = 3298635316340763420L;

    private Long                 userId;                                 // 用户id
    private String               userName;                               // 用户名
    private String               userScreenName;                         // 用户昵称
    private String               userDescription;                        // 个人介绍
    private String               iconUrl;                                // 头像图片地址

    /** 用户性别 1男 2 女 0未知 **/
    private String               sex;
    private String               birthYear;                              // 出生年
    private String               birthMonth;                             // 出生月
    private String               birthDay;                               // 出生日

    private long                 followersCount;                         // 听众数
    private long                 friendsCount;                           // 收听的人数
    private long                 statusesCount;                          // 微博数

    private Map<String, String>  tagMap;                                 // 个人标签，key为标签id，name为标签名
    private List<TUserEduInfo> EduInfoList;                            // 学历信息

    private String               location;                               // 发表者所在地
    private String               countryCode;                            // 国家码(其他时间线一样)
    private String               provinceCode;                           // 省份码(其他时间线一样)
    private String               cityCode;                               // 城市码(其他时间线一样)

    private boolean              isMyInterested;                         // 是否是我收听的
    private boolean              isVip;                                  // 是否认证用户
    private boolean              isEnt;                                  // 是否企业机构
    private String               verifyInfo;                             // 认证信息

    private List<TStatus>      latestStatusList;                       // 用户最近微博列表

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
