package com.innovae.model;
public class Advisor {
    private Integer id;

    private String college;

    private String name;

    private String level;

    public Advisor(Integer id, String college, String name, String level) {
        this.id = id;
        this.college = college;
        this.name = name;
        this.level = level;
    }

    public Advisor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}