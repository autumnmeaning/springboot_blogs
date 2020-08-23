package com.qfedu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Advertising;
import com.qfedu.service.IAdvertisingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

@RestController
@CrossOrigin
public class AdvertisingController {

    @Resource
    private IAdvertisingService advertisingService;

    @GetMapping("/Advertisings")
    @ApiOperation(value = "获取所有advertising对象的列表信息")
    public List<Advertising> findAllAdvertisings() {
        return advertisingService.list();
    }

    @GetMapping("/PageAdvertising")
    @ApiOperation(value = "获取分页的advertising对象的列表信息")
    public IPage<Advertising> findPageAdvertising(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        IPage<Advertising> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(size);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status", 1);
        return advertisingService.page(page1, queryWrapper);
    }

    @GetMapping("/FindAdvertisingById/{adverId}")
    @ApiOperation(value = "获取指定ID的advertising对象")
    public Advertising findAdvertisingById(@PathVariable int adverId) {
        return advertisingService.getById(adverId);
    }

    @PostMapping("/SaveAdvertising")
    @ApiOperation(value = "新增advertising对象")
    public String saveAdvertising(Advertising advertising) {
        if (advertisingService.save(advertising)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateAdvertising")
    @ApiOperation(value = "修改advertising对象")
    public String updateAdvertising(Advertising advertising) {
        if (advertisingService.updateById(advertising)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveAdvertising/{adverId}")
    @ApiOperation(value = "删除advertising对象")
    public String removeAdvertising(@PathVariable int adverId) {
        if (advertisingService.removeById(adverId)) {
            return "success";
        }
        return "failed";
    }
}
