package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_admin_role")
public class AdminRole {
    @TableId
    private int adminId;
    @TableId
    private int roleId;

}
