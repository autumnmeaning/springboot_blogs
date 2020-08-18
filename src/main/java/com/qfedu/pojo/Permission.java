package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_permission")
@ApiModel(value = "Permission对象")
public class Permission {

    @TableId(type = IdType.AUTO)
    private int pid;
    private String pname;
    private String pdesc;
    private String url;
}
