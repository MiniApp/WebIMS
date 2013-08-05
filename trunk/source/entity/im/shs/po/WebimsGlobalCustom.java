package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsGlobalCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_global_custom", catalog = "webims")
public class WebimsGlobalCustom implements java.io.Serializable {

	// Fields

	private WebimsGlobalCustomId id;

	// Constructors

	/** default constructor */
	public WebimsGlobalCustom() {
	}

	/** full constructor */
	public WebimsGlobalCustom(WebimsGlobalCustomId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "globalId", column = @Column(name = "global_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 2000)) })
	public WebimsGlobalCustomId getId() {
		return this.id;
	}

	public void setId(WebimsGlobalCustomId id) {
		this.id = id;
	}

}