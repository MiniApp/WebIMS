package im.shs.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * WebimsGlobal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "webims_global", catalog = "webims")
public class WebimsGlobal implements java.io.Serializable {

	// Fields

	private Integer globalId;
	private String version;
	private Integer port;
	private String contextPath;

	// Constructors

	/** default constructor */
	public WebimsGlobal() {
	}

	/** minimal constructor */
	public WebimsGlobal(Integer globalId) {
		this.globalId = globalId;
	}

	/** full constructor */
	public WebimsGlobal(Integer globalId, Integer port, String contextPath) {
		this.globalId = globalId;
		this.port = port;
		this.contextPath = contextPath;
	}

	// Property accessors
	@Id
	@Column(name = "global_id", unique = true, nullable = false)
	public Integer getGlobalId() {
		return this.globalId;
	}

	public void setGlobalId(Integer globalId) {
		this.globalId = globalId;
	}

	@Version
	@Column(name = "version", nullable = false, length = 50)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "port")
	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Column(name = "context_path")
	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}