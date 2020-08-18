package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_article_category")
@ApiModel(value = "ArticleCategory对象")
public class ArticleCategory {

    @TableId
    private int articleId;
    @TableField
    private int categoryId;

}
