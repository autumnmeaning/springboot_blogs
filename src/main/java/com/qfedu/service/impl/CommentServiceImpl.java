package com.qfedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.mapper.ICommentMapper;
import com.qfedu.pojo.Comment;
import com.qfedu.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<ICommentMapper, Comment> implements ICommentService {
    @Resource
    private ICommentMapper iCommentMapper;
    @Override
    public List<Comment> findByArticleid(Integer articleid) {
        return iCommentMapper.findByArticleid(articleid);
    }

    @Override
    public List<Comment> findByUserid(Integer userid) {
        return iCommentMapper.findByUserid(userid);
    }

    @Override
    public List<Comment> getCommentCreateTimeDescByArticleId(int articleId) {
        return iCommentMapper.getCommentCreateTimeDescByArticleId(articleId);
    }
}
