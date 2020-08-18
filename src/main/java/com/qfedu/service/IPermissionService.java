package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.Permission;

import java.util.List;

public interface IPermissionService extends IService<Permission> {
    List<Permission> findByRoleid(Integer roleid);
}
