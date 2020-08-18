package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICommentMapper extends BaseMapper<Comment> {
    List<Comment> findByArticleid(@Param("articleid") Integer articleid);
    List<Comment> findByUserid(@Param("uid") Integer uid);
}
