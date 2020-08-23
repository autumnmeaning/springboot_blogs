package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.Article;
import com.qfedu.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    List<Article> findArticleByCategoryName(String categoryName);
}
