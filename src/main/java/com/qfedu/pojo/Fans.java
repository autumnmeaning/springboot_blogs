package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_fans")
@ApiModel(value = "Fans对象")
public class Fans {
    @TableId
    private int uid;
    @TableField
    private int fansUid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFansUid() {
        return fansUid;
    }

    public void setFansUid(int fansUid) {
        this.fansUid = fansUid;
    }

    @Override
    public String toString() {
        return "Fans{" +
                "uid=" + uid +
                ", fansUid=" + fansUid +
                '}';
    }
}
