package com.company.project.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.manage.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * (UserInfo)表数据库访问层
 *
 * @author Raychen
 * @since 2020-06-28 15:37:08
 */
public interface UserInfoDao extends BaseMapper<UserInfo> {

    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(@Param("username") String username);
}