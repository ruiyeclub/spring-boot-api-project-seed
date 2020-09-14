package com.company.project.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.project.manage.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysRole)表服务接口
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过username查找用户角色信息
     */
    List<SysRole> findRoleByUsername(@Param("username") String username);
}