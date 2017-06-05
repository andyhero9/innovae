package com.innovae.model;

import javax.persistence.*;
@Entity
public class User {
    @Id @Column(nullable = false)
    private String id;

    private String name;

    private String password;

    private String college;

    private String major;

    private String grade;

    private String introduction;

    private String avatorPath;

    private String phone;

    private String email;

    private String stuNum;

    public User(String id, String name, String password, String college, String major, String grade, String introduction, String avatorPath, String phone, String email, String stuNum) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.introduction = introduction;
        this.avatorPath = avatorPath;
        this.phone = phone;
        this.email = email;
        this.stuNum = stuNum;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getAvatorPath() {
        return avatorPath;
    }

    public void setAvatorPath(String avatorPath) {
        this.avatorPath = avatorPath == null ? null : avatorPath.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }
}