package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsNodeClobId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsNodeClobId implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private String key;
	private String value;

	// Constructors

	/** default constructor */
	public WebimsNodeClobId() {
	}

	/** minimal constructor */
	public WebimsNodeClobId(Integer nodeId, String key) {
		this.nodeId = nodeId;
		this.key = key;
	}

	/** full constructor */
	public WebimsNodeClobId(Integer nodeId, String key, String value) {
		this.nodeId = nodeId;
		this.key = key;
		this.value = value;
	}

	// Property accessors

	@Column(name = "node_id", nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "key", nullable = false, length = 50)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value")
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
		if (!(other instanceof WebimsNodeClobId))
			return false;
		WebimsNodeClobId castOther = (WebimsNodeClobId) other;

		return ((this.getNodeId() == castOther.getNodeId()) || (this
				.getNodeId() != null && castOther.getNodeId() != null && this
				.getNodeId().equals(castOther.getNodeId())))
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
				+ (getNodeId() == null ? 0 : this.getNodeId().hashCode());
		result = 37 * result
				+ (getKey() == null ? 0 : this.getKey().hashCode());
		result = 37 * result
				+ (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}