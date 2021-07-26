package com.cx.Utils;

import com.cx.dao.bankDaoImpl;

import java.io.*;
import java.util.Properties;

/**
 * 找不到就返回null，找到了返回找到的properties文件
 */
//filter all properties
public class fFilter {
    public static Properties filterFile(String name)  {

        Properties ps = null;
    File file = new File("F:\\shixun1\\src");
    File[] files = file.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".properties")
                    && pathname.isFile();
        }
    });
        for (File file1 : files) {
            if(file1.getName().equals(name+".properties")) {
                ps = new Properties();
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file1.getAbsoluteFile());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    ps.load(fileInputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    return ps;
                }
            }
    }
        return null;
        }
}