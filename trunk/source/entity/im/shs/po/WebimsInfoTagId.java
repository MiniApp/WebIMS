package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoTagId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoTagId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Integer tagId;
	private Integer tagIndex;

	// Constructors

	/** default constructor */
	public WebimsInfoTagId() {
	}

	/** full constructor */
	public WebimsInfoTagId(Integer infoId, Integer tagId, Integer tagIndex) {
		this.infoId = infoId;
		this.tagId = tagId;
		this.tagIndex = tagIndex;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "tag_id", nullable = false)
	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tag_index", nullable = false)
	public Integer getTagIndex() {
		return this.tagIndex;
	}

	public void setTagIndex(Integer tagIndex) {
		this.tagIndex = tagIndex;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoTagId))
			return false;
		WebimsInfoTagId castOther = (WebimsInfoTagId) other;

		return ((this.getInfoId() == castOther.getInfoId()) || (this
				.getInfoId() != null && castOther.getInfoId() != null && this
				.getInfoId().equals(castOther.getInfoId())))
				&& ((this.getTagId() == castOther.getTagId()) || (this
						.getTagId() != null && castOther.getTagId() != null && this
						.getTagId().equals(castOther.getTagId())))
				&& ((this.getTagIndex() == castOther.getTagIndex()) || (this
						.getTagIndex() != null
						&& castOther.getTagIndex() != null && this
						.getTagIndex().equals(castOther.getTagIndex())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInfoId() == null ? 0 : this.getInfoId().hashCode());
		result = 37 * result
				+ (getTagId() == null ? 0 : this.getTagId().hashCode());
		result = 37 * result
				+ (getTagIndex() == null ? 0 : this.getTagIndex().hashCode());
		return result;
	}

}