package com.qfedu.controller;

import com.qfedu.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private IUserService userService;

    @PostMapping("/Login")
    public String login(String username, String passwprd) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, passwprd);

        try {
            subject.login(token);
            return "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "failed";
        }
    }
}
