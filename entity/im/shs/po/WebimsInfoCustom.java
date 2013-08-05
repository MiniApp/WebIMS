package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_custom", catalog = "webims_cms")
public class WebimsInfoCustom implements java.io.Serializable {

	// Fields

	private WebimsInfoCustomId id;

	// Constructors

	/** default constructor */
	public WebimsInfoCustom() {
	}

	/** full constructor */
	public WebimsInfoCustom(WebimsInfoCustomId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 2000)) })
	public WebimsInfoCustomId getId() {
		return this.id;
	}

	public void setId(WebimsInfoCustomId id) {
		this.id = id;
	}

}