package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsNodeDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_node_detail", catalog = "webims")
public class WebimsNodeDetail implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private String linkUrl;
	private String metaKeywords;
	private String metaDescription;
	private String isNewWindow;
	private String nodeTemplate;
	private String infoTemplate;
	private String isGenerateNode;
	private String isGenerateInfo;
	private String nodeExtension;
	private String infoExtension;
	private String nodePath;
	private String infoPath;
	private String isDepage;
	private Integer staticMethod;
	private Integer staticPage;
	private String smallImage;
	private String largeImage;

	// Constructors

	/** default constructor */
	public WebimsNodeDetail() {
	}

	/** minimal constructor */
	public WebimsNodeDetail(Integer nodeId) {
		this.nodeId = nodeId;
	}

	/** full constructor */
	public WebimsNodeDetail(Integer nodeId, String linkUrl,
			String metaKeywords, String metaDescription, String isNewWindow,
			String nodeTemplate, String infoTemplate, String isGenerateNode,
			String isGenerateInfo, String nodeExtension, String infoExtension,
			String nodePath, String infoPath, String isDepage,
			Integer staticMethod, Integer staticPage, String smallImage,
			String largeImage) {
		this.nodeId = nodeId;
		this.linkUrl = linkUrl;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.isNewWindow = isNewWindow;
		this.nodeTemplate = nodeTemplate;
		this.infoTemplate = infoTemplate;
		this.isGenerateNode = isGenerateNode;
		this.isGenerateInfo = isGenerateInfo;
		this.nodeExtension = nodeExtension;
		this.infoExtension = infoExtension;
		this.nodePath = nodePath;
		this.infoPath = infoPath;
		this.isDepage = isDepage;
		this.staticMethod = staticMethod;
		this.staticPage = staticPage;
		this.smallImage = smallImage;
		this.largeImage = largeImage;
	}

	// Property accessors
	@Id
	@Column(name = "node_id", unique = true, nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "link_url")
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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

	@Column(name = "is_new_window", length = 1)
	public String getIsNewWindow() {
		return this.isNewWindow;
	}

	public void setIsNewWindow(String isNewWindow) {
		this.isNewWindow = isNewWindow;
	}

	@Column(name = "node_template")
	public String getNodeTemplate() {
		return this.nodeTemplate;
	}

	public void setNodeTemplate(String nodeTemplate) {
		this.nodeTemplate = nodeTemplate;
	}

	@Column(name = "info_template")
	public String getInfoTemplate() {
		return this.infoTemplate;
	}

	public void setInfoTemplate(String infoTemplate) {
		this.infoTemplate = infoTemplate;
	}

	@Column(name = "is_generate_node", length = 1)
	public String getIsGenerateNode() {
		return this.isGenerateNode;
	}

	public void setIsGenerateNode(String isGenerateNode) {
		this.isGenerateNode = isGenerateNode;
	}

	@Column(name = "is_generate_info", length = 1)
	public String getIsGenerateInfo() {
		return this.isGenerateInfo;
	}

	public void setIsGenerateInfo(String isGenerateInfo) {
		this.isGenerateInfo = isGenerateInfo;
	}

	@Column(name = "node_extension", length = 10)
	public String getNodeExtension() {
		return this.nodeExtension;
	}

	public void setNodeExtension(String nodeExtension) {
		this.nodeExtension = nodeExtension;
	}

	@Column(name = "info_extension", length = 10)
	public String getInfoExtension() {
		return this.infoExtension;
	}

	public void setInfoExtension(String infoExtension) {
		this.infoExtension = infoExtension;
	}

	@Column(name = "node_path", length = 100)
	public String getNodePath() {
		return this.nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	@Column(name = "info_path", length = 100)
	public String getInfoPath() {
		return this.infoPath;
	}

	public void setInfoPath(String infoPath) {
		this.infoPath = infoPath;
	}

	@Column(name = "is_depage", length = 1)
	public String getIsDepage() {
		return this.isDepage;
	}

	public void setIsDepage(String isDepage) {
		this.isDepage = isDepage;
	}

	@Column(name = "static_method")
	public Integer getStaticMethod() {
		return this.staticMethod;
	}

	public void setStaticMethod(Integer staticMethod) {
		this.staticMethod = staticMethod;
	}

	@Column(name = "static_page")
	public Integer getStaticPage() {
		return this.staticPage;
	}

	public void setStaticPage(Integer staticPage) {
		this.staticPage = staticPage;
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

}