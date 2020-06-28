package com.company.project.manage.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -13536847767183431L;

    @Id
    private Integer uid;
    
    private String name;
    
    private String password;
    
    private String salt;
    
    private String state;
    
    private String username;

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

}