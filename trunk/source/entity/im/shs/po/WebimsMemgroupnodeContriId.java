package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsMemgroupnodeContriId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsMemgroupnodeContriId implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private Integer memgroupsiteId;

	// Constructors

	/** default constructor */
	public WebimsMemgroupnodeContriId() {
	}

	/** full constructor */
	public WebimsMemgroupnodeContriId(Integer nodeId, Integer memgroupsiteId) {
		this.nodeId = nodeId;
		this.memgroupsiteId = memgroupsiteId;
	}

	// Property accessors

	@Column(name = "node_id", nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "memgroupsite_id", nullable = false)
	public Integer getMemgroupsiteId() {
		return this.memgroupsiteId;
	}

	public void setMemgroupsiteId(Integer memgroupsiteId) {
		this.memgroupsiteId = memgroupsiteId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsMemgroupnodeContriId))
			return false;
		WebimsMemgroupnodeContriId castOther = (WebimsMemgroupnodeContriId) other;

		return ((this.getNodeId() == castOther.getNodeId()) || (this
				.getNodeId() != null && castOther.getNodeId() != null && this
				.getNodeId().equals(castOther.getNodeId())))
				&& ((this.getMemgroupsiteId() == castOther.getMemgroupsiteId()) || (this
						.getMemgroupsiteId() != null
						&& castOther.getMemgroupsiteId() != null && this
						.getMemgroupsiteId().equals(
								castOther.getMemgroupsiteId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNodeId() == null ? 0 : this.getNodeId().hashCode());
		result = 37
				* result
				+ (getMemgroupsiteId() == null ? 0 : this.getMemgroupsiteId()
						.hashCode());
		return result;
	}

}