package com.innovae.model;
public class Collection {
    private Integer id;

    private String userId;

    private Integer topicId;

    public Collection(Integer id, String userId, Integer topicId) {
        this.id = id;
        this.userId = userId;
        this.topicId = topicId;
    }

    public Collection() {
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}