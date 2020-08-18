package com.qfedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IPermissionMapper extends BaseMapper<Permission> {
   List<Permission> findByRoleid(Integer roleid);
}
