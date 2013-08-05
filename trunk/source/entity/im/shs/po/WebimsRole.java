package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_role", catalog = "webims")
public class WebimsRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private Integer siteId;
	private String name;
	private String description;
	private Integer seq;

	// Constructors

	/** default constructor */
	public WebimsRole() {
	}

	/** minimal constructor */
	public WebimsRole(Integer roleId, Integer siteId, String name, Integer seq) {
		this.roleId = roleId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
	}

	/** full constructor */
	public WebimsRole(Integer roleId, Integer siteId, String name,
			String description, Integer seq) {
		this.roleId = roleId;
		this.siteId = siteId;
		this.name = name;
		this.description = description;
		this.seq = seq;
	}

	// Property accessors
	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}