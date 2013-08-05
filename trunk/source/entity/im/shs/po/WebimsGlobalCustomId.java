package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsGlobalCustomId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsGlobalCustomId implements java.io.Serializable {

	// Fields

	private Integer globalId;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public WebimsGlobalCustomId() {
	}

	/** minimal constructor */
	public WebimsGlobalCustomId(Integer globalId, String key) {
		this.globalId = globalId;
		this.key = key;
	}

	/** full constructor */
	public WebimsGlobalCustomId(Integer globalId, String key, String value) {
		this.globalId = globalId;
		this.key = key;
		this.value = value;
	}

	// Property accessors

	@Column(name = "global_id", nullable = false)
	public Integer getGlobalId() {
		return this.globalId;
	}

	public void setGlobalId(Integer globalId) {
		this.globalId = globalId;
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
		if (!(other instanceof WebimsGlobalCustomId))
			return false;
		WebimsGlobalCustomId castOther = (WebimsGlobalCustomId) other;

		return ((this.getGlobalId() == castOther.getGlobalId()) || (this
				.getGlobalId() != null && castOther.getGlobalId() != null && this
				.getGlobalId().equals(castOther.getGlobalId())))
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
				+ (getGlobalId() == null ? 0 : this.getGlobalId().hashCode());
		result = 37 * result
				+ (getKey() == null ? 0 : this.getKey().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}