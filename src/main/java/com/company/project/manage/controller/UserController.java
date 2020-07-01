package com.company.project.manage.controller;

import com.company.project.common.result.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequiresPermissions("userInfo:del")
	@RequestMapping("delete")
	public String userDelete(Model model) {
		model.addAttribute("value", "删除用户");
		return "user";
	}

	/**
	 * 异常测试
	 * @return
	 */
	@RequestMapping("test")
	@ResponseBody
	public Result getTest(){
		int i=1/0;
		return Result.success(i);
	}
}
