package com.an.an_be.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 账单实体类
 * @Author zhangan
 * @date: 2019/12/19
 */
public class AnBill implements Serializable {

    private Integer billId;
    /** 金额 */
    private Integer money;
    private Date createTime;
    private String billType;
    private String desc;
    private Integer userId;
    /** 状态：尚未定 */
    private String state;
    /** 保留字段 */
    private String remain;


    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public Integer getBillId() {

        return billId;
    }

    public Integer getMoney() {
        return money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getBillType() {
        return billType;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getState() {
        return state;
    }

    public String getRemain() {
        return remain;
    }
}
