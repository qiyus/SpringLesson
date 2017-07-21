package com.vigor.web.domain;

/**
 * Created by Vigor on 2017/7/20.
 * 用户类
 */
public class User {
    private long id;
    private String userName;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
