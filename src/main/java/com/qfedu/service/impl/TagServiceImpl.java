package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ITagMapper;
import com.qfedu.pojo.Tag;
import com.qfedu.service.ITagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends ServiceImpl<ITagMapper, Tag> implements ITagService {
}
