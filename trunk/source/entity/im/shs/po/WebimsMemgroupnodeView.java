package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsMemgroupnodeView entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_memgroupnode_view", catalog = "webims_cms")
public class WebimsMemgroupnodeView implements java.io.Serializable {

	// Fields

	private WebimsMemgroupnodeViewId id;

	// Constructors

	/** default constructor */
	public WebimsMemgroupnodeView() {
	}

	/** full constructor */
	public WebimsMemgroupnodeView(WebimsMemgroupnodeViewId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "memgroupsiteId", column = @Column(name = "memgroupsite_id", nullable = false)) })
	public WebimsMemgroupnodeViewId getId() {
		return this.id;
	}

	public void setId(WebimsMemgroupnodeViewId id) {
		this.id = id;
	}

}