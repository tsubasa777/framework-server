package net.lunar.themis.model.entity;

import org.beetl.sql.core.annotatoin.Table;

import net.lunar.hypnos.model.entity.BaseAuditEntity;

@Table(name="tbl_themis_menu")
public class Menu extends BaseAuditEntity{
	
	private String menuName;
	
	private String menuPath;
	
	private String menuIcon;
	
	private Integer depth;
	
	private String url;
	
	private Long pid;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
