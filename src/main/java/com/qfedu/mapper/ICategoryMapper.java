package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Article;
import com.qfedu.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICategoryMapper extends BaseMapper<Category> {
    List<Article> findArticleByCategoryName(@Param("categoryName") String categoryName);
}
