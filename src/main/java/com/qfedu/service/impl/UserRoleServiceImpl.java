package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IUserRoleMapper;
import com.qfedu.pojo.UserRole;
import com.qfedu.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<IUserRoleMapper, UserRole> implements IUserRoleService {
}
