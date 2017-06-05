package com.innovae.domain;

/**
 * @author 张志强
 * @version v0.1 2017/5/17.
 */
public class commentDomain {
    /**
     * 评论id
     */
    private String id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private String time;
    /**
     * 评论人名称
     */
     private String name;
    /**
     * 评论人id
     */
     private String userId;
    /**
     * 头像地址
     */
    private String head;

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
    public void setUserId(String userid){
        this.userId=userid;
    }
    public String getUserId(){
        return userId;
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
}
