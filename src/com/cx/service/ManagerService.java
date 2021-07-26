package com.cx.service;

import com.cx.Utils.InvalidDepositException;
import com.cx.pojo.Money;

import java.util.Properties;

public interface ManagerService {
    //根据名字查询账户
    void inquery(Properties ps);
    //取款
    double withdrawls(Properties ps,double save) throws InvalidDepositException;
    //存款
    double deposit(Properties ps, double get);
    //退出
    void exitSystem(Properties ps);
    //转帐
    void transfer(Properties ps1, String name, double money);
}
