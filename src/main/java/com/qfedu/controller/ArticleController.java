package com.qfedu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Article;
import com.qfedu.pojo.ArticleCategory;
import com.qfedu.pojo.ArticleTag;
import com.qfedu.service.IArticleCategoryService;
import com.qfedu.service.IArticleService;
import com.qfedu.service.IArticleTagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @Resource
    private IArticleCategoryService articleCategoryService;

    @Resource
    private IArticleTagService articleTagService;

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
    public String saveArticle(@RequestBody Map<String, Object> map) {
        String title = map.get("title").toString();
        map.get("categoryId");
        int categoryId = (int) map.get("categoryId");
        int tagId = (int) map.get("tagId");
        String des = map.get("des").toString();
        String author = map.get("author").toString();
        String article = map.get("article").toString();
        Article article1 = new Article();
        article1.setAuthor(author);
        article1.setTitle(title);
        article1.setDes(des);
        article1.setContent(article);
        article1.setCreateTime(new Date());
        boolean saveArticle = articleService.save(article1);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("title", title);
        Article one = articleService.getOne(wrapper);
        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticleId(one.getArticleId());
        articleTag.setTagId(tagId);
        boolean saveArticleTag = articleTagService.save(articleTag);
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleId(one.getArticleId());
        articleCategory.setCategoryId(categoryId);
        boolean saveArticleCategory = articleCategoryService.save(articleCategory);
        if (saveArticle && saveArticleCategory && saveArticleTag) {
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
