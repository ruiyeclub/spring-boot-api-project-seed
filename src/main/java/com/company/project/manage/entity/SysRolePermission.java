package com.company.project.manage.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -92296252292321828L;

    private Integer permissionId;
    
    private Integer roleId;
}