package com.company.project.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.common.util.StringUtils;
import com.company.project.manage.dao.UserInfoDao;
import com.company.project.manage.entity.UserInfo;
import com.company.project.manage.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (UserInfo)表服务实现类
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao,UserInfo> implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    @Override
    public boolean login(String username, String password) {
        UserInfo user = userInfoDao.findByUsername(username);
        if(StringUtils.isNull(user)){
            return false;
        }
        return true;
    }
}