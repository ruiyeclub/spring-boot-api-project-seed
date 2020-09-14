package com.company.project.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.manage.dao.SysUserRoleDao;
import com.company.project.manage.entity.SysUserRole;
import com.company.project.manage.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysUserRole)表服务实现类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;
}