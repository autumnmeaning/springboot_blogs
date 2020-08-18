package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_article_category")
public class ArticleCategory {

    private int articleId;
    private int categoryId;

}
