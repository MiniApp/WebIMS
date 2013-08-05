package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info", catalog = "webims")
public class WebimsInfo implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Integer creatorId;
	private Integer siteId;
	private Integer nodeId;
	private Timestamp publishDate;
	private Short priority;
	private String isWithImage;
	private Integer views;
	private Integer downloads;
	private Integer comments;
	private String status;
	private Short p1;
	private Short p2;
	private Short p3;
	private Short p4;
	private Short p5;
	private Short p6;

	// Constructors

	/** default constructor */
	public WebimsInfo() {
	}

	/** minimal constructor */
	public WebimsInfo(Integer infoId, Integer creatorId, Integer siteId,
			Integer nodeId, Timestamp publishDate, Short priority,
			String isWithImage, Integer views, Integer downloads,
			Integer comments, String status) {
		this.infoId = infoId;
		this.creatorId = creatorId;
		this.siteId = siteId;
		this.nodeId = nodeId;
		this.publishDate = publishDate;
		this.priority = priority;
		this.isWithImage = isWithImage;
		this.views = views;
		this.downloads = downloads;
		this.comments = comments;
		this.status = status;
	}

	/** full constructor */
	public WebimsInfo(Integer infoId, Integer creatorId, Integer siteId,
			Integer nodeId, Timestamp publishDate, Short priority,
			String isWithImage, Integer views, Integer downloads,
			Integer comments, String status, Short p1, Short p2, Short p3,
			Short p4, Short p5, Short p6) {
		this.infoId = infoId;
		this.creatorId = creatorId;
		this.siteId = siteId;
		this.nodeId = nodeId;
		this.publishDate = publishDate;
		this.priority = priority;
		this.isWithImage = isWithImage;
		this.views = views;
		this.downloads = downloads;
		this.comments = comments;
		this.status = status;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
	}

	// Property accessors
	@Id
	@Column(name = "info_id", unique = true, nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "creator_id", nullable = false)
	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "node_id", nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "publish_date", nullable = false, length = 19)
	public Timestamp getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "priority", nullable = false)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Column(name = "is_with_image", nullable = false, length = 1)
	public String getIsWithImage() {
		return this.isWithImage;
	}

	public void setIsWithImage(String isWithImage) {
		this.isWithImage = isWithImage;
	}

	@Column(name = "views", nullable = false)
	public Integer getViews() {
		return this.views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Column(name = "downloads", nullable = false)
	public Integer getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	@Column(name = "comments", nullable = false)
	public Integer getComments() {
		return this.comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	@Column(name = "status", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "p1")
	public Short getP1() {
		return this.p1;
	}

	public void setP1(Short p1) {
		this.p1 = p1;
	}

	@Column(name = "p2")
	public Short getP2() {
		return this.p2;
	}

	public void setP2(Short p2) {
		this.p2 = p2;
	}

	@Column(name = "p3")
	public Short getP3() {
		return this.p3;
	}

	public void setP3(Short p3) {
		this.p3 = p3;
	}

	@Column(name = "p4")
	public Short getP4() {
		return this.p4;
	}

	public void setP4(Short p4) {
		this.p4 = p4;
	}

	@Column(name = "p5")
	public Short getP5() {
		return this.p5;
	}

	public void setP5(Short p5) {
		this.p5 = p5;
	}

	@Column(name = "p6")
	public Short getP6() {
		return this.p6;
	}

	public void setP6(Short p6) {
		this.p6 = p6;
	}

}