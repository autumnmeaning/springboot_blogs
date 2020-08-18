package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_article_tag")
@ApiModel(value = "ArticleTag对象")
public class ArticleTag {

    @TableId
    private int articleId;
    @TableField
    private int tagId;

}
