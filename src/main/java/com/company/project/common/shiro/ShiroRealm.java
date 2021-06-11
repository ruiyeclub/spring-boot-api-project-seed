package com.company.project.common.shiro;

import com.company.project.common.util.JwtUtils;
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
     * 判断传入的token是否是JwtToken
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 获取用户身份信息的时候 就会调用此方法 从数据库获取该用户的权限与角色信息
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.info("授权-->ShiroRealm.doGetAuthorizationInfo()");
        //shiro的对象 存储登录用户的信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principal.getPrimaryPrincipal();
        // 获取用户角色集
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
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        System.out.println("认证-->ShiroRealm.doGetAuthenticationInfo");
        //获取用户的输入的账号
        JwtToken jwtToken = (JwtToken) token;
        String id = JwtUtils.checkToken(jwtToken.getPrincipal().toString()).get("id").toString();
        UserInfo userInfo = userInfoService.getById(Integer.parseInt(id));
        if (userInfo == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (userInfo.getState().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        return new SimpleAuthenticationInfo(userInfo, jwtToken.getCredentials(), getName());
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
