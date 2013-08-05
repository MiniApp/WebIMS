package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoImageId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoImageId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private String name;
	private String url;
	private Integer index;
	private String text;

	// Constructors

	/** default constructor */
	public WebimsInfoImageId() {
	}

	/** minimal constructor */
	public WebimsInfoImageId(Integer infoId, String url, Integer index) {
		this.infoId = infoId;
		this.url = url;
		this.index = index;
	}

	/** full constructor */
	public WebimsInfoImageId(Integer infoId, String name, String url,
			Integer index, String text) {
		this.infoId = infoId;
		this.name = name;
		this.url = url;
		this.index = index;
		this.text = text;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "name", length = 150)
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

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoImageId))
			return false;
		WebimsInfoImageId castOther = (WebimsInfoImageId) other;

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
				&& ((this.getText() == castOther.getText()) || (this.getText() != null
						&& castOther.getText() != null && this.getText()
						.equals(castOther.getText())));
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
				+ (getText() == null ? 0 : this.getText().hashCode());
		return result;
	}

}