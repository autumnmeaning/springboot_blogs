package com.qfedu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("tb_focus")
@ApiModel(value = "Focus对象")
public class Focus {
    @TableId
    private int uid;
    @TableField
    private int focusUid;
    @TableField
    private int focusStatus;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFocusUid() {
        return focusUid;
    }

    public void setFocusUid(int focusUid) {
        this.focusUid = focusUid;
    }

    public int getFocusStatus() {
        return focusStatus;
    }

    public void setFocusStatus(int focusStatus) {
        this.focusStatus = focusStatus;
    }

    @Override
    public String toString() {
        return "Focus{" +
                "uid=" + uid +
                ", focusUid=" + focusUid +
                ", focusStatus=" + focusStatus +
                '}';
    }
}
