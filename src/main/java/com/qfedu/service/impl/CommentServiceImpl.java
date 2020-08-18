package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ICommentMapper;
import com.qfedu.pojo.Comment;
import com.qfedu.service.ICommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<ICommentMapper, Comment> implements ICommentService {
}
