package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoClob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_clob", catalog = "webims_cms")
public class WebimsInfoClob implements java.io.Serializable {

	// Fields

	private WebimsInfoClobId id;

	// Constructors

	/** default constructor */
	public WebimsInfoClob() {
	}

	/** full constructor */
	public WebimsInfoClob(WebimsInfoClobId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "key", column = @Column(name = "key", nullable = false, length = 50)),
			@AttributeOverride(name = "value", column = @Column(name = "value")) })
	public WebimsInfoClobId getId() {
		return this.id;
	}

	public void setId(WebimsInfoClobId id) {
		this.id = id;
	}

}