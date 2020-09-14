package com.company.project.common.util;

import com.company.project.manage.entity.UserInfo;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static UserInfo getProfile() {
        return (UserInfo) SecurityUtils.getSubject().getPrincipal();
    }

}
