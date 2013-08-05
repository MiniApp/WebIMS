package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsNodeCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_node_custom", catalog = "webims_cms")
public class WebimsNodeCustom implements java.io.Serializable {

	// Fields

	private WebimsNodeCustomId id;

	// Constructors

	/** default constructor */
	public WebimsNodeCustom() {
	}

	/** full constructor */
	public WebimsNodeCustom(WebimsNodeCustomId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 2000)) })
	public WebimsNodeCustomId getId() {
		return this.id;
	}

	public void setId(WebimsNodeCustomId id) {
		this.id = id;
	}

}