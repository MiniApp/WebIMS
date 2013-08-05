package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsScoregroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_scoregroup", catalog = "webims_cms")
public class WebimsScoregroup implements java.io.Serializable {

	// Fields

	private Integer scoregroupId;
	private Integer siteId;
	private String name;
	private String description;
	private Integer seq;

	// Constructors

	/** default constructor */
	public WebimsScoregroup() {
	}

	/** minimal constructor */
	public WebimsScoregroup(Integer scoregroupId, Integer siteId, String name,
			Integer seq) {
		this.scoregroupId = scoregroupId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
	}

	/** full constructor */
	public WebimsScoregroup(Integer scoregroupId, Integer siteId, String name,
			String description, Integer seq) {
		this.scoregroupId = scoregroupId;
		this.siteId = siteId;
		this.name = name;
		this.description = description;
		this.seq = seq;
	}

	// Property accessors
	@Id
	@Column(name = "scoregroup_id", unique = true, nullable = false)
	public Integer getScoregroupId() {
		return this.scoregroupId;
	}

	public void setScoregroupId(Integer scoregroupId) {
		this.scoregroupId = scoregroupId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}