package com.cx.Utils;

import com.cx.dao.bankDao;

import java.io.FileInputStream;
import java.util.Properties;

public class BeanFactory {

    private static BeanFactory instance;

    private bankDao bankDao;

    private BeanFactory() throws Exception {
        //从文件中加载业务层信息
        Properties ps = new Properties();
        FileInputStream fileInputStream = new FileInputStream("F:\\shixun1\\src\\properties.properties");
        ps.load(fileInputStream);
        fileInputStream.close();

        String className = ps.getProperty("className");

        Class aClass = Class.forName(className);
        Object o = aClass.newInstance();
        bankDao = (com.cx.dao.bankDaoImpl) o;

    }


    public static BeanFactory getInstance() throws Exception{
        if(instance == null){
            instance = new BeanFactory();
        }
        return instance;
    }

    public bankDao creatDao(){
       return  instance.bankDao;
    }
}
