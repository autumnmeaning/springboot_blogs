package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_role_perm")
@ApiModel(value = "RolePerm对象")
public class RolePerm {
    private int rid;
    private int pid;

}
