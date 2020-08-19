package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Permission;
import com.qfedu.pojo.Role;
import com.qfedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMapper extends BaseMapper<User> {
    User findUserByUsername(@Param("username") String username);

    List<Role> findRoleByUsername(@Param("username") String username);

    List<Permission> findPermByUsername(@Param("username") String username);
}
