package com.qfedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.pojo.Comment;

import java.util.List;

public interface ICommentService extends IService<Comment> {
    List<Comment> findByArticleid(Integer articleid);
    List<Comment> findByUserid(Integer userid);
}
