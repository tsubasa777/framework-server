package net.lunar.hypnos.model.entity;

import java.util.Date;

import org.beetl.sql.core.annotatoin.UpdateIgnore;

/**
 * 审计基础实体类
 * 
 * @author Michael
 * @version 1.0.0
 */
public abstract class BaseAuditEntity extends BaseEntity{
	@UpdateIgnore
	private Long createBy;
	
	@UpdateIgnore
	private Date createDate;
	
	private Long modifyBy;
	
	private Date modifyDate;

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
