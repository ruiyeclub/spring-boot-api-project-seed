package com.company.project.manage.service;

import com.company.project.manage.entity.UserOnline;

import java.util.List;

/**
 * @author Ray。
 * @version 1.0
 * @date 2020/7/2 10:31
 */
public interface SessionService {

    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}

