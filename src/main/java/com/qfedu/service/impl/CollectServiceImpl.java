package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ICollectMapper;
import com.qfedu.pojo.Collect;
import com.qfedu.service.ICollectService;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends ServiceImpl<ICollectMapper, Collect> implements ICollectService {
}
