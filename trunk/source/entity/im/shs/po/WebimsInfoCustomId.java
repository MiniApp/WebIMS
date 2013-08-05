package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoCustomId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoCustomId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public WebimsInfoCustomId() {
	}

	/** minimal constructor */
	public WebimsInfoCustomId(Integer infoId, String key) {
		this.infoId = infoId;
		this.key = key;
	}

	/** full constructor */
	public WebimsInfoCustomId(Integer infoId, String key, String value) {
		this.infoId = infoId;
		this.key = key;
		this.value = value;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "key", nullable = false, length = 50)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value", length = 2000)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoCustomId))
			return false;
		WebimsInfoCustomId castOther = (WebimsInfoCustomId) other;

		return ((this.getInfoId() == castOther.getInfoId()) || (this
				.getInfoId() != null && castOther.getInfoId() != null && this
				.getInfoId().equals(castOther.getInfoId())))
				&& ((this.getKey() == castOther.getKey()) || (this.getKey() != null
						&& castOther.getKey() != null && this.getKey().equals(
						castOther.getKey())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInfoId() == null ? 0 : this.getInfoId().hashCode());
		result = 37 * result
				+ (getKey() == null ? 0 : this.getKey().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}