package net.lunar.themis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import net.lunar.hypnos.util.RespositoryUtil;
import net.lunar.themis.dao.MenuMapper;
import net.lunar.themis.model.bo.ThemisResult;
import net.lunar.themis.model.entity.Menu;

@Service
public class MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	@Transactional
	public ThemisResult<Menu> saveMenu(Menu menu) {
		if(RespositoryUtil.isNewRecord(menu)) {
			
			if(ObjectUtils.isEmpty(menu.getPid())) {
				menu.setDepth(0);
				menu.setPid(0L);
			}
			
			Menu sideMenu = menuMapper.queryMaxPathByPid(menu.getPid());
			
			if(sideMenu == null ||  sideMenu.getId() == null) {
				Menu pMenu = menuMapper.single(menu.getPid());
				menu.setMenuPath(pMenu.getMenuPath() + "001");
				menu.setDepth(pMenu.getDepth() + 1);
			} else {
				if(ObjectUtils.isEmpty(menu.getPid())) {
					menu.setMenuPath("001");
				} else {
					String pPath = sideMenu.getMenuPath().substring(0, sideMenu.getMenuPath().length() - 3);
					String sideNumStr = sideMenu.getMenuPath().substring(sideMenu.getMenuPath().length() - 3);
					int sideNum = Integer.parseInt(sideNumStr);
					menu.setMenuPath(pPath + String.format("%03d", sideNum + 1));
					menu.setDepth(sideMenu.getDepth());
				}
			}
			
			menuMapper.insert(menu);
		} else {
			menuMapper.updateById(menu);
		}
		ThemisResult<Menu> result = ThemisResult.newInstance(Menu.class);
		result.setResult(menu);
		return result;
	}
	
	public ThemisResult<Menu> queryMenu(Long id) {
		Menu menu = menuMapper.single(id);
		ThemisResult<Menu> result = ThemisResult.newInstance(Menu.class);
		result.setResult(menu);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("%03d", 1221));
		System.out.println(Integer.parseInt("001"));
	}
	
}
