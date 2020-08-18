package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IAdminRoleMapper;
import com.qfedu.pojo.AdminRole;
import com.qfedu.service.IAdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<IAdminRoleMapper, AdminRole> implements IAdminRoleService {
}
