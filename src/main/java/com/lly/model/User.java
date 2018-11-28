package com.lly.model;

/**
 * Created by 无问东西 on 2018/11/28 20:54
 */
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public User(String name) {
        this.name = name;
    }
}
