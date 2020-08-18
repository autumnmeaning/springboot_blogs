package com.qfedu.controller;

import com.qfedu.pojo.AdminRole;
import com.qfedu.service.IAdminRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminRoleController {

    @Resource
    private IAdminRoleService adminRoleService;

    @PostMapping("/SaveAdminRole")
    @ApiOperation(value = "新增admin和role关联")
    public String SaveAdminRole(AdminRole adminRole) {
        if (adminRoleService.save(adminRole)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateAdminRole")
    @ApiOperation(value = "修改admin和role关联")
    public String UpdateAdminRole(@RequestParam("oldAdminId") int oldAdminId, @RequestParam("oldRoleId") int oldroleId,
                                  @RequestParam("newAdminId") int newAdminId, @RequestParam("newRoleId") int newRoleId) {
        boolean remove = remove(oldAdminId, oldroleId);
        AdminRole adminRole = new AdminRole();
        adminRole.setAdminId(newAdminId);
        adminRole.setRoleId(newRoleId);
        if (adminRoleService.save(adminRole) && remove) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveAdminRole")
    @ApiOperation(value = "删除admin和role关联")
    public String RemoveAdminRole(@RequestParam("adminId") int adminId, @RequestParam("roleId") int roleId) {
        if (remove(adminId, roleId)) {
            return "success";
        }
        return "failed";
    }

    private boolean remove(int adminId, int roleId) {
        Map<String, Object> map = new HashMap<>();
        map.put("admin_id", adminId);
        map.put("role_id", roleId);
        boolean remove = adminRoleService.removeByMap(map);
        return remove;
    }

}
