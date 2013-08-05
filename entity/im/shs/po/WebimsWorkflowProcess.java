package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsWorkflowProcess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_workflow_process", catalog = "webims_cms")
public class WebimsWorkflowProcess implements java.io.Serializable {

	// Fields

	private Integer workflowprocessId;
	private Integer workflowId;
	private Integer userId;
	private Integer dataId;
	private Timestamp startDate;
	private Timestamp endDate;
	private Integer step;
	private String isEnd;

	// Constructors

	/** default constructor */
	public WebimsWorkflowProcess() {
	}

	/** minimal constructor */
	public WebimsWorkflowProcess(Integer workflowprocessId, Integer workflowId,
			Integer userId, Integer dataId, Timestamp startDate, Integer step,
			String isEnd) {
		this.workflowprocessId = workflowprocessId;
		this.workflowId = workflowId;
		this.userId = userId;
		this.dataId = dataId;
		this.startDate = startDate;
		this.step = step;
		this.isEnd = isEnd;
	}

	/** full constructor */
	public WebimsWorkflowProcess(Integer workflowprocessId, Integer workflowId,
			Integer userId, Integer dataId, Timestamp startDate,
			Timestamp endDate, Integer step, String isEnd) {
		this.workflowprocessId = workflowprocessId;
		this.workflowId = workflowId;
		this.userId = userId;
		this.dataId = dataId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.step = step;
		this.isEnd = isEnd;
	}

	// Property accessors
	@Id
	@Column(name = "workflowprocess_id", unique = true, nullable = false)
	public Integer getWorkflowprocessId() {
		return this.workflowprocessId;
	}

	public void setWorkflowprocessId(Integer workflowprocessId) {
		this.workflowprocessId = workflowprocessId;
	}

	@Column(name = "workflow_id", nullable = false)
	public Integer getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "data_id", nullable = false)
	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	@Column(name = "start_date", nullable = false, length = 19)
	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", length = 19)
	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Column(name = "step", nullable = false)
	public Integer getStep() {
		return this.step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	@Column(name = "is_end", nullable = false, length = 1)
	public String getIsEnd() {
		return this.isEnd;
	}

	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}

}