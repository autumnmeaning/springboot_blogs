package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.CountArticle;

import java.util.List;

/**
 * @author Hz
 * 2020/8/22
 */
public interface ICountArticleService extends IService<CountArticle> {
    //根据日期统计文章数
    List<CountArticle> getArticleCountByDate();
}
