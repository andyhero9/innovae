package com.innovae.model;

import java.util.Date;

public class Idea {
    private Integer id;

    private String title;

    private String content;

    private Date time;

    private String userId;

    public Idea(Integer id, String title, String content, Date time, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.userId = userId;
    }

    public Idea() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}