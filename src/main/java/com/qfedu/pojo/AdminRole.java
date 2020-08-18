package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_admin_role")
@ApiModel(value = "AdminRole对象")
public class AdminRole {
    @TableId
    private int adminId;
    @TableField
    private int roleId;

}
