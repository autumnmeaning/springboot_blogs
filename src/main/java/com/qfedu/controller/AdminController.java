package com.qfedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Admin;
import com.qfedu.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AdminController {

    @Resource
    private IAdminService adminService;

    @GetMapping("/Admins")
    @ApiOperation(value = "获取所有admin对象的列表信息")
    public List<Admin> findAll() {
        return adminService.list();
    }

    @GetMapping("/PageAdmins")
    @ApiOperation(value = "获取分页admin对象的列表信息")
    public IPage<Admin> findPageAdmin(@RequestParam("page") int page, @RequestParam("size") int size) {
        IPage<Admin> pages = new Page<>();
        pages.setCurrent(page);
        pages.setSize(size);
        return adminService.page(pages);
    }

    @GetMapping("/GetAdminById/{adminId}")
    @ApiOperation(value = "获取指定ID的admin对象")
    public Admin getAdminById(@PathVariable int adminId) {
        return adminService.getById(adminId);
    }

    @PostMapping("/SaveAdmin")
    @ApiOperation(value = "新增admin对象")
    public String saveAdmin(Admin admin) {
        if (adminService.save(admin)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateAdmin")
    @ApiOperation(value = "修改admin对象")
    public String updateAdmin(Admin admin) {
        if (adminService.updateById(admin)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveAdmin/{adminId}")
    @ApiOperation(value = "删除admin对象")
    public String removeAdmin(@PathVariable int adminId) {
        if (adminService.removeById(adminId)) {
            return "success";
        }
        return "failed";
    }
}
