package com.company.project.common.shiro;

import com.company.project.manage.entity.UserInfo;
import com.company.project.manage.service.SysPermissionService;
import com.company.project.manage.service.SysRoleService;
import com.company.project.manage.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ray。
 * @date 2017-12-01 21:25
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 获取用户身份信息的时候 就会调用此方法 从数据库获取该用户的权限与角色信息
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.info("权限配置-->ShiroRealm.doGetAuthorizationInfo()");
        //shiro的对象 存储登录用户的信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principal.getPrimaryPrincipal();
        sysRoleService.findRoleByUsername(userInfo.getUsername()).stream().forEach(
                sysRole -> {
                    authorizationInfo.addRole(sysRole.getRole());
                    sysPermissionService.findPermissionByRoleId(sysRole.getId()).stream().forEach(
                            sysPermission -> {
                                authorizationInfo.addStringPermission(sysPermission.getPermission());
                            }
                    );
                }
        );
        return authorizationInfo;
    }

    /**
     * 在这个方法 进行身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        log.info("----->>userInfo={}",userInfo);
        if (userInfo == null) {
            ////没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        //登录成功 返回一个身份信息
        return new SimpleAuthenticationInfo(
                //用户名
                userInfo,
                //密码
                userInfo.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                getName()
        );
    }

}
