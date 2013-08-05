package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsRoleSite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_role_site", catalog = "webims")
public class WebimsRoleSite implements java.io.Serializable {

	// Fields

	private Integer rolesiteId;
	private Integer siteId;
	private Integer roleId;
	private String isAllNode;
	private String isAllInfo;
	private Integer infoRightType;
	private String isAllPerm;
	private String perms;

	// Constructors

	/** default constructor */
	public WebimsRoleSite() {
	}

	/** minimal constructor */
	public WebimsRoleSite(Integer rolesiteId, Integer siteId, Integer roleId,
			String isAllNode, String isAllInfo, Integer infoRightType,
			String isAllPerm) {
		this.rolesiteId = rolesiteId;
		this.siteId = siteId;
		this.roleId = roleId;
		this.isAllNode = isAllNode;
		this.isAllInfo = isAllInfo;
		this.infoRightType = infoRightType;
		this.isAllPerm = isAllPerm;
	}

	/** full constructor */
	public WebimsRoleSite(Integer rolesiteId, Integer siteId, Integer roleId,
			String isAllNode, String isAllInfo, Integer infoRightType,
			String isAllPerm, String perms) {
		this.rolesiteId = rolesiteId;
		this.siteId = siteId;
		this.roleId = roleId;
		this.isAllNode = isAllNode;
		this.isAllInfo = isAllInfo;
		this.infoRightType = infoRightType;
		this.isAllPerm = isAllPerm;
		this.perms = perms;
	}

	// Property accessors
	@Id
	@Column(name = "rolesite_id", unique = true, nullable = false)
	public Integer getRolesiteId() {
		return this.rolesiteId;
	}

	public void setRolesiteId(Integer rolesiteId) {
		this.rolesiteId = rolesiteId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "role_id", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "is_all_node", nullable = false, length = 1)
	public String getIsAllNode() {
		return this.isAllNode;
	}

	public void setIsAllNode(String isAllNode) {
		this.isAllNode = isAllNode;
	}

	@Column(name = "is_all_info", nullable = false, length = 1)
	public String getIsAllInfo() {
		return this.isAllInfo;
	}

	public void setIsAllInfo(String isAllInfo) {
		this.isAllInfo = isAllInfo;
	}

	@Column(name = "info_right_type", nullable = false)
	public Integer getInfoRightType() {
		return this.infoRightType;
	}

	public void setInfoRightType(Integer infoRightType) {
		this.infoRightType = infoRightType;
	}

	@Column(name = "is_all_perm", nullable = false, length = 1)
	public String getIsAllPerm() {
		return this.isAllPerm;
	}

	public void setIsAllPerm(String isAllPerm) {
		this.isAllPerm = isAllPerm;
	}

	@Column(name = "perms")
	public String getPerms() {
		return this.perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

}