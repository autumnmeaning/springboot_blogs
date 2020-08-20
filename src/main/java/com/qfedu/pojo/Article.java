package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_article")
@ApiModel(value = "Article对象")
public class Article {

    @TableId(type = IdType.AUTO)
    private int articleId;
    private String title;
    private String author;
    private String des;
    private String content;
    private Date createTime;

}
