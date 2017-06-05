package com.innovae.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张志强
 * @version v0.1 2017/5/17.
 */
public class postDetialDomain {
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
     * 发帖人id
     */
    private String userid;
    /**
     * 发帖人名称
     */
    private String name;
    /**
     * 头像地址
     */
    private String head;
    /**
     * 帖子内容
     */
    private String content;
    /**
     * 评论
     */
    private List<commentDomain> comment;

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
    public void setUserid(String userid){
        this.userid=userid;
    }
    public String getUserid(){
        return userid;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setHead(String head){
        this.head=head;
    }
    public String getHead(){
        return head;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return content;
    }
    public void setComment(List<commentDomain> comment){
        if(comment== null){
           comment=new ArrayList<>();
        }
        comment.addAll(comment);
    }
    public List<commentDomain> getComment(){
        return comment;
    }
}
