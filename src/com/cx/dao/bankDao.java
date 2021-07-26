package com.cx.dao;

import com.cx.pojo.User;

import java.util.Properties;

public interface bankDao {
    //存储方法
    void saveMoney(Properties ps);
    //新增用户
    void insertUser(Properties ps);
    //按名称查找
    Properties findByName(String name);
    //按账号和密码查找
    Properties findUser(String name, String password);
}
