package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_advertising")
@ApiModel(value = "Advertising对象")
public class Advertising {

    @TableId(type = IdType.AUTO)
    private int adverId;
    private String name;
    private String image;
    private String status;
    private String url;

}
