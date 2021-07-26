package com.cx.view;

import com.cx.service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import com.cx.service.userServiceImpl;

public class Register extends JFrame {
    private int LOGIN_WIDTH = 360;

    private int LOGIN_HEIGTH = 350;

    private JPanel contentPane;

    private JTextField userName;

    private JPasswordField password;

    private JButton btn3, btn4;

    private JLabel label3, label4;



    public Register() {

        UserService us = userServiceImpl.getInstance();

        setTitle("银行账号注册");

        setBounds(100, 50, LOGIN_WIDTH, LOGIN_HEIGTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);



//设置窗体标题图标

       /* setIconImage(

                Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/log.jpg"))

        );*/

/**
 * 添加一个面板容器到窗体中

 */

        contentPane = new JPanel();

        contentPane.setBackground(Color.WHITE);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);

//账号标签

        label3 = new JLabel("账号");

        label3.setBounds(80, 76, 54, 28);

      //  label3.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));

        contentPane.add(label3);

//密码标签

        label4 = new JLabel("密码");

        label4.setBounds(80, 135, 54, 28);

     //   label4.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png")));

        contentPane.add(label4);

//账号输入框

        userName = new JTextField();

        userName.setBounds(139, 80, 161, 25);

        contentPane.add(userName);

//密码输入框

        password = new JPasswordField();

        password.setBounds(139, 140, 161, 25);

        contentPane.add(password);

        btn3 = new JButton("注册");

        btn3.setBounds(95, 210, 80, 23);

        //btn3.setIcon(new ImageIcon(Login.class.getResource("/images/insist.png")));

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn3) {

                 Properties ps =  us.register(userName.getText(), password.getText());

                if(ps == null){
                    JOptionPane.showMessageDialog(contentPane, "用户名已注册~",
                            "注册信息错误", JOptionPane.ERROR_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "注册成功!");
                    dispose();  //关闭注册窗
                    new Login();  //打开登录窗体
                }

                }
            }
        });

        contentPane.add(btn3);

        btn4 = new JButton("退出");

        btn4.setBounds(210, 210, 80, 23);

       // btn4.setIcon(new ImageIcon(Login.class.getResource("/images/exit.png")));

        btn4.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn4) {
                    dispose();
                }

            }

        });

        contentPane.add(btn4);
        setVisible(true);
    }
}


