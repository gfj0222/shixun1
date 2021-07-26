package com.cx.view;

import com.cx.service.ManagerService;
import com.cx.service.managerServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class transf extends JFrame{


        JButton jb1, jb2, jb3;  //按钮
        JLabel jlb1, jlb2, jlb3; //标签
        JTextArea jta1,jta2;    //文本框
        JTextField jtf1;
        JPanel jp1;


        public static boolean flag=true;

        public transf(Properties ps) {

            // TODO Auto-generated constructor stub
            jb1 = new JButton("确定");
            jb2 = new JButton("重置");
            //设置按钮监听
            jb1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand()=="确定")
                    {

                        try {
                            transfer(ps);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else if (e.getActionCommand()=="重置")
                    {
                        clear();
                    }
                }
            });
            jb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });


            jlb1 = new JLabel("请输入存入金额：");  //添加标签
            jlb2 = new JLabel("对方账号");

            //创建文本框
            jta1 = new JTextArea();   //转出金额
            jtf1 = new JTextField(13);

            //对方账户加入面板
            jp1 = new JPanel();
            jp1.add(jlb2);
            jp1.add(jtf1);

            //设置布局
            this.setTitle("转账");
            this.setLayout(null);
            this.setSize(300, 300);

            //创建对方账户的标签
            jp1.setBounds(20, 20, 210, 60);

            //存入标签和文本框
            jlb1.setBounds(20, 80, 200, 20);
            jta1.setBounds(20, 110, 250, 50);
            jta1.setFont(new   java.awt.Font("Dialog",   0,   15));

            //确定和重置按钮
            jb1.setBounds(60, 180, 62, 28);
            jb2.setBounds(160, 180, 62, 28);


            this.add(jp1);
            this.add(jlb1);
            this.add(jta1);
            this.add(jb1);
            this.add(jb2);

            this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

            this.setVisible(true);  //设置可见
            this.setResizable(false);    //设置不可拉伸大小

        }

        //清空账号和密码框
        private void clear()
        {
            // TODO Auto-generated method stub
            jtf1.setText("");
            jta1.setText("");    //设置为空


        }



        private void transfer(Properties ps) throws IOException {

            // TODO Auto-generated method stub
            if (jta1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
            }
            else if (jtf1.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "转入账号，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
            }
            else if(true)  //验证金额是否合法
            {
                if(true)   //验证账户是否存在
                {
                    ManagerService ms = managerServiceImpl.getInstance();
                    ms.transfer(ps,jtf1.getText(), Double.parseDouble(jta1.getText()));
                    JOptionPane.showMessageDialog(null, "转账成功，余额："+ps.getProperty("money"),"消息提示",JOptionPane.WARNING_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "账户不存在","消息提示",JOptionPane.WARNING_MESSAGE);
                    clear();
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "金额不合法","消息提示",JOptionPane.WARNING_MESSAGE);
                clear();
            }

        }

}
