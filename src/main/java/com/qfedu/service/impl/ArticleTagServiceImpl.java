package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IArticleTagMapper;
import com.qfedu.pojo.ArticleTag;
import com.qfedu.service.IArticleTagService;
import org.springframework.stereotype.Service;

@Service
public class ArticleTagServiceImpl extends ServiceImpl<IArticleTagMapper, ArticleTag> implements IArticleTagService {
}
