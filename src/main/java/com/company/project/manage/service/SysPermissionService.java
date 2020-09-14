package com.company.project.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.project.manage.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysPermission)表服务接口
 *
 * @author Raychen
 * @since 2020-06-28 15:18:38
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 根据角色ID查询角色对应的权限信息
     */
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);
}