package com.cx.dao;

import com.cx.Utils.Md5Util;
import com.cx.Utils.fFilter;

import java.io.*;
import java.util.Properties;

public class bankDaoImpl implements bankDao {

    /**
     * 按照账号和密码查询
     * @param name
     * @param password
     * @return
     */

    @Override
    public Properties findUser(String name, String password) {
        Properties ps = fFilter.filterFile(name);
        //假如账号和密码都一样，返回true，登入成功
        if (ps != null) {
            String pname = ps.getProperty("name");
            String pword = ps.getProperty("password");
            if (name.equals(pname) && Md5Util.md5(password).equals(pword)) {
                return ps;
            } else {
                return null;
            }
        }
        return null;
    }


    /**
     * 没找到返回null
     * 找到了返回properties文件
     * @param name
     * @return
     */
       @Override
    public Properties findByName(String name) {
        Properties ps = fFilter.filterFile(name);
        if(ps==null){
            return null;
        }else{
            return ps;
        }
    }

    /**
     * 每次完成操作之后，更新到peoperties文件
     * @param
     */
    //每次更改后，都重新保存money
    @Override
    public void saveMoney(Properties ps) {
        try {
            ps.store(new FileOutputStream("F:\\shixun1\\src\\"+ps.getProperty("name")+".properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 新增用户，注册用
     * @param
     * @return
     */

    //新增用户
    @Override
    public void insertUser(Properties ps) {
        String name = ps.getProperty("name");
        try {
            ps.store(new FileOutputStream("F:\\shixun1\\src\\"+name+".properties"),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
