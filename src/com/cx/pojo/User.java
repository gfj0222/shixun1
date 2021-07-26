package com.cx.pojo;

public class User {
    private String naem;
    private String password;

    public User() {
    }

    public User(String naem, String password) {
        this.naem = naem;
        this.password = password;
    }

    public String getNaem() {
        return naem;
    }

    public void setName(String naem) {
        this.naem = naem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
