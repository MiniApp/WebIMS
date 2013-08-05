package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsModel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_model", catalog = "webims")
public class WebimsModel implements java.io.Serializable {

	// Fields

	private Integer modelId;
	private Integer siteId;
	private Integer type;
	private String name;
	private Integer seq;

	// Constructors

	/** default constructor */
	public WebimsModel() {
	}

	/** full constructor */
	public WebimsModel(Integer modelId, Integer siteId, Integer type,
			String name, Integer seq) {
		this.modelId = modelId;
		this.siteId = siteId;
		this.type = type;
		this.name = name;
		this.seq = seq;
	}

	// Property accessors
	@Id
	@Column(name = "model_id", unique = true, nullable = false)
	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	@Column(name = "site_id", nullable = false)
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}