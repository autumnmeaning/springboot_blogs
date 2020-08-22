package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ICountArticleMapper;
import com.qfedu.pojo.CountArticle;
import com.qfedu.service.ICountArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/8/22
 */
@Service
public class ICountArticleServiceImpl extends ServiceImpl<ICountArticleMapper,CountArticle> implements ICountArticleService {
    @Resource
    private ICountArticleMapper countArticleMapper;
    @Override
    public List<CountArticle> getArticleCountByDate() {
        return countArticleMapper.getArticleCountByDate();
    }
}
