package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_collect")
public class Collect {

    private int uid;
    private int article_id;

}
