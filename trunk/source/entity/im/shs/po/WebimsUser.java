package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WebimsUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_user", catalog = "webims", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class WebimsUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer orgId;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String realName;
	private String mobile;
	private Timestamp prevLoginDate;
	private String prevLoginIp;
	private Timestamp lastLoginDate;
	private String lastLoginIp;
	private Timestamp creationDate;
	private String creationIp;
	private Integer logins;
	private Integer status;

	// Constructors

	/** default constructor */
	public WebimsUser() {
	}

	/** minimal constructor */
	public WebimsUser(Integer userId, Integer orgId, String username,
			Timestamp creationDate, String creationIp, Integer logins,
			Integer status) {
		this.userId = userId;
		this.orgId = orgId;
		this.username = username;
		this.creationDate = creationDate;
		this.creationIp = creationIp;
		this.logins = logins;
		this.status = status;
	}

	/** full constructor */
	public WebimsUser(Integer userId, Integer orgId, String username,
			String password, String salt, String email, String realName,
			String mobile, Timestamp prevLoginDate, String prevLoginIp,
			Timestamp lastLoginDate, String lastLoginIp,
			Timestamp creationDate, String creationIp, Integer logins,
			Integer status) {
		this.userId = userId;
		this.orgId = orgId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.realName = realName;
		this.mobile = mobile;
		this.prevLoginDate = prevLoginDate;
		this.prevLoginIp = prevLoginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.creationDate = creationDate;
		this.creationIp = creationIp;
		this.logins = logins;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "org_id", nullable = false)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", length = 32)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "real_name", length = 100)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "mobile", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "prev_login_date", length = 19)
	public Timestamp getPrevLoginDate() {
		return this.prevLoginDate;
	}

	public void setPrevLoginDate(Timestamp prevLoginDate) {
		this.prevLoginDate = prevLoginDate;
	}

	@Column(name = "prev_login_ip", length = 100)
	public String getPrevLoginIp() {
		return this.prevLoginIp;
	}

	public void setPrevLoginIp(String prevLoginIp) {
		this.prevLoginIp = prevLoginIp;
	}

	@Column(name = "last_login_date", length = 19)
	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "last_login_ip", length = 100)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "creation_ip", nullable = false, length = 100)
	public String getCreationIp() {
		return this.creationIp;
	}

	public void setCreationIp(String creationIp) {
		this.creationIp = creationIp;
	}

	@Column(name = "logins", nullable = false)
	public Integer getLogins() {
		return this.logins;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}