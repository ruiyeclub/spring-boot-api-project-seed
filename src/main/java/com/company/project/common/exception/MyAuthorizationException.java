package com.company.project.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Ray。
 * @version 1.0
 * @date 2020/7/1 14:10
 */
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class MyAuthorizationException {

    /**
     * 处理没有权限的异常
     * @return
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException() {
        return "403";
    }

    /**
     * 强制下线
     * @return
     */
    @ExceptionHandler(value = ExpiredSessionException.class )
    public String handleExpiredSessionException() {
        System.out.println("????????????????????????????");
        return "login";
    }

    @ExceptionHandler(value = Exception.class)
    public void exception(){
        System.out.println("来了");
    }
}
