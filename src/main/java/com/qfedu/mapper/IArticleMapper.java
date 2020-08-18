package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IArticleMapper extends BaseMapper<Article> {
}
