package im.shs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsTag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_tag", catalog = "webims")
public class WebimsTag implements java.io.Serializable {

	// Fields

	private Integer tagId;
	private Integer siteId;
	private String name;
	private Timestamp creationDate;
	private Integer refers;

	// Constructors

	/** default constructor */
	public WebimsTag() {
	}

	/** full constructor */
	public WebimsTag(Integer tagId, Integer siteId, String name,
			Timestamp creationDate, Integer refers) {
		this.tagId = tagId;
		this.siteId = siteId;
		this.name = name;
		this.creationDate = creationDate;
		this.refers = refers;
	}

	// Property accessors
	@Id
	@Column(name = "tag_id", unique = true, nullable = false)
	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
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

	@Column(name = "creation_date", nullable = false, length = 19)
	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "refers", nullable = false)
	public Integer getRefers() {
		return this.refers;
	}

	public void setRefers(Integer refers) {
		this.refers = refers;
	}

}