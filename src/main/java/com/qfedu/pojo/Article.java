package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_article")
public class Article {

    @TableId(type = IdType.AUTO)
    private int articleId;
    private String title;
    private String author;
    private String des;
    private String content;
    private Date createTime;
    private String image1;
    private String image2;
    private String image3;

}
