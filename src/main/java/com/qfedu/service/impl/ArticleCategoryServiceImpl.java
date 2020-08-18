package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IArticleCategoryMapper;
import com.qfedu.pojo.ArticleCategory;
import com.qfedu.service.IArticleCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<IArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {
}
