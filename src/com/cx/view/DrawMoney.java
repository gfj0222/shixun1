package com.cx.view;


import com.cx.service.ManagerService;
import com.cx.service.managerServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class DrawMoney extends JFrame {
    String countname;
    JButton jb1, jb2, jb3;  //按钮
    JLabel jlb1, jlb2, jlb3; //标签
    JTextArea jta1, jta2;

    public DrawMoney(Properties ps) {
        this.countname = countname;

        // TODO Auto-generated constructor stub
        jb1 = new JButton("确定");
        jb2 = new JButton("重置");
        //设置按钮监听


        jlb1 = new JLabel("请输入取出金额：");  //添加标签

        //创建文本框
        jta1 = new JTextArea();
        jta2 = new JTextArea();


        //设置布局
        this.setTitle("取钱");
        this.setLayout(null);
        this.setSize(300, 300);

        //存入标签和文本框
        jlb1.setBounds(5, 20, 200, 20);
        jta1.setBounds(20, 50, 250, 50);
        jta1.setFont(new java.awt.Font("Dialog", 0, 15));

        //确定和重置按钮
        jb1.setBounds(60, 120, 62, 28);
        jb2.setBounds(160, 120, 62, 28);

        //显示结果文本框
        //jlb1.setBounds(5, 20, 200, 20);
        jta2.setBounds(20, 160, 300, 50);
        jta2.setFont(new java.awt.Font("Dialog", 1, 15));
        //jta2.setText("您的余额为:\n ");

        this.add(jlb1);
        this.add(jta1);
        this.add(jb1);
        this.add(jb2);
        this.add(jta2);

        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);    //设置不可拉伸大小


/*
        //清空账号和密码框
        private void clear()
        {
            // TODO Auto-generated method stub
            jta1.setText("");    //设置为空
            jta2.setText("");

        }*/

        jb1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                double money = Double.parseDouble(ps.getProperty("money"));
                if (e.getSource() == jb1) {
                    //
                    // TODO Auto-generated method stub
                    if (jta1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "金额为空，请重新输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
                    } else if (true) {
                        double nowmoney = Double.parseDouble(jta1.getText());
                        if (nowmoney < money) {
                            ManagerService managerService = managerServiceImpl.getInstance();
                            //取钱
                            managerService.deposit(ps, nowmoney);
                            jta2.setText("您的余额为:\n " + ps.getProperty("money"));
                            jta1.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "余额不足请重新输入:", "消息提示", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "存入金额不合法!", "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }

        });


    }
}
