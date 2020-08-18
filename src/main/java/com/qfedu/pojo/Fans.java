package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_fans")
public class Fans {
    @TableId
    private int uid;
    @TableId
    private int fans_uid;

}
