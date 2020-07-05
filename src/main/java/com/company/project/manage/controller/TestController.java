package com.company.project.manage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ray。
 * @create 2020-07-05 19:53
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("test")
    public String testDevtools(){
        System.out.println("???111");
        return "te411";
    }

}