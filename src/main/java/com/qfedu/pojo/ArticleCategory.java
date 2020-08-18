package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_article_category")
public class ArticleCategory {
    @TableId
    private int articleId;
    @TableId
    private int categoryId;

}
