package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsMember entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_member", catalog = "webims_cms")
public class WebimsMember implements java.io.Serializable {

	// Fields

	private Integer memberId;
	private Integer membergroupId;
	private String avatar;
	private String selintro;
	private String comeFrom;
	private String gender;
	private Integer status;

	// Constructors

	/** default constructor */
	public WebimsMember() {
	}

	/** minimal constructor */
	public WebimsMember(Integer memberId, Integer membergroupId, Integer status) {
		this.memberId = memberId;
		this.membergroupId = membergroupId;
		this.status = status;
	}

	/** full constructor */
	public WebimsMember(Integer memberId, Integer membergroupId, String avatar,
			String selintro, String comeFrom, String gender, Integer status) {
		this.memberId = memberId;
		this.membergroupId = membergroupId;
		this.avatar = avatar;
		this.selintro = selintro;
		this.comeFrom = comeFrom;
		this.gender = gender;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "member_id", unique = true, nullable = false)
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "membergroup_id", nullable = false)
	public Integer getMembergroupId() {
		return this.membergroupId;
	}

	public void setMembergroupId(Integer membergroupId) {
		this.membergroupId = membergroupId;
	}

	@Column(name = "avatar")
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "selintro")
	public String getSelintro() {
		return this.selintro;
	}

	public void setSelintro(String selintro) {
		this.selintro = selintro;
	}

	@Column(name = "come_from", length = 100)
	public String getComeFrom() {
		return this.comeFrom;
	}

	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}

	@Column(name = "gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}