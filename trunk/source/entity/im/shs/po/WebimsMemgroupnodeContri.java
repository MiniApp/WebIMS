package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsMemgroupnodeContri entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_memgroupnode_contri", catalog = "webims_cms")
public class WebimsMemgroupnodeContri implements java.io.Serializable {

	// Fields

	private WebimsMemgroupnodeContriId id;

	// Constructors

	/** default constructor */
	public WebimsMemgroupnodeContri() {
	}

	/** full constructor */
	public WebimsMemgroupnodeContri(WebimsMemgroupnodeContriId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "memgroupsiteId", column = @Column(name = "memgroupsite_id", nullable = false)) })
	public WebimsMemgroupnodeContriId getId() {
		return this.id;
	}

	public void setId(WebimsMemgroupnodeContriId id) {
		this.id = id;
	}

}