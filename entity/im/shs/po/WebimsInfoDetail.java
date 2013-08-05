package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsInfoDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_detail", catalog = "webims_cms")
public class WebimsInfoDetail implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private String title;
	private String subtitle;
	private String fullTitle;
	private String linkUrl;
	private String color;
	private String isStrong;
	private String isEm;
	private String metaDescription;
	private String source;
	private String sourceUrl;
	private String author;
	private String smallImage;
	private String largeImage;
	private String video;
	private String file;
	private String fileName;
	private String infoTemplate;
	private String infoPath;
	private String videoName;
	private String isNewWindow;
	private Long fileLength;

	// Constructors

	/** default constructor */
	public WebimsInfoDetail() {
	}

	/** minimal constructor */
	public WebimsInfoDetail(Integer infoId, String title, String isStrong,
			String isEm) {
		this.infoId = infoId;
		this.title = title;
		this.isStrong = isStrong;
		this.isEm = isEm;
	}

	/** full constructor */
	public WebimsInfoDetail(Integer infoId, String title, String subtitle,
			String fullTitle, String linkUrl, String color, String isStrong,
			String isEm, String metaDescription, String source,
			String sourceUrl, String author, String smallImage,
			String largeImage, String video, String file, String fileName,
			String infoTemplate, String infoPath, String videoName,
			String isNewWindow, Long fileLength) {
		this.infoId = infoId;
		this.title = title;
		this.subtitle = subtitle;
		this.fullTitle = fullTitle;
		this.linkUrl = linkUrl;
		this.color = color;
		this.isStrong = isStrong;
		this.isEm = isEm;
		this.metaDescription = metaDescription;
		this.source = source;
		this.sourceUrl = sourceUrl;
		this.author = author;
		this.smallImage = smallImage;
		this.largeImage = largeImage;
		this.video = video;
		this.file = file;
		this.fileName = fileName;
		this.infoTemplate = infoTemplate;
		this.infoPath = infoPath;
		this.videoName = videoName;
		this.isNewWindow = isNewWindow;
		this.fileLength = fileLength;
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

	@Column(name = "title", nullable = false, length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "subtitle", length = 150)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name = "full_title", length = 150)
	public String getFullTitle() {
		return this.fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	@Column(name = "link_url")
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(name = "color", length = 50)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "is_strong", nullable = false, length = 1)
	public String getIsStrong() {
		return this.isStrong;
	}

	public void setIsStrong(String isStrong) {
		this.isStrong = isStrong;
	}

	@Column(name = "is_em", nullable = false, length = 1)
	public String getIsEm() {
		return this.isEm;
	}

	public void setIsEm(String isEm) {
		this.isEm = isEm;
	}

	@Column(name = "meta_description")
	public String getMetaDescription() {
		return this.metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	@Column(name = "source", length = 50)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "source_url")
	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	@Column(name = "author", length = 50)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	@Column(name = "file")
	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Column(name = "file_name")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "info_template")
	public String getInfoTemplate() {
		return this.infoTemplate;
	}

	public void setInfoTemplate(String infoTemplate) {
		this.infoTemplate = infoTemplate;
	}

	@Column(name = "info_path")
	public String getInfoPath() {
		return this.infoPath;
	}

	public void setInfoPath(String infoPath) {
		this.infoPath = infoPath;
	}

	@Column(name = "video_name")
	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	@Column(name = "is_new_window", length = 1)
	public String getIsNewWindow() {
		return this.isNewWindow;
	}

	public void setIsNewWindow(String isNewWindow) {
		this.isNewWindow = isNewWindow;
	}

	@Column(name = "file_length")
	public Long getFileLength() {
		return this.fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

}