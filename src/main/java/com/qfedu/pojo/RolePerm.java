package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_role_perm")
public class RolePerm {
    @TableId
    private int rid;
    @TableId
    private int pid;

}
