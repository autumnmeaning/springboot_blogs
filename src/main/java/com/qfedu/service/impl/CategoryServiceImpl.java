package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ICategoryMapper;
import com.qfedu.pojo.Article;
import com.qfedu.pojo.Category;
import com.qfedu.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<ICategoryMapper, Category> implements ICategoryService {

    @Resource
    private ICategoryMapper categoryMapper;

    @Override
    public List<Article> findArticleByCategoryName(String categoryName) {
        return categoryMapper.findArticleByCategoryName(categoryName);
    }
}
