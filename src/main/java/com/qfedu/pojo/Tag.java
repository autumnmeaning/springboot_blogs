package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_tag")
@ApiModel(value = "Tag对象")
public class Tag {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;

}
