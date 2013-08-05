package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoTag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_tag", catalog = "webims")
public class WebimsInfoTag implements java.io.Serializable {

	// Fields

	private WebimsInfoTagId id;

	// Constructors

	/** default constructor */
	public WebimsInfoTag() {
	}

	/** full constructor */
	public WebimsInfoTag(WebimsInfoTagId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "tagId", column = @Column(name = "tag_id", nullable = false)),
			@AttributeOverride(name = "tagIndex", column = @Column(name = "tag_index", nullable = false)) })
	public WebimsInfoTagId getId() {
		return this.id;
	}

	public void setId(WebimsInfoTagId id) {
		this.id = id;
	}

}