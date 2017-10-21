package com.vigor.web.domain;

import java.io.Serializable;

/**
 * Created by Vigor on 2017/7/20.
 * 用户类
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private int age;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
