package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IFansMapper;
import com.qfedu.pojo.Fans;
import com.qfedu.service.IFansService;
import org.springframework.stereotype.Service;

@Service
public class FansServiceImpl extends ServiceImpl<IFansMapper, Fans> implements IFansService {
}
