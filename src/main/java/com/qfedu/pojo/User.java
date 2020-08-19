package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("tb_user")
@ApiModel(value = "User对象")
public class User {

    @TableId(type = IdType.AUTO)
    private int uid;
    private String username;
    private String password;
    private String avatar;
    private String tel;
    private String email;
    private String udesc;
    private Date createTime;
    private int status;

    @TableField(exist = false)
    private List<Role> roleList;
}
