package com.company.project.manage.dao;

import com.company.project.manage.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * (UserInfo)表数据库访问层
 *
 * @author Raychen
 * @since 2020-06-28 15:37:08
 */
public interface UserInfoDao extends Mapper<UserInfo> {

    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(@Param("username") String username);
}