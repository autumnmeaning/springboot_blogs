package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IArticleMapper extends BaseMapper<Article> {
    List<Article> getLikeArticleByTitle(@Param("title") String title);
}
