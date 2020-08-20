package com.qfedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Category;
import com.qfedu.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CategoryController {

    @Resource
    private ICategoryService categoryService;

    @GetMapping("/Categorys")
    @CrossOrigin
    public List<Category> findAllCategorys(){
        return categoryService.list();
    }

    @GetMapping("/PageCategorys")
    public IPage<Category> findPageCategory(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
        Page<Category> pages = new Page<>();
        pages.setCurrent(page);
        pages.setSize(size);
        return categoryService.page(pages);
    }

    @GetMapping("/findCategorysBycategoryId/{categoryId}")
    public Category findCategorysBycategoryId(@PathVariable int categoryId){
        return categoryService.getById(categoryId);
    }

    @PostMapping("/SaveCategory")
    public String saveCategory(Category category){
        if (categoryService.save(category)){
            return "success";
        }
        return "failed";
    }

    @PostMapping("/RemoveCategory/{categoryId}")
    public String removeCategory(@PathVariable int categoryId){
        if (categoryService.removeById(categoryId)){
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateCategory")
    public String updateCategory(Category category){
        if (categoryService.updateById(category)){
            return "success";
        }
        return "failed";
    }

}
