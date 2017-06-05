package com.innovae.domain;

import java.util.List;

/**
 * @author 张志强
 * @version v0.1 2017/5/17.
 */
public class postDomain {
    /**
     * 帖子id
     */
    private String id;
    /**
     * 帖子名称
     */
    private String title;
    /**
     * 帖子最新活跃时间
     */
    private String time;
    /**
     * 评论数
     */
     private int commentNum;
    /**
     * 帖子标签
     */
    private List<String> tagList;

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
    public void setCommentNum(int commentNum){
        this.commentNum=commentNum;
    }
    public int getCommentNum(){
        return commentNum;
    }
    public void setTagList(List<String> tagList){
        this.tagList=tagList;
    }
    public List<String> getTagList(){
        return tagList;
    }
}
