package com.company.project.manage.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequiresPermissions("userInfo:view")
	@RequestMapping("list")
	public String userList(Model model) {
		model.addAttribute("value", "获取用户信息");
		return "user";
	}
	
	@RequiresPermissions("userInfo:add")
	@RequestMapping("add")
	public String userAdd(Model model) {
		model.addAttribute("value", "新增用户");
		return "user";
	}
	
	@RequiresPermissions("user:del")
	@RequestMapping("delete")
	public String userDelete(Model model) {
		model.addAttribute("value", "删除用户");
		return "user";
	}
}
