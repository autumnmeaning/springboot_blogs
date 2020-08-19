package com.qfedu.controller;

import com.qfedu.pojo.Tag;
import com.qfedu.service.ITagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TagController {

    @Resource
    private ITagService tagService;

    @GetMapping("/Tags")
    @ApiOperation(value = "获取所有tag对象的列表信息")
    public List<Tag> findAllRoles() {
        List<Tag> list = tagService.list();
        return list;
    }

    @GetMapping("/GetTagById/{id}")
    public Tag findTagById(@PathVariable Integer id) {
        Tag tag = tagService.getById(id);
        return tag;
    }

    @GetMapping("/removeTag/{id}")
    @ApiOperation(value = "删除tag对象")
    public String deleteTag(@PathVariable Integer id) {
        boolean b = tagService.removeById(id);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/updateTag")
    @ApiOperation(value = "修改tag对象")
    public String updateTag(Tag tag) {
        boolean b = tagService.updateById(tag);
        if (b == true) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/SaveTag")
    @ApiOperation(value = "新增tag对象")
    public String saveTag(Tag tag) {
        boolean b = tagService.save(tag);
        if (b == true) {
            return "success";
        }
        return "failed";
    }
}
