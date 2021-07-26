package com.cx.view;

import com.cx.Utils.InvalidDepositException;
import com.cx.service.ManagerService;
import com.cx.service.managerServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class Save extends JFrame {



        JButton jb1, jb2, jb3;  //按钮
        JLabel jlb1, jlb2, jlb3; //标签
        JTextArea jta1,jta2;

        public Save(Properties ps) {

            // TODO Auto-generated constructor stub
            jb1 = new JButton("确定");
            jb2 = new JButton("重置");
            //设置按钮监听
            jb1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if (e.getActionCommand()=="确定")
                    {

                        try {
                            savemoney(ps);   //将存入金额传入判断是否合法
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    else if (e.getActionCommand()=="重置")
                    {
                        clear();
                    }

                }
            });



            jlb1 = new JLabel("请输入存入金额：");  //添加标签

            //创建文本框
            jta1 = new JTextArea();
            jta2 = new JTextArea();


            //设置布局
            this.setTitle("存钱");
            this.setLayout(null);
            this.setSize(300, 300);

            //存入标签和文本框
            jlb1.setBounds(5, 20, 200, 20);
            jta1.setBounds(20, 50, 250, 50);
            jta1.setFont(new   java.awt.Font("Dialog",   0,   15)); //设置字体为字形， 不加粗，15号字体

            //确定和重置按钮
            jb1.setBounds(60, 120, 62, 28);
            jb2.setBounds(160, 120, 62, 28);

            //显示结果文本框
            //jlb1.setBounds(5, 20, 200, 20);
            jta2.setBounds(20, 160, 300, 50);
            jta2.setFont(new   java.awt.Font("Dialog",   1,   15));
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

        }

        //清空余额框和存钱框
        private void clear()
        {
            // TODO Auto-generated method stub
            jta1.setText("");    //设置为空
            jta2.setText("");

        }

        private void savemoney(Properties ps) throws IOException {
            // TODO Auto-generated method stub
            if (jta1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
            }
            else if(true)  //验证金额是否合法
            {
                //将账户和金额传入， 进行存储
                double nowmoney = Double.parseDouble(jta1.getText());
                if (nowmoney>0)
                {
                    ManagerService managerService = managerServiceImpl.getInstance();
                    //取钱
                    try {
                        managerService.withdrawls(ps,nowmoney);
                    } catch (InvalidDepositException e) {
                        e.printStackTrace();
                    }
                    double money1 = Double.parseDouble(ps.getProperty("money"));
                    jta2.setText("您的余额为:\n "+money1);
                    jta1.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "存入金额不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
            }

        }


}

