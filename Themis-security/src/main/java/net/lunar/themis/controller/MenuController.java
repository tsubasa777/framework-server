package net.lunar.themis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.lunar.themis.model.bo.ThemisResult;
import net.lunar.themis.model.entity.Menu;
import net.lunar.themis.model.vo.ResponseInfoVo;
import net.lunar.themis.service.MenuService;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping()
	public ResponseInfoVo<Menu> queryMenuPageList() {
		return null;
	}
	
	@PostMapping()
	public ResponseInfoVo<Menu> saveMenu(@RequestBody Menu menu) {
		ThemisResult<Menu> result = menuService.saveMenu(menu);
		return ResponseInfoVo.newInstance(result, Menu.class);
	}
	
	@GetMapping("/{id}")
	public ResponseInfoVo<Menu> queryMenu(@PathVariable Long id) {
		ThemisResult<Menu> result = menuService.queryMenu(id);
		return ResponseInfoVo.newInstance(result, Menu.class);
	}
	
}
