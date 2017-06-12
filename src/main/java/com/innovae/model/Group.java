package com.innovae.model;

public class Group {
    private Integer id;

    private Integer projectId;

    private Integer advisorId1;

    private Integer advisorId2;

    private String leader;

    private String member1;

    private String member2;

    public Group(Integer id, Integer projectId, Integer advisorId1, Integer advisorId2, String leader, String member1, String member2) {
        this.id = id;
        this.projectId = projectId;
        this.advisorId1 = advisorId1;
        this.advisorId2 = advisorId2;
        this.leader = leader;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAdvisorId1() {
        return advisorId1;
    }

    public void setAdvisorId1(Integer advisorId1) {
        this.advisorId1 = advisorId1;
    }

    public Integer getAdvisorId2() {
        return advisorId2;
    }

    public void setAdvisorId2(Integer advisorId2) {
        this.advisorId2 = advisorId2;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
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