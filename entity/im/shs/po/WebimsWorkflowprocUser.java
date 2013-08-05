package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsWorkflowprocUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflowproc_user", catalog = "webims_cms")
public class WebimsWorkflowprocUser implements java.io.Serializable {

	// Fields

	private WebimsWorkflowprocUserId id;

	// Constructors

	/** default constructor */
	public WebimsWorkflowprocUser() {
	}

	/** full constructor */
	public WebimsWorkflowprocUser(WebimsWorkflowprocUserId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "workflowprocessId", column = @Column(name = "workflowprocess_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public WebimsWorkflowprocUserId getId() {
		return this.id;
	}

	public void setId(WebimsWorkflowprocUserId id) {
		this.id = id;
	}

}