package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsModelFieldCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_model_field_custom", catalog = "webims_cms")
public class WebimsModelFieldCustom implements java.io.Serializable {

	// Fields

	private WebimsModelFieldCustomId id;

	// Constructors

	/** default constructor */
	public WebimsModelFieldCustom() {
	}

	/** full constructor */
	public WebimsModelFieldCustom(WebimsModelFieldCustomId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "modefielId", column = @Column(name = "modefiel_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 2000)) })
	public WebimsModelFieldCustomId getId() {
		return this.id;
	}

	public void setId(WebimsModelFieldCustomId id) {
		this.id = id;
	}

}