package com.qfedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.pojo.Comment;
import com.qfedu.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/8/18
 */
@RestController
public class CommentController {
    @Resource
    private ICommentService iCommentService;
    //查看所有评论
    @GetMapping("/getCommens")
    public List<Comment> findAllCommens(){
        List<Comment> comments = iCommentService.list();
        return comments;
    }
    //分页查看所有评论
    @GetMapping("/getCommensByPage")
    public IPage<Comment> findCommensByPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
       IPage<Comment> page1 = new Page<>();
       page1.setPages(page);
       page1.setSize(size);
       return iCommentService.page(page1);
    }
    //根据文章id查评论
    @GetMapping("/getCommByArticleid/{articleid}")
    public List<Comment> findByArticleid(@PathVariable Integer articleid){
        List<Comment> commentByArticleid = iCommentService.findByArticleid(articleid);
        return commentByArticleid;
    }
    //根据用户id查评论
    @GetMapping("/getCommByUserid/{userid}")
    public List<Comment> findByUserid(@PathVariable Integer userid){
        List<Comment> commentByUserid = iCommentService.findByUserid(userid);
        return commentByUserid;
    }
    //添加评论
    @GetMapping("/creatComments")
    public String creatComments(Comment comment){

        boolean save = iCommentService.save(comment);
        if(save){
            return "success";
        }
        return "failed";
    }
    //删除评论
    @GetMapping("/removeByCommid/{commentid}")
    public String deleteCommentByCommid(@PathVariable Integer commentid){
        boolean remove = iCommentService.removeById(commentid);
        if(remove){
            return "success";
        }
        return "failed";
    }
}
