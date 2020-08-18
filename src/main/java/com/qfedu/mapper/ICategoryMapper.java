package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICategoryMapper extends BaseMapper<Category> {
}
