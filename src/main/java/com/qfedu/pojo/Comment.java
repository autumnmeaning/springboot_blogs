package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_comment")
public class Comment {

    @TableId(type = IdType.AUTO)
    private int comId;
    private int articleId;
    private String nickname;
    private String content;
    private String email;
    private String ip;
    private String device;
    private String address;
    private Date create_time;

}
