package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsScoreitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_scoreitem", catalog = "webims")
public class WebimsScoreitem implements java.io.Serializable {

	// Fields

	private Integer scoreitemId;
	private Integer scoregroupId;
	private Integer siteId;
	private String name;
	private String icon;
	private Integer seq;

	// Constructors

	/** default constructor */
	public WebimsScoreitem() {
	}

	/** minimal constructor */
	public WebimsScoreitem(Integer scoreitemId, Integer scoregroupId,
			Integer siteId, String name, Integer seq) {
		this.scoreitemId = scoreitemId;
		this.scoregroupId = scoregroupId;
		this.siteId = siteId;
		this.name = name;
		this.seq = seq;
	}

	/** full constructor */
	public WebimsScoreitem(Integer scoreitemId, Integer scoregroupId,
			Integer siteId, String name, String icon, Integer seq) {
		this.scoreitemId = scoreitemId;
		this.scoregroupId = scoregroupId;
		this.siteId = siteId;
		this.name = name;
		this.icon = icon;
		this.seq = seq;
	}

	// Property accessors
	@Id
	@Column(name = "scoreitem_id", unique = true, nullable = false)
	public Integer getScoreitemId() {
		return this.scoreitemId;
	}

	public void setScoreitemId(Integer scoreitemId) {
		this.scoreitemId = scoreitemId;
	}

	@Column(name = "scoregroup_id", nullable = false)
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

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "icon")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}