package com.company.project.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.project.common.result.Result;
import com.company.project.common.util.JwtUtils;
import com.company.project.common.util.MD5Utils;
import com.company.project.manage.dto.LoginDTO;
import com.company.project.manage.entity.UserInfo;
import com.company.project.manage.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "登录管理")
public class LoginController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/login")
	@ApiOperation("登录")
	public Result login(@Validated @RequestBody LoginDTO loginDTO) {
		UserInfo user = userInfoService.getOne(new QueryWrapper<UserInfo>().eq("username", loginDTO.getUsername()));
		Assert.notNull(user, "用户不存在");

		String password = MD5Utils.encrypt(loginDTO.getUsername(), loginDTO.getPassword());
		if(!user.getPassword().equals(password)){
			return Result.failure("密码不正确");
		}
		String jwt = JwtUtils.generateToken(user);
		return Result.success(jwt);
	}

	@ApiOperation("登出")
	@RequiresAuthentication
	@GetMapping("/logout")
	public Result logout() {
		SecurityUtils.getSubject().logout();
		return Result.success();
	}
}
