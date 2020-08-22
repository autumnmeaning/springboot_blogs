package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author Hz
 * 2020/8/22
 *
 * 根据日期统计文章
 */
@TableName("tb_article")
public class CountArticle {
    private int count;
    private Date date;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CountArticle{" +
                "count=" + count +
                ", date=" + date +
                '}';
    }
}
