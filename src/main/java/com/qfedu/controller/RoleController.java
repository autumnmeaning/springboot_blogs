package com.qfedu.controller;


import com.qfedu.pojo.Role;
import com.qfedu.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

    @Resource
    private IRoleService roleService;

    @GetMapping("/Roles")
    @ApiOperation(value = "获取所有role对象的列表信息")
    public List<Role> findAllRoles() {
        List<Role> list = roleService.list();
        return list;
    }

    @GetMapping("/GetRoleById/{id}")
    public Role findRoleById(@PathVariable Integer id) {
        Role role = roleService.getById(id);
        return role;
    }

    @GetMapping("/removeRole/{id}")
    @ApiOperation(value = "删除role对象")
    public String deleteRole(@PathVariable Integer id) {
        boolean b = roleService.removeById(id);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/updateRole")
    @ApiOperation(value = "修改role对象")
    public String updateRole(Role role) {
        boolean b = roleService.updateById(role);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/SaveRole")
    @ApiOperation(value = "新增role对象")
    public String saveRole(Role role) {
        boolean b = roleService.save(role);
        if (b == true) {
            return "success";
        }
        return "failed";
    }
}
