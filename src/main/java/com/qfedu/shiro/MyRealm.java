package com.qfedu.shiro;

import com.qfedu.pojo.Permission;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = null;
        String user = getAvailablePrincipal(principals).toString();

        List<Role> roles = userService.findRoleByUsername(user);

        if (roles != null) {
            info = new SimpleAuthorizationInfo();

            for (Role r : roles) {
                info.addRole(r.getRname());
            }
        }

        List<Permission> perms = userService.findPermByUsername(user);

        if (perms != null) {
            for (Permission p : perms) {
                info.addStringPermission(p.getPname());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo info = null;

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        User user = userService.findUserByUsername(username);
        if (user != null) {
            ByteSource baSalt = new SimpleByteSource("Blogs");
            info = new SimpleAuthenticationInfo(username, user.getPassword(), baSalt, getName());
        }
        return info;
    }
}
