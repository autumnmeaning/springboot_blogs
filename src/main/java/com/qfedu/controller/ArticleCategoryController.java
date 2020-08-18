package com.qfedu.controller;

import com.qfedu.pojo.ArticleCategory;
import com.qfedu.service.IArticleCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleCategoryController {

    @Resource
    private IArticleCategoryService articleCategoryService;

    @GetMapping("/ArticleCategorys")
    public List<ArticleCategory> findAllArticleCategorys(){
        return articleCategoryService.list();
    }

   @PostMapping("/SaveArticleCategory")
    public String saveArticleCategory(ArticleCategory articleCategory){
        if (articleCategoryService.save(articleCategory)){
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveArticleCategory")
    public String removeArticleCategory(@RequestParam("articleId") int articleId,@RequestParam("categoryId") int categoryId){

        if (remove(articleId,categoryId)){
            return "success";
        }
        return "failed";
    }

    @PostMapping("/updateArticleCategory")
    public String updateArticleCategory(@RequestParam("oldArticleId") int oldArticleId,@RequestParam("oldCategoryId") int oldCategoryId,
                                        @RequestParam("newArticleId") int newArticleId,@RequestParam("newCategoryId") int newCategoryId){

        boolean remove = remove(oldArticleId,oldCategoryId);
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleId(newArticleId);
        articleCategory.setCategoryId(newCategoryId);

        if (articleCategoryService.save(articleCategory) && remove){
            return "success";
        }
        return "failed";
    }

    private boolean remove(int articleId,int categoryId){
        Map<String,Object> map = new HashMap<>();
        map.put("article_id",articleId);
        map.put("category_id",categoryId);
        boolean remove = articleCategoryService.removeByMap(map);
        return remove;
    }
}
