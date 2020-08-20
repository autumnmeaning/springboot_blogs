package com.qfedu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/Users")
    @ApiOperation(value = "获取所有user对象的列表信息")
    public List<User> findAllUsers() {
        return userService.list();
    }

    @GetMapping("/GetUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/GetUserByUsername/{username}")
    public User findUserByUsername(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        return user;
    }

    @GetMapping("/PageUsers")
    @ApiOperation(value = "获取分页user对象的列表信息")
    public IPage<User> pageUsers(@RequestParam("current") Integer current,@RequestParam("size") Integer size) {
        IPage<User> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return userService.page(page);
    }

    @GetMapping("/removeUser/{id}")
    @ApiOperation(value = "删除user对象")
    public String deleteUser(@PathVariable("id") Integer id) {
        boolean b = userService.removeById(id);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改user对象")
    public String updateUser(User user) {
        boolean b = userService.updateById(user);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/SaveUser")
    @ApiOperation(value = "新增user对象")
    public String saveUser(User user) {
        String password = user.getPassword();
        String salt = "Blogs";
        Md5Hash md5Hash = new Md5Hash(password, salt, 3);
        user.setPassword(md5Hash.toString());
        boolean b = userService.save(user);
        if (b == true) {
            return "success";
        }
        return "failed";
    }
}
