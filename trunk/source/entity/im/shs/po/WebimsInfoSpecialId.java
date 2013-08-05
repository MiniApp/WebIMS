package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoSpecialId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoSpecialId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Integer specialId;
	private Integer specialIndex;

	// Constructors

	/** default constructor */
	public WebimsInfoSpecialId() {
	}

	/** full constructor */
	public WebimsInfoSpecialId(Integer infoId, Integer specialId,
			Integer specialIndex) {
		this.infoId = infoId;
		this.specialId = specialId;
		this.specialIndex = specialIndex;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "special_id", nullable = false)
	public Integer getSpecialId() {
		return this.specialId;
	}

	public void setSpecialId(Integer specialId) {
		this.specialId = specialId;
	}

	@Column(name = "special_index", nullable = false)
	public Integer getSpecialIndex() {
		return this.specialIndex;
	}

	public void setSpecialIndex(Integer specialIndex) {
		this.specialIndex = specialIndex;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoSpecialId))
			return false;
		WebimsInfoSpecialId castOther = (WebimsInfoSpecialId) other;

		return ((this.getInfoId() == castOther.getInfoId()) || (this
				.getInfoId() != null && castOther.getInfoId() != null && this
				.getInfoId().equals(castOther.getInfoId())))
				&& ((this.getSpecialId() == castOther.getSpecialId()) || (this
						.getSpecialId() != null
						&& castOther.getSpecialId() != null && this
						.getSpecialId().equals(castOther.getSpecialId())))
				&& ((this.getSpecialIndex() == castOther.getSpecialIndex()) || (this
						.getSpecialIndex() != null
						&& castOther.getSpecialIndex() != null && this
						.getSpecialIndex().equals(castOther.getSpecialIndex())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInfoId() == null ? 0 : this.getInfoId().hashCode());
		result = 37 * result
				+ (getSpecialId() == null ? 0 : this.getSpecialId().hashCode());
		result = 37
				* result
				+ (getSpecialIndex() == null ? 0 : this.getSpecialIndex()
						.hashCode());
		return result;
	}

}