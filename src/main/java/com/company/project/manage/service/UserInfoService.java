package com.company.project.manage.service;

import com.company.project.common.service.Service;
import com.company.project.manage.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * (UserInfo)表服务接口
 *
 * @author Raychen
 * @since 2020-06-28 15:18:39
 */
public interface UserInfoService extends Service<UserInfo> {

    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(@Param("username") String username);

    boolean login(String username, String password);
}