package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@TableName("tb_admin")
@ApiModel(value = "Admin对象")
public class Admin {
    @TableId(type = IdType.AUTO)
    private int adminId;
    private String adminname;
    private String password;
    private String tel;

    @TableField(exist = false)
    private List<Role> roleList;
}
