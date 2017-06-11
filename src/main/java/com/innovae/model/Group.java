package com.innovae.model;

public class Group {
    private Integer id;

    private Integer ptojectid;

    private Integer advisorid1;

    private Integer advisorid2;

    private String header;

    private String member1;

    private String member2;

    public Group(Integer id, Integer ptojectid, Integer advisorid1, Integer advisorid2, String header, String member1, String member2) {
        this.id = id;
        this.ptojectid = ptojectid;
        this.advisorid1 = advisorid1;
        this.advisorid2 = advisorid2;
        this.header = header;
        this.member1 = member1;
        this.member2 = member2;
    }

    public Group() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPtojectid() {
        return ptojectid;
    }

    public void setPtojectid(Integer ptojectid) {
        this.ptojectid = ptojectid;
    }

    public Integer getAdvisorid1() {
        return advisorid1;
    }

    public void setAdvisorid1(Integer advisorid1) {
        this.advisorid1 = advisorid1;
    }

    public Integer getAdvisorid2() {
        return advisorid2;
    }

    public void setAdvisorid2(Integer advisorid2) {
        this.advisorid2 = advisorid2;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1 == null ? null : member1.trim();
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2 == null ? null : member2.trim();
    }
}