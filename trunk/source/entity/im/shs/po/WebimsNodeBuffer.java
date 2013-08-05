package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsNodeBuffer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_node_buffer", catalog = "webims_cms")
public class WebimsNodeBuffer implements java.io.Serializable {

	// Fields

	private Integer nodeId;
	private Integer views;

	// Constructors

	/** default constructor */
	public WebimsNodeBuffer() {
	}

	/** full constructor */
	public WebimsNodeBuffer(Integer nodeId, Integer views) {
		this.nodeId = nodeId;
		this.views = views;
	}

	// Property accessors
	@Id
	@Column(name = "node_id", unique = true, nullable = false)
	public Integer getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	@Column(name = "views", nullable = false)
	public Integer getViews() {
		return this.views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

}