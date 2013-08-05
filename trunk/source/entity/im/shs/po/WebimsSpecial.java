package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsSpecial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_special", catalog = "webims")
public class WebimsSpecial implements java.io.Serializable {

	// Fields

	private Integer specialId;
	private Integer siteId;
	private Integer speccateId;
	private Timestamp creationDate;
	private String title;
	private String metaKeywords;
	private String metaDescription;
	private String smallImage;
	private String largeImage;
	private String video;
	private Integer views;
	private String isRecommend;
	private Integer refers;
	private String isWithImage;

	// Constructors

	/** default constructor */
	public WebimsSpecial() {
	}

	/** minimal constructor */
	public WebimsSpecial(Integer specialId, Integer siteId, Integer speccateId,
			Timestamp creationDate, String title, Integer views,
			String isRecommend, Integer refers, String isWithImage) {
		this.specialId = specialId;
		this.siteId = siteId;
		this.speccateId = speccateId;
		this.creationDate = creationDate;
		this.title = title;
		this.views = views;
		this.isRecommend = isRecommend;
		this.refers = refers;
		this.isWithImage = isWithImage;
	}

	/** full constructor */
	public WebimsSpecial(Integer specialId, Integer siteId, Integer speccateId,
			Timestamp creationDate, String title, String metaKeywords,
			String metaDescription, String smallImage, String largeImage,
			String video, Integer views, String isRecommend, Integer refers,
			String isWithImage) {
		this.specialId = specialId;
		this.siteId = siteId;
		this.speccateId = speccateId;
		this.creationDate = creationDate;
		this.title = title;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.smallImage = smallImage;
		this.largeImage = largeImage;
		this.video = video;
		this.views = views;
		this.isRecommend = isRecommend;
		this.refers = refers;
		this.isWithImage = isWithImage;
	}

	// Property accessors
	@Id
	@Column(name = "special_id", unique = true, nullable = false)
	public Integer getSpecialId() {
		return this.specialId;
	}

	public void setSpecialId(Integer specialId) {
		this.specialId = specialId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "speccate_id", nullable = false)
	public Integer getSpeccateId() {
		return this.speccateId;
	}

	public void setSpeccateId(Integer speccateId) {
		this.speccateId = speccateId;
	}

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "title", nullable = false, length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "meta_keywords", length = 150)
	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	@Column(name = "meta_description")
	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	@Column(name = "small_image")
	public String getSmallImage() {
		return this.smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	@Column(name = "large_image")
	public String getLargeImage() {
		return this.largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	@Column(name = "video")
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Column(name = "views", nullable = false)
	public Integer getViews() {
		return this.views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Column(name = "is_recommend", nullable = false, length = 1)
	public String getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}

	@Column(name = "refers", nullable = false)
	public Integer getRefers() {
		return this.refers;
	}

	public void setRefers(Integer refers) {
		this.refers = refers;
	}

	@Column(name = "is_with_image", nullable = false, length = 1)
	public String getIsWithImage() {
		return this.isWithImage;
	}

	public void setIsWithImage(String isWithImage) {
		this.isWithImage = isWithImage;
	}

}