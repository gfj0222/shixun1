package com.cx.view;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class Menu extends JFrame {

    JButton jb1, jb2, jb3, jb4;  //创建按钮

    public Menu(Properties ps) {
        jb1 = new JButton("查询");
        jb2 = new JButton("存款");
        jb3 = new JButton("取款");
        jb4 = new JButton("转账");


        //查询
        jb1.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      if (e.getSource() == jb1) {
                                          String money = ps.getProperty("money");
                                          System.out.println("现存金额："+ money);
                                          JOptionPane.showMessageDialog(null, "现存金额："+money,
                                                  "余额", JOptionPane.ERROR_MESSAGE);
                                      }
                                  }
                              }
        );

        //存款
        jb2.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      if (e.getSource() == jb2) {
                                          new Save(ps);
                                      }
                                  }
                              }
        );


        //取款
        jb3.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      if (e.getSource() == jb3) {
                                          new DrawMoney(ps);
                                      }
                                  }
                              }
        );

        //转账
        jb4.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      if (e.getSource() == jb4) {
                                        new transf(ps);
                                      }
                                  }
                              }
        );




        this.setTitle("银行管理管理系统");  //设置窗体标题
        this.setSize(450, 500);         //设置窗体大小
        this.setLocation(400, 200);     //设置位置
        this.setLayout(null);           //设置布局，不采用布局

        //设置按钮的位置和大小
        jb1.setBounds(0, 50, 90, 60);
        jb2.setBounds(0, 150, 90, 60);
        jb3.setBounds(0, 250, 90, 60);
        jb4.setBounds(354, 50, 90, 60);



        this.add(jb1);   //加入窗体
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置可关闭

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小
    }


}

