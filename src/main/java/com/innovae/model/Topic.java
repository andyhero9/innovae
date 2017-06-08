package com.innovae.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Topic {
    @Id @Column(nullable = false)
    private Integer id;

    private String userId;

    private Date time;

    private String tag;

    private String title;

    private String content;

    private Integer type;

    private Integer commentsCount;

    private String userName;

    public Topic(Integer id, String userId, Date time, String tag, String title, String content, Integer type, Integer commentsCount, String userName) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.tag = tag;
        this.title = title;
        this.content = content;
        this.type = type;
        this.commentsCount = commentsCount;
        this.userName = userName;
    }

    public Topic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}