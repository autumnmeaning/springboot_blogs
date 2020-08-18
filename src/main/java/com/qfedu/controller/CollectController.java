package com.qfedu.controller;

import com.qfedu.pojo.Collect;
import com.qfedu.service.ICollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CollectController {

    @Resource
    private ICollectService collectService;

    @GetMapping("/Collects")
    public List<Collect> findAllCollects(){
        return collectService.list();
    }

    @PostMapping("/SaveCollect")
    public String saveCollect(Collect collect){
        if (collectService.save(collect)){
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveCollect")
    public String removeCollect(@RequestParam("uid") int uid,@RequestParam("articleId") int articleId){
        if (remove(uid,articleId)){
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateCollect")
    public String updateCollect(@RequestParam("oldUid") int oldUid,@RequestParam("oldArticleId") int oldArticleId,
                                @RequestParam("newUid") int newUid,@RequestParam("newArticleId") int newArticleId){

        boolean remove = remove(oldUid, oldArticleId);
        Collect collect = new Collect();
        collect.setUid(newUid);
        collect.setArticleId(newArticleId);
        if (collectService.save(collect) && remove){
            return "success";
        }
        return "failed";
    }

    private boolean remove(@RequestParam("uid") int uid,@RequestParam("articleId") int articleId){
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("article_id",articleId);
        boolean remove = collectService.removeByMap(map);
        return remove;
    }
}
