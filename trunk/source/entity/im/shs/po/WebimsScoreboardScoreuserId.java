package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsScoreboardScoreuserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsScoreboardScoreuserId implements java.io.Serializable {

	// Fields

	private Integer scoreboardId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public WebimsScoreboardScoreuserId() {
	}

	/** full constructor */
	public WebimsScoreboardScoreuserId(Integer scoreboardId, Integer userId) {
		this.scoreboardId = scoreboardId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "scoreboard_id", nullable = false)
	public Integer getScoreboardId() {
		return this.scoreboardId;
	}

	public void setScoreboardId(Integer scoreboardId) {
		this.scoreboardId = scoreboardId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsScoreboardScoreuserId))
			return false;
		WebimsScoreboardScoreuserId castOther = (WebimsScoreboardScoreuserId) other;

		return ((this.getScoreboardId() == castOther.getScoreboardId()) || (this
				.getScoreboardId() != null
				&& castOther.getScoreboardId() != null && this
				.getScoreboardId().equals(castOther.getScoreboardId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getScoreboardId() == null ? 0 : this.getScoreboardId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}