package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsRolenodeInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_rolenode_info", catalog = "webims_cms")
public class WebimsRolenodeInfo implements java.io.Serializable {

	// Fields

	private WebimsRolenodeInfoId id;

	// Constructors

	/** default constructor */
	public WebimsRolenodeInfo() {
	}

	/** full constructor */
	public WebimsRolenodeInfo(WebimsRolenodeInfoId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "rolesiteId", column = @Column(name = "rolesite_id", nullable = false)) })
	public WebimsRolenodeInfoId getId() {
		return this.id;
	}

	public void setId(WebimsRolenodeInfoId id) {
		this.id = id;
	}

}