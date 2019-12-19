package com.an.an_be.entity;

import java.io.Serializable;

/**
 * ajax 返回结果对象
 */
public class Result implements Serializable {
    //状态码  200：成功， 403：请求失败
    private int code;
    //返回信息
    private String msg;
    //成功状态
    private Boolean isSuccess;
    //返回对象
    private Object data;

    public Result() {
    }

    public Result(int code, Boolean isSuccess) {
        this.code = code;
        this.isSuccess = isSuccess;
    }

    public Result(int code, String msg, Boolean isSuccess) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public Result(int code, String msg, Boolean isSuccess, Object data) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {

        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Object getData() {
        return data;
    }
}
