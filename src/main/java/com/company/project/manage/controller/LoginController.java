package com.company.project.manage.controller;

import com.company.project.common.result.Result;
import com.company.project.common.util.MD5Utils;
import com.company.project.manage.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@Api(tags = "登录管理")
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	@ApiOperation("登录")
	public Result login(String username, String password, Boolean rememberMe) {
		System.out.println("我是controller");
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		System.out.println("我是controller1");
		try {
			subject.login(token);
			System.out.println("我是controller2");
			return Result.success();
		} catch (UnknownAccountException e) {
			return Result.failure(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return Result.failure(e.getMessage());
		} catch (LockedAccountException e) {
			return Result.failure(e.getMessage());
		} catch (AuthenticationException e) {
			return Result.failure("认证失败！");
		}
	}

	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/index";
	}
	
	@GetMapping("/403")
	public String forbid() {
		return "403";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", user);
		return "index";
	}
}
