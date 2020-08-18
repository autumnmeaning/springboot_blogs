package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_advertising")
public class Advertising {

    @TableId(type = IdType.AUTO)
    private int adverId;
    private String name;
    private String image;
    private String status;

}
