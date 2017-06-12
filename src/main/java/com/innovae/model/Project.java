package com.innovae.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Project {

    @Id
    private Integer id;

    private String title;

    private String introduction;

    private Date applyTime;

    private Date finishTime;

    private Integer state;

    private Integer type;

    private String college;

    private String path1;

    private String path2;

    private String path3;

    public Project(Integer id, String title, String introduction, Date applyTime, Date finishTime, Integer state, Integer type, String college, String path1, String path2, String path3) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.applyTime = applyTime;
        this.finishTime = finishTime;
        this.state = state;
        this.type = type;
        this.college = college;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
    }

    public Project() {
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1 == null ? null : path1.trim();
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2 == null ? null : path2.trim();
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3 == null ? null : path3.trim();
    }
}