package com.company.project.manage.entity;

import lombok.Data;

import javax.persistence.Id;
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

    @Id
    private Integer id;
    
    private String available;
    
    private String description;
    
    private String role;
}