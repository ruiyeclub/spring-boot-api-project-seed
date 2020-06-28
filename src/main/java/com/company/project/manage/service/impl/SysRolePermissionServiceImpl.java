package com.company.project.manage.service.impl;

import com.company.project.common.service.AbstractService;
import com.company.project.manage.dao.SysRolePermissionDao;
import com.company.project.manage.entity.SysRolePermission;
import com.company.project.manage.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysRolePermission)表服务实现类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends AbstractService<SysRolePermission> implements SysRolePermissionService {
    @Resource
    private SysRolePermissionDao sysRolePermissionDao;
}