package com.company.project.manage.controller;

import com.company.project.common.result.Result;
import com.company.project.manage.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.company.project.common.result.Result.failure;
import static com.company.project.common.result.Result.success;

/**
 * (UserInfo)表控制层
 * @author Ray。
 * @since 2020-06-28 15:18:39
 */
@Controller
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Object exception = request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (exception instanceof UnknownAccountException) {
                msg = "账户不存在或密码不正确";
            } else if (exception instanceof IncorrectCredentialsException) {
                msg = "账户不存在或密码不正确";
            } else {
                msg = "其他异常";
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "403";
    }

    /**
     * 用户查询.
     */
    @RequestMapping("/list")
    @RequiresPermissions("userInfo:view")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     */
    @RequestMapping("/add")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/del")
    @RequiresPermissions("userInfo:del")
    public String userDel(){
        return "userInfoDel";
    }

}