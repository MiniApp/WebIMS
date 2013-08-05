package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WebimsUserOrgId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WebimsUserOrgId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer orgId;

	// Constructors

	/** default constructor */
	public WebimsUserOrgId() {
	}

	/** full constructor */
	public WebimsUserOrgId(Integer userId, Integer orgId) {
		this.userId = userId;
		this.orgId = orgId;
	}

	// Property accessors

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "org_id", nullable = false)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebimsUserOrgId))
			return false;
		WebimsUserOrgId castOther = (WebimsUserOrgId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getOrgId() == castOther.getOrgId()) || (this
						.getOrgId() != null && castOther.getOrgId() != null && this
						.getOrgId().equals(castOther.getOrgId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getOrgId() == null ? 0 : this.getOrgId().hashCode());
		return result;
	}

}