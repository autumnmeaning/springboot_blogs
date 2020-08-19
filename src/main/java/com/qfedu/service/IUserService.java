package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.Permission;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService extends IService<User> {
    User findUserByUsername(String username);

    List<Role> findRoleByUsername(String username);

    List<Permission> findPermByUsername(@Param("username") String username);
}
