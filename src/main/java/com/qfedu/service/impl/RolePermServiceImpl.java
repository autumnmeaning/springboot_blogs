package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IRolePermMapper;
import com.qfedu.pojo.RolePerm;
import com.qfedu.service.IRolePermService;
import org.springframework.stereotype.Service;

@Service
public class RolePermServiceImpl extends ServiceImpl<IRolePermMapper, RolePerm> implements IRolePermService {
}
