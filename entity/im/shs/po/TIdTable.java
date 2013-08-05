package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TIdTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_id_table", catalog = "webims_cms")
public class TIdTable implements java.io.Serializable {

	// Fields

	private String table;
	private Long idValue;

	// Constructors

	/** default constructor */
	public TIdTable() {
	}

	/** full constructor */
	public TIdTable(String table, Long idValue) {
		this.table = table;
		this.idValue = idValue;
	}

	// Property accessors
	@Id
	@Column(name = "table", unique = true, nullable = false, length = 100)
	public String getTable() {
		return this.table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Column(name = "id_value", nullable = false)
	public Long getIdValue() {
		return this.idValue;
	}

	public void setIdValue(Long idValue) {
		this.idValue = idValue;
	}

}