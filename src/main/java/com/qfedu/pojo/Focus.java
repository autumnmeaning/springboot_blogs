package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_focus")
@ApiModel(value = "Focus对象")
public class Focus {
    private int uid;
    private int focusUid;
    private int focusStatus;

}
