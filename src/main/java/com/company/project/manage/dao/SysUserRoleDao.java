package com.company.project.manage.dao;

import com.company.project.common.mapper.CrudMapper;
import com.company.project.manage.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author Raychen
 * @since 2020-06-28 15:37:08
 */
public interface SysUserRoleDao extends CrudMapper<SysUserRole> {
}