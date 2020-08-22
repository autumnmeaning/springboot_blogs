package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.CountArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Hz
 * 2020/8/22
 */
@Mapper
public interface ICountArticleMapper extends BaseMapper<CountArticle> {
    //根据日期统计文章数
    List<CountArticle> getArticleCountByDate();
}
