package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsInfoAttribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_info_attribute", catalog = "webims_cms")
public class WebimsInfoAttribute implements java.io.Serializable {

	// Fields

	private Integer infoattrId;
	private Integer infoId;
	private Integer attributeId;
	private String image;

	// Constructors

	/** default constructor */
	public WebimsInfoAttribute() {
	}

	/** minimal constructor */
	public WebimsInfoAttribute(Integer infoattrId, Integer infoId,
			Integer attributeId) {
		this.infoattrId = infoattrId;
		this.infoId = infoId;
		this.attributeId = attributeId;
	}

	/** full constructor */
	public WebimsInfoAttribute(Integer infoattrId, Integer infoId,
			Integer attributeId, String image) {
		this.infoattrId = infoattrId;
		this.infoId = infoId;
		this.attributeId = attributeId;
		this.image = image;
	}

	// Property accessors
	@Id
	@Column(name = "infoattr_id", unique = true, nullable = false)
	public Integer getInfoattrId() {
		return this.infoattrId;
	}

	public void setInfoattrId(Integer infoattrId) {
		this.infoattrId = infoattrId;
	}

	@Column(name = "info_id", nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "attribute_id", nullable = false)
	public Integer getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}