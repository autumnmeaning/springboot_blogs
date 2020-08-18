package com.qfedu.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AuthorizationInfo info = null;
        String admin = getAvailablePrincipal(principals).toString();

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo info = null;

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        User user = userService.getOne(wrapper);

        if (user != null) {
            ByteSource baSalt = new SimpleByteSource("SALT");
            info = new SimpleAuthenticationInfo(username, user.getPassword(), baSalt, getName());
        }
        return info;
    }
}
