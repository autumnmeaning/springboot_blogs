package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICommentMapper extends BaseMapper<Comment> {
}
