package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@TableName("tb_role")
@ApiModel(value = "Role对象")
public class Role {
    @TableId(type = IdType.AUTO)
    private int rid;
    private String rname;
    private String rdesc;

    @TableField(exist = false)
    private List<Permission> permList;
}
