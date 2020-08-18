package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_role_perm")
public class RolePerm {
    private int rid;
    private int pid;

}
