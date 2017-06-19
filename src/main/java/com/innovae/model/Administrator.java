package com.innovae.model;

public class Administrator {
    private String id;

    private String password;

    private String college;

    private String name;

    private Integer type;

    private String email;

    private String emailPassword;

    public Administrator(String id, String password, String college, String name, Integer type, String email, String emailPassword) {
        this.id = id;
        this.password = password;
        this.college = college;
        this.name = name;
        this.type = type;
        this.email = email;
        this.emailPassword = emailPassword;
    }

    public Administrator() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword == null ? null : emailPassword.trim();
    }
}