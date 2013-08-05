package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsModelCustomId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsModelCustomId implements java.io.Serializable {

	// Fields

	private Integer modelId;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public WebimsModelCustomId() {
	}

	/** minimal constructor */
	public WebimsModelCustomId(Integer modelId, String key) {
		this.modelId = modelId;
		this.key = key;
	}

	/** full constructor */
	public WebimsModelCustomId(Integer modelId, String key, String value) {
		this.modelId = modelId;
		this.key = key;
		this.value = value;
	}

	// Property accessors

	@Column(name = "model_id", nullable = false)
	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
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
		if (!(other instanceof WebimsModelCustomId))
			return false;
		WebimsModelCustomId castOther = (WebimsModelCustomId) other;

		return ((this.getModelId() == castOther.getModelId()) || (this
				.getModelId() != null && castOther.getModelId() != null && this
				.getModelId().equals(castOther.getModelId())))
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
				+ (getModelId() == null ? 0 : this.getModelId().hashCode());
		result = 37 * result
				+ (getKey() == null ? 0 : this.getKey().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}