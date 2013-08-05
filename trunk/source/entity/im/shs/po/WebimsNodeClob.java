package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsNodeClob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_node_clob", catalog = "webims")
public class WebimsNodeClob implements java.io.Serializable {

	// Fields

	private WebimsNodeClobId id;

	// Constructors

	/** default constructor */
	public WebimsNodeClob() {
	}

	/** full constructor */
	public WebimsNodeClob(WebimsNodeClobId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "nodeId", column = @Column(name = "node_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value")) })
	public WebimsNodeClobId getId() {
		return this.id;
	}

	public void setId(WebimsNodeClobId id) {
		this.id = id;
	}

}