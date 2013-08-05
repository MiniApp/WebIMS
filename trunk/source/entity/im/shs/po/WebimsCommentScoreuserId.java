package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsCommentScoreuserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsCommentScoreuserId implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public WebimsCommentScoreuserId() {
	}

	/** full constructor */
	public WebimsCommentScoreuserId(Integer commentId, Integer userId) {
		this.commentId = commentId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "comment_id", nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
		if (!(other instanceof WebimsCommentScoreuserId))
			return false;
		WebimsCommentScoreuserId castOther = (WebimsCommentScoreuserId) other;

		return ((this.getCommentId() == castOther.getCommentId()) || (this
				.getCommentId() != null && castOther.getCommentId() != null && this
				.getCommentId().equals(castOther.getCommentId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCommentId() == null ? 0 : this.getCommentId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}