package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoFileId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoFileId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private String name;
	private String url;
	private Integer index;
	private Integer downloads;
	private Long length;

	// Constructors

	/** default constructor */
	public WebimsInfoFileId() {
	}

	/** full constructor */
	public WebimsInfoFileId(Integer infoId, String name, String url,
			Integer index, Integer downloads, Long length) {
		this.infoId = infoId;
		this.name = name;
		this.url = url;
		this.index = index;
		this.downloads = downloads;
		this.length = length;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "index", nullable = false)
	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Column(name = "downloads", nullable = false)
	public Integer getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	@Column(name = "length", nullable = false)
	public Long getLength() {
		return this.length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoFileId))
			return false;
		WebimsInfoFileId castOther = (WebimsInfoFileId) other;

		return ((this.getInfoId() == castOther.getInfoId()) || (this
				.getInfoId() != null && castOther.getInfoId() != null && this
				.getInfoId().equals(castOther.getInfoId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())))
				&& ((this.getIndex() == castOther.getIndex()) || (this
						.getIndex() != null && castOther.getIndex() != null && this
						.getIndex().equals(castOther.getIndex())))
				&& ((this.getDownloads() == castOther.getDownloads()) || (this
						.getDownloads() != null
						&& castOther.getDownloads() != null && this
						.getDownloads().equals(castOther.getDownloads())))
				&& ((this.getLength() == castOther.getLength()) || (this
						.getLength() != null && castOther.getLength() != null && this
						.getLength().equals(castOther.getLength())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInfoId() == null ? 0 : this.getInfoId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getIndex() == null ? 0 : this.getIndex().hashCode());
		result = 37 * result
				+ (getDownloads() == null ? 0 : this.getDownloads().hashCode());
		result = 37 * result
				+ (getLength() == null ? 0 : this.getLength().hashCode());
		return result;
	}

}