package com.company.project.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.manage.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysPermission)表数据库访问层
 *
 * @author Raychen
 * @since 2020-06-28 15:37:07
 */
public interface SysPermissionDao extends BaseMapper<SysPermission> {

    /**
     * 根据角色ID查询角色对应的权限信息
     */
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);
}