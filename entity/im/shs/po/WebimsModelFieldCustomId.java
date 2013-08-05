package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsModelFieldCustomId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsModelFieldCustomId implements java.io.Serializable {

	// Fields

	private Integer modefielId;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public WebimsModelFieldCustomId() {
	}

	/** minimal constructor */
	public WebimsModelFieldCustomId(Integer modefielId, String key) {
		this.modefielId = modefielId;
		this.key = key;
	}

	/** full constructor */
	public WebimsModelFieldCustomId(Integer modefielId, String key, String value) {
		this.modefielId = modefielId;
		this.key = key;
		this.value = value;
	}

	// Property accessors

	@Column(name = "modefiel_id", nullable = false)
	public Integer getModefielId() {
		return this.modefielId;
	}

	public void setModefielId(Integer modefielId) {
		this.modefielId = modefielId;
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
		if (!(other instanceof WebimsModelFieldCustomId))
			return false;
		WebimsModelFieldCustomId castOther = (WebimsModelFieldCustomId) other;

		return ((this.getModefielId() == castOther.getModefielId()) || (this
				.getModefielId() != null && castOther.getModefielId() != null && this
				.getModefielId().equals(castOther.getModefielId())))
				&& ((this.getKey() == castOther.getKey()) || (this.getKey() != null
						&& castOther.getKey() != null && this.getKey().equals(
						castOther.getKey())))
				&& ((this.getValue() == castOther.getValue()) || (this
						.getValue() != null && castOther.getValue() != null && this
						.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getModefielId() == null ? 0 : this.getModefielId()
						.hashCode());
		result = 37 * result
				+ (getKey() == null ? 0 : this.getKey().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}