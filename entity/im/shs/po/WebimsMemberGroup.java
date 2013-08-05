package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsMemberGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_member_group", catalog = "webims_cms")
public class WebimsMemberGroup implements java.io.Serializable {

	// Fields

	private Integer membergroupId;
	private String name;
	private String description;
	private Integer seq;

	// Constructors

	/** default constructor */
	public WebimsMemberGroup() {
	}

	/** minimal constructor */
	public WebimsMemberGroup(Integer membergroupId, String name, Integer seq) {
		this.membergroupId = membergroupId;
		this.name = name;
		this.seq = seq;
	}

	/** full constructor */
	public WebimsMemberGroup(Integer membergroupId, String name,
			String description, Integer seq) {
		this.membergroupId = membergroupId;
		this.name = name;
		this.description = description;
		this.seq = seq;
	}

	// Property accessors
	@Id
	@Column(name = "membergroup_id", unique = true, nullable = false)
	public Integer getMembergroupId() {
		return this.membergroupId;
	}

	public void setMembergroupId(Integer membergroupId) {
		this.membergroupId = membergroupId;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}