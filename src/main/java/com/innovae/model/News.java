package com.innovae.model;

import java.util.Date;

public class News {
    private Integer id;

    private Date time;

    private String title;

    private String content;

    public News(Integer id, Date time, String title, String content) {
        this.id = id;
        this.time = time;
        this.title = title;
        this.content = content;
    }

    public News() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}