package im.shs.po;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WebimsUserOrg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_user_org", catalog = "webims_cms")
public class WebimsUserOrg implements java.io.Serializable {

	// Fields

	private WebimsUserOrgId id;

	// Constructors

	/** default constructor */
	public WebimsUserOrg() {
	}

	/** full constructor */
	public WebimsUserOrg(WebimsUserOrgId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "orgId", column = @Column(name = "org_id", nullable = false)) })
	public WebimsUserOrgId getId() {
		return this.id;
	}

	public void setId(WebimsUserOrgId id) {
		this.id = id;
	}

}