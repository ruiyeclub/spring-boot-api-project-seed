package com.company.project.manage.controller;

import com.company.project.common.result.Result;
import com.company.project.common.result.ResultCode;
import com.company.project.common.util.RedisUtils;
import com.company.project.manage.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * (UserInfo)表控制层
 * @author Ray。
 * @since 2020-06-28 15:18:39
 */
@Controller
@Slf4j
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 没看懂 这里不是验证登录 只做了跳转
     * @return
     */
    @RequestMapping("/login")
    public Result login(String username, String password) {
        //FIXME
        boolean login = userInfoService.login(username, password);
        if(!login){
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
        return Result.success();
    }

    /**
     * 用户查询.
     */
    @RequestMapping("/list")
    @RequiresPermissions("userInfo:view")
    public Result userInfo(){
        return Result.success();
    }

    /**
     * 用户添加;
     */
    @RequestMapping("/add")
    @RequiresPermissions("userInfo:add")
    public Result userInfoAdd(){
        return Result.success();
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/del")
    @RequiresPermissions("userInfo:del")
    public Result userDel(){
        return Result.success();
    }

}