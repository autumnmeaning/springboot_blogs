package com.qfedu.controller;


import com.qfedu.pojo.RolePerm;
import com.qfedu.service.IRolePermService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RolePermController {

    @Resource
    private IRolePermService rolePermService;

    @PostMapping("/SaveRolePerm")
    @ApiOperation(value = "新增role和permission关联")
    public String SaveRolePerm(RolePerm rolePerm) {
        if (rolePermService.save(rolePerm)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/UpdateAdminRole")
    @ApiOperation(value = "修改permission和role关联")
    public String UpdateAdminRole(@RequestParam("oldRid") int oldRid, @RequestParam("oldPid") int oldPid,
                                  @RequestParam("newRid") int newRid, @RequestParam("newPid") int newPid) {
        boolean remove = remove(oldRid, oldPid);
        RolePerm rolePerm = new RolePerm();
        rolePerm.setRid(newRid);
        rolePerm.setPid(newPid);
        if (rolePermService.save(rolePerm) && remove) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveRolePerm")
    @ApiOperation(value = "删除permission和role关联")
    public String RemoveRolePerm(@RequestParam("rid") int rid, @RequestParam("pid") int pid) {
        if (remove(rid, pid)) {
            return "success";
        }
        return "failed";
    }

    private boolean remove(int rid, int pid) {
        Map<String, Object> map = new HashMap<>();
        map.put("rid", rid);
        map.put("pid", pid);
        boolean remove = rolePermService.removeByMap(map);
        return remove;
    }
}
