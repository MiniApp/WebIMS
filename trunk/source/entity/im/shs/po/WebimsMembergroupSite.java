package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsMembergroupSite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_membergroup_site", catalog = "webims")
public class WebimsMembergroupSite implements java.io.Serializable {

	// Fields

	private Integer memgroupsiteId;
	private Integer membergroupId;
	private Integer siteId;
	private String isAllView;
	private String isAllContri;
	private String isAllExemption;

	// Constructors

	/** default constructor */
	public WebimsMembergroupSite() {
	}

	/** full constructor */
	public WebimsMembergroupSite(Integer memgroupsiteId, Integer membergroupId,
			Integer siteId, String isAllView, String isAllContri,
			String isAllExemption) {
		this.memgroupsiteId = memgroupsiteId;
		this.membergroupId = membergroupId;
		this.siteId = siteId;
		this.isAllView = isAllView;
		this.isAllContri = isAllContri;
		this.isAllExemption = isAllExemption;
	}

	// Property accessors
	@Id
	@Column(name = "memgroupsite_id", unique = true, nullable = false)
	public Integer getMemgroupsiteId() {
		return this.memgroupsiteId;
	}

	public void setMemgroupsiteId(Integer memgroupsiteId) {
		this.memgroupsiteId = memgroupsiteId;
	}

	@Column(name = "membergroup_id", nullable = false)
	public Integer getMembergroupId() {
		return this.membergroupId;
	}

	public void setMembergroupId(Integer membergroupId) {
		this.membergroupId = membergroupId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "is_all_view", nullable = false, length = 1)
	public String getIsAllView() {
		return this.isAllView;
	}

	public void setIsAllView(String isAllView) {
		this.isAllView = isAllView;
	}

	@Column(name = "is_all_contri", nullable = false, length = 1)
	public String getIsAllContri() {
		return this.isAllContri;
	}

	public void setIsAllContri(String isAllContri) {
		this.isAllContri = isAllContri;
	}

	@Column(name = "is_all_exemption", nullable = false, length = 1)
	public String getIsAllExemption() {
		return this.isAllExemption;
	}

	public void setIsAllExemption(String isAllExemption) {
		this.isAllExemption = isAllExemption;
	}

}