package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoSpecial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_special", catalog = "webims")
public class WebimsInfoSpecial implements java.io.Serializable {

	// Fields

	private WebimsInfoSpecialId id;

	// Constructors

	/** default constructor */
	public WebimsInfoSpecial() {
	}

	/** full constructor */
	public WebimsInfoSpecial(WebimsInfoSpecialId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "specialId", column = @Column(name = "special_id", nullable = false)),
			@AttributeOverride(name = "specialIndex", column = @Column(name = "special_index", nullable = false)) })
	public WebimsInfoSpecialId getId() {
		return this.id;
	}

	public void setId(WebimsInfoSpecialId id) {
		this.id = id;
	}

}