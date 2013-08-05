package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsWorkflowprocUserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsWorkflowprocUserId implements java.io.Serializable {

	// Fields

	private Integer workflowprocessId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public WebimsWorkflowprocUserId() {
	}

	/** full constructor */
	public WebimsWorkflowprocUserId(Integer workflowprocessId, Integer userId) {
		this.workflowprocessId = workflowprocessId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "workflowprocess_id", nullable = false)
	public Integer getWorkflowprocessId() {
		return this.workflowprocessId;
	}

	public void setWorkflowprocessId(Integer workflowprocessId) {
		this.workflowprocessId = workflowprocessId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsWorkflowprocUserId))
			return false;
		WebimsWorkflowprocUserId castOther = (WebimsWorkflowprocUserId) other;

		return ((this.getWorkflowprocessId() == castOther
				.getWorkflowprocessId()) || (this.getWorkflowprocessId() != null
				&& castOther.getWorkflowprocessId() != null && this
				.getWorkflowprocessId()
				.equals(castOther.getWorkflowprocessId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getWorkflowprocessId() == null ? 0 : this
						.getWorkflowprocessId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}