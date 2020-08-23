package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@TableName("tb_category")
@ApiModel(value = "Category对象")
public class Category {
    @TableId(type = IdType.AUTO)
    private int categoryId;
    private String categoryName;

    @TableField(exist = false)
    private List<Article> articleList;
}
