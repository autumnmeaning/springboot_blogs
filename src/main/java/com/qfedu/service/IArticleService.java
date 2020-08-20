package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IArticleService extends IService<Article> {
    List<Article> getLikeArticleByTitle(@Param("title") String title);
}
