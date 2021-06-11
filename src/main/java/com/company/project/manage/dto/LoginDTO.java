package com.company.project.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ray。
 * @version 1.0
 * @date 2020/6/29 13:50
 */
@Data
public class LoginDTO {
    @NotNull(message = "用户名不能为空!")
    @ApiModelProperty("用户名")
    private String username;
    @NotNull(message = "密码不能为空!")
    @ApiModelProperty("密码")
    private String password;
}
