package com.an.an_be.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计划表（an_plan）
 * */
public class Plan implements Serializable {
    private String planId;
    private int planAuthor;
    private String planTitle;
    private String planContent;
    /**
     * 计划完成时间
     */
    private String planFinishTime;
    private Date planCreateTime;
    /**
     * 计划是否结束 true or false
     */
    private boolean planIsEnd;

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setPlanAuthor(int planAuthor) {
        this.planAuthor = planAuthor;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public void setPlanFinishTime(String planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    public void setPlanCreateTime(Date planCreateTime) {
        this.planCreateTime = planCreateTime;
    }

    public void setPlanIsEnd(boolean planIsEnd) {
        this.planIsEnd = planIsEnd;
    }

    public String getPlanId() {

        return planId;
    }

    public int getPlanAuthor() {
        return planAuthor;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public String getPlanContent() {
        return planContent;
    }

    public String getPlanFinishTime() {
        return planFinishTime;
    }

    public Date getPlanCreateTime() {
        return planCreateTime;
    }

    public boolean isPlanIsEnd() {
        return planIsEnd;
    }
}
