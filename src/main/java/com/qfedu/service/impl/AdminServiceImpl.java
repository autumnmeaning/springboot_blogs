package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IAdminMapper;
import com.qfedu.pojo.Admin;
import com.qfedu.service.IAdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {
}
