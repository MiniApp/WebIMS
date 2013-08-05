package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsWorkflowstepRoleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsWorkflowstepRoleId implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private Integer workflowstepId;

	// Constructors

	/** default constructor */
	public WebimsWorkflowstepRoleId() {
	}

	/** full constructor */
	public WebimsWorkflowstepRoleId(Integer roleId, Integer workflowstepId) {
		this.roleId = roleId;
		this.workflowstepId = workflowstepId;
	}

	// Property accessors

	@Column(name = "role_id", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "workflowstep_id", nullable = false)
	public Integer getWorkflowstepId() {
		return this.workflowstepId;
	}

	public void setWorkflowstepId(Integer workflowstepId) {
		this.workflowstepId = workflowstepId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsWorkflowstepRoleId))
			return false;
		WebimsWorkflowstepRoleId castOther = (WebimsWorkflowstepRoleId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this
				.getRoleId() != null && castOther.getRoleId() != null && this
				.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getWorkflowstepId() == castOther.getWorkflowstepId()) || (this
						.getWorkflowstepId() != null
						&& castOther.getWorkflowstepId() != null && this
						.getWorkflowstepId().equals(
								castOther.getWorkflowstepId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37
				* result
				+ (getWorkflowstepId() == null ? 0 : this.getWorkflowstepId()
						.hashCode());
		return result;
	}

}