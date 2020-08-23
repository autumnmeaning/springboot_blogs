package com.qfedu.controller;

import com.qfedu.pojo.Focus;
import com.qfedu.service.IFocusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hz
 * 2020/8/18
 * 关注
 */
@RestController
public class FocusController {
    @Resource
    private IFocusService iFocusService;

    //添加
    @PostMapping("/saveFocus")
    private String saveFocus(@RequestBody Focus focus){
        boolean save = iFocusService.save(focus);
        if(save){
            return "success";
        }
        return "failed";
    }
    //删除
    @GetMapping("/removeFocus")
    private String removeFocus(@RequestParam Integer uid, @RequestParam Integer focusUid, @RequestParam Integer focusStatus){
        boolean remove = remove(uid, focusUid, focusStatus);
        if(remove){
            return "success";
        }
        return "failed";
    }
    //修改
    @GetMapping("/UpdateFocus")
    public String updateFocus(@RequestParam("oldUid") int oldUid, @RequestParam("oldFocusUid") int oldFocusUid,
                             @RequestParam("newUid") int newUid, @RequestParam("newFocusUid") int newFocusUid,@RequestParam("focusStatus") Integer focusStatus) {
        boolean remove = remove(oldUid, oldFocusUid,focusStatus);
        Focus focus = new Focus();
        focus.setUid(newUid);
        focus.setFocusUid(newFocusUid);
        focus.setFocusStatus(focusStatus);
        if (iFocusService.save(focus) && remove) {
            return "success";
        }
        return "failed";
    }
    private boolean remove(int uid, int focusUid,int focusStatus) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("focus_uid", focusUid);
        map.put("focus_status", focusStatus);
        boolean remove = iFocusService.removeByMap(map);
        return remove;
    }


}
