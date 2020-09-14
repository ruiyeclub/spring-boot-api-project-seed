package com.company.project.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.manage.dao.SysPermissionDao;
import com.company.project.manage.entity.SysPermission;
import com.company.project.manage.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysPermission)表服务实现类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao,SysPermission> implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> findPermissionByRoleId(Integer roleId) {
        return sysPermissionDao.findPermissionByRoleId(roleId);
    }
}