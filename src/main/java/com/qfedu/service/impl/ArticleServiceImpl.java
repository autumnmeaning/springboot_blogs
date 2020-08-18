package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IArticleMapper;
import com.qfedu.pojo.Article;
import com.qfedu.service.IArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<IArticleMapper, Article> implements IArticleService {
}
