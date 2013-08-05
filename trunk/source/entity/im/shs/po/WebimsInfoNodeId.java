package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsInfoNodeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsInfoNodeId implements java.io.Serializable {

	// Fields

	private Integer infoId;
	private Integer nodeId;
	private Integer nodeIndex;

	// Constructors

	/** default constructor */
	public WebimsInfoNodeId() {
	}

	/** full constructor */
	public WebimsInfoNodeId(Integer infoId, Integer nodeId, Integer nodeIndex) {
		this.infoId = infoId;
		this.nodeId = nodeId;
		this.nodeIndex = nodeIndex;
	}

	// Property accessors

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "node_id", nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "node_index", nullable = false)
	public Integer getNodeIndex() {
		return this.nodeIndex;
	}

	public void setNodeIndex(Integer nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsInfoNodeId))
			return false;
		WebimsInfoNodeId castOther = (WebimsInfoNodeId) other;

		return ((this.getInfoId() == castOther.getInfoId()) || (this
				.getInfoId() != null && castOther.getInfoId() != null && this
				.getInfoId().equals(castOther.getInfoId())))
				&& ((this.getNodeId() == castOther.getNodeId()) || (this
						.getNodeId() != null && castOther.getNodeId() != null && this
						.getNodeId().equals(castOther.getNodeId())))
				&& ((this.getNodeIndex() == castOther.getNodeIndex()) || (this
						.getNodeIndex() != null
						&& castOther.getNodeIndex() != null && this
						.getNodeIndex().equals(castOther.getNodeIndex())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getInfoId() == null ? 0 : this.getInfoId().hashCode());
		result = 37 * result
				+ (getNodeId() == null ? 0 : this.getNodeId().hashCode());
		result = 37 * result
				+ (getNodeIndex() == null ? 0 : this.getNodeIndex().hashCode());
		return result;
	}

}