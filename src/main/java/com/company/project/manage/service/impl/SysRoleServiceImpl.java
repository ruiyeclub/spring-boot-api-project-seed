package com.company.project.manage.service.impl;

import com.company.project.common.service.AbstractService;
import com.company.project.manage.dao.SysRoleDao;
import com.company.project.manage.entity.SysRole;
import com.company.project.manage.entity.SysRolePermission;
import com.company.project.manage.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRole)表服务实现类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findRoleByUsername(String username) {
        return sysRoleDao.findRoleByUsername(username);
    }
}