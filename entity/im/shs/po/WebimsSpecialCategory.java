package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsSpecialCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_special_category", catalog = "webims_cms")
public class WebimsSpecialCategory implements java.io.Serializable {

	// Fields

	private Integer speccateId;
	private Integer siteId;
	private String name;
	private Integer seq;
	private Integer views;
	private String metaKeywords;
	private String metaDescription;
	private Timestamp creationDate;

	// Constructors

	/** default constructor */
	public WebimsSpecialCategory() {
	}

	/** minimal constructor */
	public WebimsSpecialCategory(Integer speccateId, Integer siteId,
			String name, Integer seq, Integer views, Timestamp creationDate) {
		this.speccateId = speccateId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
		this.views = views;
		this.creationDate = creationDate;
	}

	/** full constructor */
	public WebimsSpecialCategory(Integer speccateId, Integer siteId,
			String name, Integer seq, Integer views, String metaKeywords,
			String metaDescription, Timestamp creationDate) {
		this.speccateId = speccateId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
		this.views = views;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.creationDate = creationDate;
	}

	// Property accessors
	@Id
	@Column(name = "speccate_id", unique = true, nullable = false)
	public Integer getSpeccateId() {
		return this.speccateId;
	}

	public void setSpeccateId(Integer speccateId) {
		this.speccateId = speccateId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "views", nullable = false)
	public Integer getViews() {
		return this.views;
	}

	public void setViews(Integer views) {
		this.views = views;
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

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}