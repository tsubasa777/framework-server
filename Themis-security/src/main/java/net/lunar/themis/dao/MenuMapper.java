package net.lunar.themis.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;

import net.lunar.hypnos.dao.BaseAuditMapper;
import net.lunar.themis.model.entity.Menu;

@SqlResource("menuMapper")
public interface MenuMapper extends BaseAuditMapper<Menu>{
	
	public Menu queryMaxPathByPid(@Param("pid") Long pid);
}
