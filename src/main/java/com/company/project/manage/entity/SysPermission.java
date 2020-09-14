package com.company.project.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:34
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -90790111150795021L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private String permission;
    
    private String url;
}