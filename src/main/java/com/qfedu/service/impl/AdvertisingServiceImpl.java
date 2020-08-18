package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IAdvertisingMapper;
import com.qfedu.pojo.Advertising;
import com.qfedu.service.IAdvertisingService;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingServiceImpl extends ServiceImpl<IAdvertisingMapper, Advertising> implements IAdvertisingService {
}
