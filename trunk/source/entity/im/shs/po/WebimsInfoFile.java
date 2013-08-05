package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsInfoFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_file", catalog = "webims_cms")
public class WebimsInfoFile implements java.io.Serializable {

	// Fields

	private WebimsInfoFileId id;

	// Constructors

	/** default constructor */
	public WebimsInfoFile() {
	}

	/** full constructor */
	public WebimsInfoFile(WebimsInfoFileId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "infoId", column = @Column(name = "info_id", nullable = false)),
			@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 150)),
			@AttributeOverride(name = "url", column = @Column(name = "url", nullable = false)),
			@AttributeOverride(name = "index", column = @Column(name = "index", nullable = false)),
			@AttributeOverride(name = "downloads", column = @Column(name = "downloads", nullable = false)),
			@AttributeOverride(name = "length", column = @Column(name = "length", nullable = false)) })
	public WebimsInfoFileId getId() {
		return this.id;
	}

	public void setId(WebimsInfoFileId id) {
		this.id = id;
	}

}