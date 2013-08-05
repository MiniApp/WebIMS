package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsWorkflowStep entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflow_step", catalog = "webims")
public class WebimsWorkflowStep implements java.io.Serializable {

	// Fields

	private Integer workflowstepId;
	private Integer workflowId;
	private String name;

	// Constructors

	/** default constructor */
	public WebimsWorkflowStep() {
	}

	/** full constructor */
	public WebimsWorkflowStep(Integer workflowstepId, Integer workflowId,
			String name) {
		this.workflowstepId = workflowstepId;
		this.workflowId = workflowId;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "workflowstep_id", unique = true, nullable = false)
	public Integer getWorkflowstepId() {
		return this.workflowstepId;
	}

	public void setWorkflowstepId(Integer workflowstepId) {
		this.workflowstepId = workflowstepId;
	}

	@Column(name = "workflow_id", nullable = false)
	public Integer getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}