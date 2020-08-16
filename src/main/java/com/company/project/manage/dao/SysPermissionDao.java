package com.company.project.manage.dao;

import com.company.project.manage.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (SysPermission)表数据库访问层
 *
 * @author Raychen
 * @since 2020-06-28 15:37:07
 */
public interface SysPermissionDao extends Mapper<SysPermission> {

    /**
     * 根据角色ID查询角色对应的权限信息
     */
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);
}