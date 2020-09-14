package com.company.project.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -19788476887975424L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    private String description;
    
    private String role;
}