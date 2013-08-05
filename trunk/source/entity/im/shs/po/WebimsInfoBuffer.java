package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsInfoBuffer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_buffer", catalog = "webims")
public class WebimsInfoBuffer implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Integer views;
	private Integer downloads;
	private Integer comments;
	private Integer involveds;

	// Constructors

	/** default constructor */
	public WebimsInfoBuffer() {
	}

	/** full constructor */
	public WebimsInfoBuffer(Integer infoId, Integer views, Integer downloads,
			Integer comments, Integer involveds) {
		this.infoId = infoId;
		this.views = views;
		this.downloads = downloads;
		this.comments = comments;
		this.involveds = involveds;
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

	@Column(name = "involveds", nullable = false)
	public Integer getInvolveds() {
		return this.involveds;
	}

	public void setInvolveds(Integer involveds) {
		this.involveds = involveds;
	}

}