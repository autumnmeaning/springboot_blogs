package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IFocusMapper;
import com.qfedu.pojo.Focus;
import com.qfedu.service.IFocusService;
import org.springframework.stereotype.Service;

@Service
public class FocusServiceImpl extends ServiceImpl<IFocusMapper, Focus> implements IFocusService {
}
