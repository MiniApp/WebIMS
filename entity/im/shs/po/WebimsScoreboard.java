package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsScoreboard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_scoreboard", catalog = "webims_cms")
public class WebimsScoreboard implements java.io.Serializable {

	// Fields

	private Integer scoreboardId;
	private Integer scoreitemId;
	private String ftype;
	private Integer fid;
	private Integer score;

	// Constructors

	/** default constructor */
	public WebimsScoreboard() {
	}

	/** full constructor */
	public WebimsScoreboard(Integer scoreboardId, Integer scoreitemId,
			String ftype, Integer fid, Integer score) {
		this.scoreboardId = scoreboardId;
		this.scoreitemId = scoreitemId;
		this.ftype = ftype;
		this.fid = fid;
		this.score = score;
	}

	// Property accessors
	@Id
	@Column(name = "scoreboard_id", unique = true, nullable = false)
	public Integer getScoreboardId() {
		return this.scoreboardId;
	}

	public void setScoreboardId(Integer scoreboardId) {
		this.scoreboardId = scoreboardId;
	}

	@Column(name = "scoreitem_id", nullable = false)
	public Integer getScoreitemId() {
		return this.scoreitemId;
	}

	public void setScoreitemId(Integer scoreitemId) {
		this.scoreitemId = scoreitemId;
	}

	@Column(name = "ftype", nullable = false, length = 50)
	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	@Column(name = "fid", nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@Column(name = "score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}