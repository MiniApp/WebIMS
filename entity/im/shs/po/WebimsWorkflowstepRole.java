package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsWorkflowstepRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflowstep_role", catalog = "webims_cms")
public class WebimsWorkflowstepRole implements java.io.Serializable {

	// Fields

	private WebimsWorkflowstepRoleId id;

	// Constructors

	/** default constructor */
	public WebimsWorkflowstepRole() {
	}

	/** full constructor */
	public WebimsWorkflowstepRole(WebimsWorkflowstepRoleId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false)),
			@AttributeOverride(name = "workflowstepId", column = @Column(name = "workflowstep_id", nullable = false)) })
	public WebimsWorkflowstepRoleId getId() {
		return this.id;
	}

	public void setId(WebimsWorkflowstepRoleId id) {
		this.id = id;
	}

}