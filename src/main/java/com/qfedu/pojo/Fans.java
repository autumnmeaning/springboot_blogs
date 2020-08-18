package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_fans")
@ApiModel(value = "Fans对象")
public class Fans {
    @TableId
    private int uid;
    @TableField
    private int fansUid;

}
