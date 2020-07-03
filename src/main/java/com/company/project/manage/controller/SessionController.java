package com.company.project.manage.controller;

import com.company.project.common.result.ResponseBo;
import com.company.project.common.result.Result;
import com.company.project.manage.entity.UserOnline;
import com.company.project.manage.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    @ResponseBody
    @RequestMapping("forceLogout")
    public Result forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure("踢出用户失败");
        }

    }
}
