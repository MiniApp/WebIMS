package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsWorkflowGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflow_group", catalog = "webims_cms")
public class WebimsWorkflowGroup implements java.io.Serializable {

	// Fields

	private Integer workflowgroupId;
	private String name;
	private String description;
	private Integer seq;
	private Integer siteId;

	// Constructors

	/** default constructor */
	public WebimsWorkflowGroup() {
	}

	/** minimal constructor */
	public WebimsWorkflowGroup(Integer workflowgroupId, String name,
			Integer seq, Integer siteId) {
		this.workflowgroupId = workflowgroupId;
		this.name = name;
		this.seq = seq;
		this.siteId = siteId;
	}

	/** full constructor */
	public WebimsWorkflowGroup(Integer workflowgroupId, String name,
			String description, Integer seq, Integer siteId) {
		this.workflowgroupId = workflowgroupId;
		this.name = name;
		this.description = description;
		this.seq = seq;
		this.siteId = siteId;
	}

	// Property accessors
	@Id
	@Column(name = "workflowgroup_id", unique = true, nullable = false)
	public Integer getWorkflowgroupId() {
		return this.workflowgroupId;
	}

	public void setWorkflowgroupId(Integer workflowgroupId) {
		this.workflowgroupId = workflowgroupId;
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

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

}