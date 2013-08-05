package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoNode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_node", catalog = "webims")
public class WebimsInfoNode implements java.io.Serializable {

	// Fields

	private WebimsInfoNodeId id;

	// Constructors

	/** default constructor */
	public WebimsInfoNode() {
	}

	/** full constructor */
	public WebimsInfoNode(WebimsInfoNodeId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "nodeIndex", column = @Column(name = "node_index", nullable = false)) })
	public WebimsInfoNodeId getId() {
		return this.id;
	}

	public void setId(WebimsInfoNodeId id) {
		this.id = id;
	}

}