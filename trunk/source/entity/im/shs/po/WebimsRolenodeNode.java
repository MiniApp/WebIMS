package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsRolenodeNode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_rolenode_node", catalog = "webims")
public class WebimsRolenodeNode implements java.io.Serializable {

	// Fields

	private WebimsRolenodeNodeId id;

	// Constructors

	/** default constructor */
	public WebimsRolenodeNode() {
	}

	/** full constructor */
	public WebimsRolenodeNode(WebimsRolenodeNodeId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "rolesiteId", column = @Column(name = "rolesite_id", nullable = false)) })
	public WebimsRolenodeNodeId getId() {
		return this.id;
	}

	public void setId(WebimsRolenodeNodeId id) {
		this.id = id;
	}

}