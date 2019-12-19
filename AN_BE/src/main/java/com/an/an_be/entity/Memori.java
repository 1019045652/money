package com.an.an_be.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 备忘录表（AN_MEMORI）
 */
public class Memori implements Serializable {
    private Integer memoriId;
    private Integer userId;
    private String memoriContent;
    private Date memoriCreateTime;
    /**
     * 状态：0：正常 1：紧急 3：可忽略
     */
    private String memoriState;


    public void setMemoriId(Integer memoriId) {
        this.memoriId = memoriId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setMemoriContent(String memoriContent) {
        this.memoriContent = memoriContent;
    }

    public void setMemoriCreateTime(Date memoriCreateTime) {
        this.memoriCreateTime = memoriCreateTime;
    }

    public void setMemoriState(String memoriState) {
        this.memoriState = memoriState;
    }

    public Integer getMemoriId() {

        return memoriId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getMemoriContent() {
        return memoriContent;
    }

    public Date getMemoriCreateTime() {
        return memoriCreateTime;
    }

    public String getMemoriState() {
        return memoriState;
    }

    @Override
    public String toString() {
        return "Memori{" +
                "memoriId=" + memoriId +
                ", userId=" + userId +
                ", memoriContent='" + memoriContent + '\'' +
                ", memoriCreateTime=" + memoriCreateTime +
                ", memoriState='" + memoriState + '\'' +
                '}';
    }
}
