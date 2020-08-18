package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_collect")
@ApiModel(value = "Collect对象")
public class Collect {

    @TableId
    private int uid;
    @TableField
    private int articleId;

}
