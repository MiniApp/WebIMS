package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsWorkflowLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflow_log", catalog = "webims")
public class WebimsWorkflowLog implements java.io.Serializable {

	// Fields

	private Integer workflowlogId;
	private Integer userId;
	private Integer workflowprocessId;
	private String from;
	private String to;
	private Timestamp creationDate;
	private String opinion;
	private Integer type;

	// Constructors

	/** default constructor */
	public WebimsWorkflowLog() {
	}

	/** minimal constructor */
	public WebimsWorkflowLog(Integer workflowlogId, Integer userId,
			Integer workflowprocessId, String from, String to,
			Timestamp creationDate, Integer type) {
		this.workflowlogId = workflowlogId;
		this.userId = userId;
		this.workflowprocessId = workflowprocessId;
		this.from = from;
		this.to = to;
		this.creationDate = creationDate;
		this.type = type;
	}

	/** full constructor */
	public WebimsWorkflowLog(Integer workflowlogId, Integer userId,
			Integer workflowprocessId, String from, String to,
			Timestamp creationDate, String opinion, Integer type) {
		this.workflowlogId = workflowlogId;
		this.userId = userId;
		this.workflowprocessId = workflowprocessId;
		this.from = from;
		this.to = to;
		this.creationDate = creationDate;
		this.opinion = opinion;
		this.type = type;
	}

	// Property accessors
	@Id
	@Column(name = "workflowlog_id", unique = true, nullable = false)
	public Integer getWorkflowlogId() {
		return this.workflowlogId;
	}

	public void setWorkflowlogId(Integer workflowlogId) {
		this.workflowlogId = workflowlogId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "workflowprocess_id", nullable = false)
	public Integer getWorkflowprocessId() {
		return this.workflowprocessId;
	}

	public void setWorkflowprocessId(Integer workflowprocessId) {
		this.workflowprocessId = workflowprocessId;
	}

	@Column(name = "from", nullable = false, length = 100)
	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "to", nullable = false, length = 100)
	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "opinion")
	public String getOpinion() {
		return this.opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}