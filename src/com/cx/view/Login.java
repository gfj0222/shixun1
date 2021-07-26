package com.cx.view;

import com.cx.dao.bankDao;
import com.cx.service.UserService;
import com.cx.service.userServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;


public class Login extends JFrame {
    private bankDao bd;

    private JPanel contentPane;

    private JButton btn1, btn2, btn3;

    private JTextField userName;

    private JPasswordField password;

    private JLabel label1, label2;

    private int LOGIN_WIDTH = 360;

    private int LOGIN_HEIGTH = 350;



    public Login() {

        UserService us = userServiceImpl.getInstance();

        setTitle("银行登入系统");  //设置窗体标题

        setBounds(100, 50, LOGIN_WIDTH, LOGIN_HEIGTH);  //设置窗体坐标以及打下

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置窗体可关闭

        setResizable(false);  //设置窗体大小不可以改变



        contentPane = new JPanel();

        contentPane.setBackground(Color.WHITE);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);

//账号标签

        label1 = new JLabel("账号");

        label1.setBounds(80, 76, 54, 28);

        //label1.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));

        contentPane.add(label1);

//密码标签

        label2 = new JLabel("密码");

        label2.setBounds(80, 135, 54, 28);

     //   label2.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png")));

        contentPane.add(label2);

//账号输入框

        userName = new JTextField();

        userName.setBounds(139, 80, 161, 25);

        contentPane.add(userName);

//密码输入框

        password = new JPasswordField();

        password.setBounds(139, 140, 161, 25);

        contentPane.add(password);

//按钮—登录

        btn1 = new JButton("登入");

        btn1.setBounds(95, 210, 80, 23);



        btn1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    Properties ps = us.login(userName.getText(),password.getText());

                    if(ps != null){
                        dispose();//关闭登录窗体
                        new Menu(ps);
                    }else {
                        JOptionPane.showMessageDialog(contentPane, "登入错误信息~",
                                "账号或密码错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

        contentPane.add(btn1);

//按钮—退出

        btn2 = new JButton("退出");

        btn2.setBounds(210, 210, 80, 23);


        btn2.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn2) {
                    us.exitSystem();
                    dispose();

                }

            }

        });

        contentPane.add(btn2);

//按钮-注册

        btn3 = new JButton("注册");

        btn3.setBounds(95, 240, 200, 23);


        btn3.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();//关闭登录窗体

                new Register(); // 打开注册窗体

            }

        });

        contentPane.add(btn3);
        setVisible(true);    //设置窗体可见
    }

    public static void main(String[] args) {
       new  Login();
    }
}



