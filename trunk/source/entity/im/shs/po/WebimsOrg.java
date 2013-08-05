package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsOrg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_org", catalog = "webims")
public class WebimsOrg implements java.io.Serializable {

	// Fields

	private Integer orgId;
	private Integer parentId;
	private String name;
	private String fullName;
	private String description;
	private String number;
	private String treeNumber;
	private Integer treeLevel;
	private String treeMax;

	// Constructors

	/** default constructor */
	public WebimsOrg() {
	}

	/** minimal constructor */
	public WebimsOrg(Integer orgId, String name, String number,
			String treeNumber, Integer treeLevel, String treeMax) {
		this.orgId = orgId;
		this.name = name;
		this.number = number;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
	}

	/** full constructor */
	public WebimsOrg(Integer orgId, Integer parentId, String name,
			String fullName, String description, String number,
			String treeNumber, Integer treeLevel, String treeMax) {
		this.orgId = orgId;
		this.parentId = parentId;
		this.name = name;
		this.fullName = fullName;
		this.description = description;
		this.number = number;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
	}

	// Property accessors
	@Id
	@Column(name = "org_id", unique = true, nullable = false)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "full_name", length = 150)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "number", nullable = false, length = 100)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "tree_number", nullable = false, length = 100)
	public String getTreeNumber() {
		return this.treeNumber;
	}

	public void setTreeNumber(String treeNumber) {
		this.treeNumber = treeNumber;
	}

	@Column(name = "tree_level", nullable = false)
	public Integer getTreeLevel() {
		return this.treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	@Column(name = "tree_max", nullable = false, length = 10)
	public String getTreeMax() {
		return this.treeMax;
	}

	public void setTreeMax(String treeMax) {
		this.treeMax = treeMax;
	}

}