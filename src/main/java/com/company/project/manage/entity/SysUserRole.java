package com.company.project.manage.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -45909249971984990L;

    @Id
    private Integer roleId;
    
    private Integer uid;
}