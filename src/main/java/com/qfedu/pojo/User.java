package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_user")
@ApiModel(value = "User对象")
public class User {

    @TableId(type = IdType.AUTO)
    private int uid;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String des;
    private Date createTime;

}
