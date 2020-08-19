package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IUserMapper;
import com.qfedu.pojo.Permission;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import com.qfedu.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public List<Role> findRoleByUsername(String username) {
        return userMapper.findRoleByUsername(username);
    }

    @Override
    public List<Permission> findPermByUsername(String username) {
        return userMapper.findPermByUsername(username);
    }
}
