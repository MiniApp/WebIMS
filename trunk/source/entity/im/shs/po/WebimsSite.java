package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsSite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_site", catalog = "webims_cms")
public class WebimsSite implements java.io.Serializable {

	// Fields

	private Integer siteId;
	private Integer globalId;
	private Integer orgId;
	private Integer parentId;
	private String name;
	private String fullName;
	private String htmlPath;
	private String domain;
	private String isWithDomain;
	private String templateTheme;
	private String treeNumber;
	private Integer treeLevel;
	private String treeMax;
	private String noPicture;

	// Constructors

	/** default constructor */
	public WebimsSite() {
	}

	/** minimal constructor */
	public WebimsSite(Integer siteId, Integer globalId, Integer orgId,
			String name, String domain, String isWithDomain,
			String templateTheme, String treeNumber, Integer treeLevel,
			String treeMax, String noPicture) {
		this.siteId = siteId;
		this.globalId = globalId;
		this.orgId = orgId;
		this.name = name;
		this.domain = domain;
		this.isWithDomain = isWithDomain;
		this.templateTheme = templateTheme;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
		this.noPicture = noPicture;
	}

	/** full constructor */
	public WebimsSite(Integer siteId, Integer globalId, Integer orgId,
			Integer parentId, String name, String fullName, String htmlPath,
			String domain, String isWithDomain, String templateTheme,
			String treeNumber, Integer treeLevel, String treeMax,
			String noPicture) {
		this.siteId = siteId;
		this.globalId = globalId;
		this.orgId = orgId;
		this.parentId = parentId;
		this.name = name;
		this.fullName = fullName;
		this.htmlPath = htmlPath;
		this.domain = domain;
		this.isWithDomain = isWithDomain;
		this.templateTheme = templateTheme;
		this.treeNumber = treeNumber;
		this.treeLevel = treeLevel;
		this.treeMax = treeMax;
		this.noPicture = noPicture;
	}

	// Property accessors
	@Id
	@Column(name = "site_id", unique = true, nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "global_id", nullable = false)
	public Integer getGlobalId() {
		return this.globalId;
	}

	public void setGlobalId(Integer globalId) {
		this.globalId = globalId;
	}

	@Column(name = "org_id", nullable = false)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "full_name", length = 100)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "html_path", length = 100)
	public String getHtmlPath() {
		return this.htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	@Column(name = "domain", nullable = false, length = 100)
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Column(name = "is_with_domain", nullable = false, length = 1)
	public String getIsWithDomain() {
		return this.isWithDomain;
	}

	public void setIsWithDomain(String isWithDomain) {
		this.isWithDomain = isWithDomain;
	}

	@Column(name = "template_theme", nullable = false, length = 100)
	public String getTemplateTheme() {
		return this.templateTheme;
	}

	public void setTemplateTheme(String templateTheme) {
		this.templateTheme = templateTheme;
	}

	@Column(name = "tree_number", nullable = false, length = 100)
	public String getTreeNumber() {
		return this.treeNumber;
	}

	public void setTreeNumber(String treeNumber) {
		this.treeNumber = treeNumber;
	}

	@Column(name = "tree_level", nullable = false)
	public Integer getTreeLevel() {
		return this.treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	@Column(name = "tree_max", nullable = false, length = 10)
	public String getTreeMax() {
		return this.treeMax;
	}

	public void setTreeMax(String treeMax) {
		this.treeMax = treeMax;
	}

	@Column(name = "no_picture", nullable = false)
	public String getNoPicture() {
		return this.noPicture;
	}

	public void setNoPicture(String noPicture) {
		this.noPicture = noPicture;
	}

}