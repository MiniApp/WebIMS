package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoImage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_image", catalog = "webims")
public class WebimsInfoImage implements java.io.Serializable {

	// Fields

	private WebimsInfoImageId id;

	// Constructors

	/** default constructor */
	public WebimsInfoImage() {
	}

	/** full constructor */
	public WebimsInfoImage(WebimsInfoImageId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "name", column = @Column(name = "name", length = 150)),
			@AttributeOverride(name = "url", column = @Column(name = "url", nullable = false)),
			@AttributeOverride(name = "index", column = @Column(name = "index", nullable = false)),
			@AttributeOverride(name = "text", column = @Column(name = "text")) })
	public WebimsInfoImageId getId() {
		return this.id;
	}

	public void setId(WebimsInfoImageId id) {
		this.id = id;
	}

}