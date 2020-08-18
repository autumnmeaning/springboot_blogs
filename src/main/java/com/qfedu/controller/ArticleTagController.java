package com.qfedu.controller;

import com.qfedu.pojo.ArticleTag;
import com.qfedu.service.IArticleTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleTagController {

    @Resource
    private IArticleTagService articleTagService;

    @GetMapping("/ArticleTags")
    public List<ArticleTag> findAllArticleTags(){
        return articleTagService.list();
    }

    @PostMapping("/SaveArticleTag")
    public String saveArticleTag(ArticleTag articleTag){
        if (articleTagService.save(articleTag)){
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveArticleTag")
    public String removeArticleTag(@RequestParam("articleId") int articleId,@RequestParam("tagId") int tagId){
        if (remove(articleId,tagId)){
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateArticleTag")
    public String updateArticleTag(@RequestParam("oldArticleId") int oldArticleId,@RequestParam("oldTagId") int oldTagId,
                                   @RequestParam("newArticleId") int newArticleId,@RequestParam("newTagId") int newTagId){
        boolean remove = remove(oldArticleId,oldTagId);
        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticleId(newArticleId);
        articleTag.setTagId(newTagId);

        if (articleTagService.save(articleTag) && remove){
            return "success";
        }
        return "failed";
    }

    private boolean remove(int articleId,int tagId){
        Map<String,Object> map = new HashMap<>();
        map.put("article_id",articleId);
        map.put("tag_id",tagId);
        boolean remove = articleTagService.removeByMap(map);
        return remove;
    }
}
