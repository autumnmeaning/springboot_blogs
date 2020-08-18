package com.qfedu.controller;

import com.qfedu.pojo.Fans;
import com.qfedu.service.IFansService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hz
 * 2020/8/18
 */
@RestController
public class FansController {
    @Resource
    private IFansService iFansService;

    //添加
    @PostMapping("/saveFans")
    private String saveFans(Fans fans){
        boolean save = iFansService.save(fans);
        if(save){
            return "success";
        }
        return "failed";
    }
    //删除
    @GetMapping("/removeFans")
    private String removeFans(@RequestParam Integer uid,@RequestParam Integer fansUid){
        boolean remove = remove(uid, fansUid);
        if(remove){
            return "success";
        }
        return "failed";
    }
    //修改
    @PostMapping("/UpdateFans")
    public String updateFans(@RequestParam("oldUid") int oldUid, @RequestParam("oldFansUid") int oldFansUid,
                                  @RequestParam("newUid") int newUid, @RequestParam("newFansUid") int newFansUid) {
        boolean remove = remove(oldUid, oldFansUid);
        Fans fans = new Fans();
        fans.setUid(newFansUid);
        fans.setFansUid(newFansUid);
        if (iFansService.save(fans) && remove) {
            return "success";
        }
        return "failed";
    }
    private boolean remove(int Uid, int fansUid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", Uid);
        map.put("fans_uid", fansUid);
        boolean remove = iFansService.removeByMap(map);
        return remove;
    }

}
