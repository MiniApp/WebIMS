package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsRolenodeInfoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsRolenodeInfoId implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private Integer rolesiteId;

	// Constructors

	/** default constructor */
	public WebimsRolenodeInfoId() {
	}

	/** full constructor */
	public WebimsRolenodeInfoId(Integer nodeId, Integer rolesiteId) {
		this.nodeId = nodeId;
		this.rolesiteId = rolesiteId;
	}

	// Property accessors

	@Column(name = "node_id", nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "rolesite_id", nullable = false)
	public Integer getRolesiteId() {
		return this.rolesiteId;
	}

	public void setRolesiteId(Integer rolesiteId) {
		this.rolesiteId = rolesiteId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsRolenodeInfoId))
			return false;
		WebimsRolenodeInfoId castOther = (WebimsRolenodeInfoId) other;

		return ((this.getNodeId() == castOther.getNodeId()) || (this
				.getNodeId() != null && castOther.getNodeId() != null && this
				.getNodeId().equals(castOther.getNodeId())))
				&& ((this.getRolesiteId() == castOther.getRolesiteId()) || (this
						.getRolesiteId() != null
						&& castOther.getRolesiteId() != null && this
						.getRolesiteId().equals(castOther.getRolesiteId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNodeId() == null ? 0 : this.getNodeId().hashCode());
		result = 37
				* result
				+ (getRolesiteId() == null ? 0 : this.getRolesiteId()
						.hashCode());
		return result;
	}

}