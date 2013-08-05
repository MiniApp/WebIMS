package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsScoreboardScoreuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_scoreboard_scoreuser", catalog = "webims_cms")
public class WebimsScoreboardScoreuser implements java.io.Serializable {

	// Fields

	private WebimsScoreboardScoreuserId id;

	// Constructors

	/** default constructor */
	public WebimsScoreboardScoreuser() {
	}

	/** full constructor */
	public WebimsScoreboardScoreuser(WebimsScoreboardScoreuserId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "scoreboardId", column = @Column(name = "scoreboard_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public WebimsScoreboardScoreuserId getId() {
		return this.id;
	}

	public void setId(WebimsScoreboardScoreuserId id) {
		this.id = id;
	}

}