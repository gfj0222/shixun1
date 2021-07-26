package com.cx.service;

import com.cx.Utils.BeanFactory;
import com.cx.Utils.Md5Util;
import com.cx.dao.bankDaoImpl;
import com.cx.dao.bankDao;
import com.cx.pojo.User;


import javax.swing.*;
import java.util.Properties;
import java.util.Scanner;

public class userServiceImpl implements UserService {


    private bankDao bd = null;

    /**
     * 单例
     */
    private static userServiceImpl instance = null;

    private userServiceImpl() throws Exception{
        BeanFactory beanFactory = BeanFactory.getInstance();
        bd=beanFactory.creatDao();
    }


    public static userServiceImpl getInstance() {
        if (null == instance) {
            try {
                instance = new userServiceImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    Properties ps = null;
    Scanner sc = new Scanner(System.in);

    /**
     * 登入功能，用finderUser查询输入的账号和密码是否错误
     */
    @Override
    public Properties login(String name,String password) {

        Properties ps = bd.findUser(name,password);
        //假如账号密码验证通过，则进入主页面
        if(ps!=null){
            return ps;
        }else{

            return null;
        }
    }

    /**
     * 注册功能，调用findByName
     */
    @Override
    public Properties register(String name, String password) {

         Properties flag = bd.findByName(name);
        if(flag == null){
            Properties ps = new Properties();
            User user  = new User();
            //不存在同名的用户名，可以注册,添加用户
            ps.setProperty("name", name);
            ps.setProperty("password",(Md5Util.md5(password)));
            ps.setProperty("money", "0");
            bd.insertUser(ps);
            return ps;
        }else { //用户名已被注册
           return null;
        }
    }

    //退出
    @Override
    public void exitSystem() {

        System.exit(1);
    }

}
