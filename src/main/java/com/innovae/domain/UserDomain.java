package com.innovae.domain;

/**
 * Created by Polotin on 2017/5/19.
 */
public class UserDomain {
    private int result = 0;
    private String id;
    private String userName;

    public UserDomain(){}

    public UserDomain(int result, String id, String userName) {
        this.result = result;
        this.id = id;
        this.userName = userName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
