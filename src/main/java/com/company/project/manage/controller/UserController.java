package com.company.project.manage.controller;

import com.company.project.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
	

	@ApiOperation("浏览测试")
	@RequiresPermissions("userInfo:view")
	@GetMapping("list")
	public Result userList() {
		return Result.success("浏览功能");
	}

	@ApiOperation("添加测试")
	@RequiresPermissions("userInfo:add")
	@GetMapping("add")
	public Result userAdd() {
		return Result.success("添加功能");
	}

	@ApiOperation("删除测试")
	@RequiresPermissions("userInfo:del")
	@GetMapping("delete")
	public Result userDelete() {
		return Result.success("删除功能");
	}

	/**
	 * 异常测试
	 * @return
	 */
	@ApiOperation("异常测试")
	@GetMapping("test")
	public Result getTest(){
		int i=1/0;
		return Result.success(i);
	}
}