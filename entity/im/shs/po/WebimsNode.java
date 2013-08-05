package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsNode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_node", catalog = "webims_cms")
public class WebimsNode implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private Integer siteId;
	private Integer parentId;
	private Integer creatorId;
	private Integer nodeModelId;
	private Integer workflowId;
	private Integer infoModelId;
	private String number;
	private String name;
	private String treeNumber;
	private Integer treeLevel;
	private String treeMax;
	private Timestamp creationDate;
	private Integer views;
	private String isRealNode;
	private String isHidden;
	private Short p1;
	private Short p2;
	private Short p3;
	private Short p4;
	private Short p5;
	private Short p6;
	private Integer refers;

	// Constructors

	/** default constructor */
	public WebimsNode() {
	}

	/** minimal constructor */
	public WebimsNode(Integer nodeId, Integer siteId, Integer creatorId,
			Integer nodeModelId, String name, String treeNumber,
			Integer treeLevel, String treeMax, Timestamp creationDate,
			Integer views, String isRealNode, String isHidden, Integer refers) {
		this.nodeId = nodeId;
		this.siteId = siteId;
		this.creatorId = creatorId;
		this.nodeModelId = nodeModelId;
		this.name = name;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
		this.creationDate = creationDate;
		this.views = views;
		this.isRealNode = isRealNode;
		this.isHidden = isHidden;
		this.refers = refers;
	}

	/** full constructor */
	public WebimsNode(Integer nodeId, Integer siteId, Integer parentId,
			Integer creatorId, Integer nodeModelId, Integer workflowId,
			Integer infoModelId, String number, String name, String treeNumber,
			Integer treeLevel, String treeMax, Timestamp creationDate,
			Integer views, String isRealNode, String isHidden, Short p1,
			Short p2, Short p3, Short p4, Short p5, Short p6, Integer refers) {
		this.nodeId = nodeId;
		this.siteId = siteId;
		this.parentId = parentId;
		this.creatorId = creatorId;
		this.nodeModelId = nodeModelId;
		this.workflowId = workflowId;
		this.infoModelId = infoModelId;
		this.number = number;
		this.name = name;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
		this.creationDate = creationDate;
		this.views = views;
		this.isRealNode = isRealNode;
		this.isHidden = isHidden;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.refers = refers;
	}

	// Property accessors
	@Id
	@Column(name = "node_id", unique = true, nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "creator_id", nullable = false)
	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "node_model_id", nullable = false)
	public Integer getNodeModelId() {
		return this.nodeModelId;
	}

	public void setNodeModelId(Integer nodeModelId) {
		this.nodeModelId = nodeModelId;
	}

	@Column(name = "workflow_id")
	public Integer getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	@Column(name = "info_model_id")
	public Integer getInfoModelId() {
		return this.infoModelId;
	}

	public void setInfoModelId(Integer infoModelId) {
		this.infoModelId = infoModelId;
	}

	@Column(name = "number", length = 100)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "views", nullable = false)
	public Integer getViews() {
		return this.views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Column(name = "is_real_node", nullable = false, length = 1)
	public String getIsRealNode() {
		return this.isRealNode;
	}

	public void setIsRealNode(String isRealNode) {
		this.isRealNode = isRealNode;
	}

	@Column(name = "is_hidden", nullable = false, length = 1)
	public String getIsHidden() {
		return this.isHidden;
	}

	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}

	@Column(name = "p1")
	public Short getP1() {
		return this.p1;
	}

	public void setP1(Short p1) {
		this.p1 = p1;
	}

	@Column(name = "p2")
	public Short getP2() {
		return this.p2;
	}

	public void setP2(Short p2) {
		this.p2 = p2;
	}

	@Column(name = "p3")
	public Short getP3() {
		return this.p3;
	}

	public void setP3(Short p3) {
		this.p3 = p3;
	}

	@Column(name = "p4")
	public Short getP4() {
		return this.p4;
	}

	public void setP4(Short p4) {
		this.p4 = p4;
	}

	@Column(name = "p5")
	public Short getP5() {
		return this.p5;
	}

	public void setP5(Short p5) {
		this.p5 = p5;
	}

	@Column(name = "p6")
	public Short getP6() {
		return this.p6;
	}

	public void setP6(Short p6) {
		this.p6 = p6;
	}

	@Column(name = "refers", nullable = false)
	public Integer getRefers() {
		return this.refers;
	}

	public void setRefers(Integer refers) {
		this.refers = refers;
	}

}