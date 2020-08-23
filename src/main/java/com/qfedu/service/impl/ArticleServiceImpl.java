package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.IArticleMapper;
import com.qfedu.pojo.Article;
import com.qfedu.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<IArticleMapper, Article> implements IArticleService {

    @Resource
    private IArticleMapper articleMapper;

    @Override
    public List<Article> getLikeArticleByTitle(String title) {
        return articleMapper.getLikeArticleByTitle(title);
    }

    @Override
    public List<Article> getArticleByCreateTimeDesc(int count, int newcount) {
        return articleMapper.getArticleByCreateTimeDesc(count, newcount);
    }

    @Override
    public List<Article> getArticleByVisitorsDesc() {
        return articleMapper.getArticleByVisitorsDesc();
    }


}
