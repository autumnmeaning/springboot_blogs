package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_article_tag")
public class ArticleTag {
    @TableId
    private int articleId;
    @TableId
    private int tagId;

}
