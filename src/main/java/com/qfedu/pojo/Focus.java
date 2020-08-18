package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_focus")
public class Focus {
    private int uid;
    private int focus_uid;
    private int focus_status;

}
