package com.qfedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Article;
import com.qfedu.service.IArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @GetMapping("/Article")
    @ApiOperation(value = "获取所有article对象的列表信息")
    public List<Article> findAllArticle() {
        return articleService.list();
    }

    @GetMapping("/PageArticle")
    @ApiOperation(value = "获取分页的article对象的列表信息")
    public IPage<Article> findPageArticle(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
         IPage<Article> page1 = new Page<>();
         page1.setPages(page);
         page1.setSize(size);
         return articleService.page(page1);
    }

    @GetMapping("/FindArticleById/{articleId}")
    @ApiOperation(value = "获取指定ID的article对象")
    public Article findArticleById(@PathVariable int articleId) {
        return articleService.getById(articleId);
    }

    @PostMapping("/SaveArticle")
    @ApiOperation(value = "新增article对象")
    public String saveArticle(Article article) {
        if (articleService.save(article)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateArticle")
    @ApiOperation(value = "修改article对象")
    public String updateArticle(Article article) {
        if (articleService.updateById(article)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveArticle/{articleId}")
    @ApiOperation(value = "删除article对象")
    public String removeArticle(@PathVariable int articleId) {
        if (articleService.removeById(articleId)) {
            return "success";
        }
        return "failed";
    }
}
