package net.lunar.hypnos.model.entity;

import java.io.Serializable;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Version;

/**
 * 基础实体类
 * 
 * @author Michael
 * @version 1.0.0
 */
public abstract class BaseEntity implements Serializable{
	
	private Long id;
	
	@Version
	private Long olVersion;

	@AssignID("hypnosUid")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOlVersion() {
		return olVersion;
	}

	public void setOlVersion(Long olVersion) {
		this.olVersion = olVersion;
	}

	
	
}
