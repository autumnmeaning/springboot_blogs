package com.qfedu.controller;

import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import com.qfedu.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    private RedisUtil util;

    @Resource
    private IUserService userService;

    @PostMapping("/Login")
    @CrossOrigin
    public String login(@RequestBody Map<String, Object> map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "success";
        } catch (UnknownAccountException e) {
            return "unkmown";
        } catch (IncorrectCredentialsException e) {
            return "mistake";
        } catch (Exception e) {
            return "failed";
        }
    }

    @PostMapping("/Register")
    @CrossOrigin
    public String register(@RequestBody Map<String, Object> map) {
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String tel = map.get("tel").toString();
        String email = map.get("email").toString();
        String code = map.get("code").toString();

        String scode = util.get(email).toString();
        if (code.equals(scode)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setTel(tel);
            user.setAvatar("http://qfasj77k7.hn-bkt.clouddn.com/moren.jpg");
            user.setEmail(email);
            user.setCreateTime(new Date());
            if (userService.save(user)) {
                return "success";
            }
            return "failed";
        }
        return "error";
    }
}
