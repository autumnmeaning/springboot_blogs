package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IPermissionMapper;
import com.qfedu.pojo.Permission;
import com.qfedu.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionMapper, Permission> implements IPermissionService {
    @Resource
    private IPermissionMapper iPermissionMapper;
    @Override
    public List<Permission> findByRoleid(Integer roleid) {
        return iPermissionMapper.findByRoleid(roleid);
    }
}
