package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsModelCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_model_custom", catalog = "webims_cms")
public class WebimsModelCustom implements java.io.Serializable {

	// Fields

	private WebimsModelCustomId id;

	// Constructors

	/** default constructor */
	public WebimsModelCustom() {
	}

	/** full constructor */
	public WebimsModelCustom(WebimsModelCustomId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "modelId", column = @Column(name = "model_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 2000)) })
	public WebimsModelCustomId getId() {
		return this.id;
	}

	public void setId(WebimsModelCustomId id) {
		this.id = id;
	}

}