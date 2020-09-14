package com.company.project.manage.dto.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Ray。
 * @version 1.0
 * @date 2020/6/29 13:50
 */
@Data
public class LoginParam {
    @NotBlank(message = "用户名不能为空!")
    private String username;
    @NotBlank(message = "密码不能为空!")
    private String password;
    private boolean rememberMe;
}
