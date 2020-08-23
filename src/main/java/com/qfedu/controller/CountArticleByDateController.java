package com.qfedu.controller;

import com.qfedu.pojo.CountArticle;
import com.qfedu.service.ICountArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/8/22
 *
 * 根据日期查询文章创建数
 */
@RestController
@CrossOrigin
public class CountArticleByDateController {
    @Resource
    private ICountArticleService countArticleService;
    @GetMapping("/ArticleCountByDate")
    public List<CountArticle> getArticleCountByDate(){
        return countArticleService.getArticleCountByDate();
    }
}
