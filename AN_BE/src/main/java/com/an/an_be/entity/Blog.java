package com.an.an_be.entity;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private String blogId;
    private String title;
    private String text;
    private String blogType;
    private Date createDate;
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getBlogType() {

        return blogType;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBlogId() {

        return blogId;
    }

    public String getText() {
        return text;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
