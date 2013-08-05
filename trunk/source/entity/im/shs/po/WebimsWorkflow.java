package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsWorkflow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflow", catalog = "webims")
public class WebimsWorkflow implements java.io.Serializable {

	// Fields

	private Integer workflowId;
	private Integer workflowgroupId;
	private Integer siteId;
	private String name;
	private String description;
	private Integer seq;
	private Integer status;

	// Constructors

	/** default constructor */
	public WebimsWorkflow() {
	}

	/** minimal constructor */
	public WebimsWorkflow(Integer workflowId, Integer workflowgroupId,
			Integer siteId, String name, Integer seq, Integer status) {
		this.workflowId = workflowId;
		this.workflowgroupId = workflowgroupId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
		this.status = status;
	}

	/** full constructor */
	public WebimsWorkflow(Integer workflowId, Integer workflowgroupId,
			Integer siteId, String name, String description, Integer seq,
			Integer status) {
		this.workflowId = workflowId;
		this.workflowgroupId = workflowgroupId;
		this.siteId = siteId;
		this.name = name;
		this.description = description;
		this.seq = seq;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "workflow_id", unique = true, nullable = false)
	public Integer getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	@Column(name = "workflowgroup_id", nullable = false)
	public Integer getWorkflowgroupId() {
		return this.workflowgroupId;
	}

	public void setWorkflowgroupId(Integer workflowgroupId) {
		this.workflowgroupId = workflowgroupId;
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

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}