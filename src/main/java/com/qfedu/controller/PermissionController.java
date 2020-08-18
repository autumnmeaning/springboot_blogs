package com.qfedu.controller;

import com.qfedu.pojo.Permission;
import com.qfedu.service.IPermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/8/18
 */
@RestController
public class PermissionController {
    @Resource
    private IPermissionService iPermissionService;
    //查找所有权限
    @GetMapping("/getPermissions")
    public List<Permission> findPermissions(){
        List<Permission> permissions = iPermissionService.list();
        return permissions;
    }
    //根据角色查权限
    public List<Permission> findPermiByRole(Integer roleid){
        List<Permission> byRoleid = iPermissionService.findByRoleid(roleid);
        return byRoleid;
    }
    //添加
    @PostMapping("/savePermission")
    public String savePermissions(Permission permission){
        boolean save = iPermissionService.save(permission);
        if(save){
            return "success";
        }
        return "failed";
    }
    //删除
    @GetMapping("/removePermission/{pid}")
    public String removePermission(@PathVariable Integer pid){
        boolean remove = iPermissionService.removeById(pid);
        if(remove){
            return "success";
        }
        return "failed";
    }
    //修改
    @PostMapping("/updatePermission")
    public String updatePermission(Permission permission){
        boolean update = iPermissionService.updateById(permission);
        if(update){
            return "success";
        }
        return "failed";
    }
}
