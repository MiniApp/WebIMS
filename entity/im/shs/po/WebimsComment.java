package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_comment", catalog = "webims_cms")
public class WebimsComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer siteId;
	private Integer creatorId;
	private Integer auditorId;
	private String ftype;
	private Integer fid;
	private Timestamp creationDate;
	private Timestamp auditDate;
	private Integer score;
	private Integer status;
	private String text;
	private String ip;

	// Constructors

	/** default constructor */
	public WebimsComment() {
	}

	/** minimal constructor */
	public WebimsComment(Integer commentId, Integer siteId, Integer creatorId,
			String ftype, Integer fid, Timestamp creationDate, Integer score,
			Integer status, String ip) {
		this.commentId = commentId;
		this.siteId = siteId;
		this.creatorId = creatorId;
		this.ftype = ftype;
		this.fid = fid;
		this.creationDate = creationDate;
		this.score = score;
		this.status = status;
		this.ip = ip;
	}

	/** full constructor */
	public WebimsComment(Integer commentId, Integer siteId, Integer creatorId,
			Integer auditorId, String ftype, Integer fid,
			Timestamp creationDate, Timestamp auditDate, Integer score,
			Integer status, String text, String ip) {
		this.commentId = commentId;
		this.siteId = siteId;
		this.creatorId = creatorId;
		this.auditorId = auditorId;
		this.ftype = ftype;
		this.fid = fid;
		this.creationDate = creationDate;
		this.auditDate = auditDate;
		this.score = score;
		this.status = status;
		this.text = text;
		this.ip = ip;
	}

	// Property accessors
	@Id
	@Column(name = "comment_id", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "creator_id", nullable = false)
	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "auditor_id")
	public Integer getAuditorId() {
		return this.auditorId;
	}

	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}

	@Column(name = "ftype", nullable = false, length = 50)
	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	@Column(name = "fid", nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "audit_date", length = 19)
	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	@Column(name = "score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "ip", nullable = false, length = 100)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}