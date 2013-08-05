package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WebimsModelField entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_model_field", catalog = "webims_cms")
public class WebimsModelField implements java.io.Serializable {

	// Fields

	private Integer modefielId;
	private Integer modelId;
	private Integer type;
	private Integer innerType;
	private String label;
	private String name;
	private String prompt;
	private String devalue;
	private String isRequired;
	private Integer seq;
	private String isDblColumn;

	// Constructors

	/** default constructor */
	public WebimsModelField() {
	}

	/** minimal constructor */
	public WebimsModelField(Integer modefielId, Integer modelId, Integer type,
			Integer innerType, String label, String name, String isRequired,
			Integer seq, String isDblColumn) {
		this.modefielId = modefielId;
		this.modelId = modelId;
		this.type = type;
		this.innerType = innerType;
		this.label = label;
		this.name = name;
		this.isRequired = isRequired;
		this.seq = seq;
		this.isDblColumn = isDblColumn;
	}

	/** full constructor */
	public WebimsModelField(Integer modefielId, Integer modelId, Integer type,
			Integer innerType, String label, String name, String prompt,
			String devalue, String isRequired, Integer seq, String isDblColumn) {
		this.modefielId = modefielId;
		this.modelId = modelId;
		this.type = type;
		this.innerType = innerType;
		this.label = label;
		this.name = name;
		this.prompt = prompt;
		this.devalue = devalue;
		this.isRequired = isRequired;
		this.seq = seq;
		this.isDblColumn = isDblColumn;
	}

	// Property accessors
	@Id
	@Column(name = "modefiel_id", unique = true, nullable = false)
	public Integer getModefielId() {
		return this.modefielId;
	}

	public void setModefielId(Integer modefielId) {
		this.modefielId = modefielId;
	}

	@Column(name = "model_id", nullable = false)
	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "inner_type", nullable = false)
	public Integer getInnerType() {
		return this.innerType;
	}

	public void setInnerType(Integer innerType) {
		this.innerType = innerType;
	}

	@Column(name = "label", nullable = false, length = 50)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "prompt")
	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Column(name = "devalue")
	public String getDevalue() {
		return this.devalue;
	}

	public void setDevalue(String devalue) {
		this.devalue = devalue;
	}

	@Column(name = "is_required", nullable = false, length = 1)
	public String getIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	@Column(name = "seq", nullable = false)
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "is_dbl_column", nullable = false, length = 1)
	public String getIsDblColumn() {
		return this.isDblColumn;
	}

	public void setIsDblColumn(String isDblColumn) {
		this.isDblColumn = isDblColumn;
	}

}