package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsCommentScoreuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_comment_scoreuser", catalog = "webims")
public class WebimsCommentScoreuser implements java.io.Serializable {

	// Fields

	private WebimsCommentScoreuserId id;

	// Constructors

	/** default constructor */
	public WebimsCommentScoreuser() {
	}

	/** full constructor */
	public WebimsCommentScoreuser(WebimsCommentScoreuserId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "commentId", column = @Column(name = "comment_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public WebimsCommentScoreuserId getId() {
		return this.id;
	}

	public void setId(WebimsCommentScoreuserId id) {
		this.id = id;
	}

}