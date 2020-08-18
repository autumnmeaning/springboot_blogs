package com.qfedu.controller;

import com.qfedu.pojo.UserRole;
import com.qfedu.service.IUserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRoleController {

    @Resource
    private IUserRoleService userRoleService;

    @PostMapping("/SaveUserRole")
    @ApiOperation(value = "新增User和role关联")
    public String SaveUserRole(UserRole userRole) {
        if (userRoleService.save(userRole)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateUserRole")
    @ApiOperation(value = "修改User和role关联")
    public String UpdateUserRole(@RequestParam("oldUid") int oldUid, @RequestParam("oldRid") int oldRid,
                                  @RequestParam("newUid") int newUid, @RequestParam("newRid") int newRid) {
        boolean remove = remove(oldUid, oldRid);
        UserRole userRole = new UserRole();
        userRole.setUid(newUid);
        userRole.setRid(newRid);
        if (userRoleService.save(userRole) && remove) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveUserRole")
    @ApiOperation(value = "删除User和role关联")
    public String RemoveUserRole(@RequestParam("uid") int uid, @RequestParam("rid") int rid) {
        if (remove(uid, rid)) {
            return "success";
        }
        return "failed";
    }

    private boolean remove(int uid, int rid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("rid", rid);
        boolean remove = userRoleService.removeByMap(map);
        return remove;
    }

}
