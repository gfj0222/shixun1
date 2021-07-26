package com.cx.service;

import com.cx.Utils.AccountOverDrawnException;
import com.cx.Utils.InvalidDepositException;
import com.cx.dao.bankDao;
import com.cx.dao.bankDaoImpl;


import java.util.Properties;


public class managerServiceImpl implements ManagerService {

    private bankDao bd;
    //单例
    private static managerServiceImpl instance = null;

    private managerServiceImpl() {
        bd = new bankDaoImpl();
    }

    public static synchronized managerServiceImpl getInstance() {
        if (null == instance)
            instance = new managerServiceImpl();
        return instance;
    }


    //查询余额
    @Override
    public void inquery(Properties ps) {
        System.out.println("余额:" + ps.getProperty("money"));
    }

    @Override
    public double withdrawls(Properties ps, double save) throws InvalidDepositException {
        //存款,
            InvalidDepositException.isInvalidDeposit(save);
        double money = Double.parseDouble(ps.getProperty("money"));
        double sum = money + save;
        ps.setProperty("money", String.valueOf(sum));
        bd.saveMoney(ps);
        return 0.0;
    }

    @Override
    public double deposit(Properties ps, double get) {
        //取款超出
        Double money = Double.parseDouble(ps.getProperty("money"));
        try {
            AccountOverDrawnException.isAccountOver(money, get);
            ps.setProperty("money", String.valueOf((money - get)));
        } catch (AccountOverDrawnException e) {
            e.printStackTrace();
        } finally {
            bd.saveMoney(ps);
            return Double.parseDouble(ps.getProperty("money"));
        }

    }


    @Override
    public void exitSystem(Properties ps) {
        bd.saveMoney(ps);
        System.exit(0);
    }


    /**
     * 转账
     *
     * @param ps1
     * @param
     */
    @Override
    public void transfer(Properties ps1, String name, double money) {

        Properties flag = bd.findByName(name);
        //找到了要转账的用户
        if (flag != null) {
            double d1 = Double.parseDouble(ps1.getProperty("money"));
            double d2 = Double.parseDouble(flag.getProperty("money"));
            if (true) {
                d1 = d1 - money;
                d2 = d2 + money;
                //将金额
                ps1.setProperty("money", String.valueOf(d1));
                flag.setProperty("money", String.valueOf(d2));
                bd.saveMoney(flag);
                bd.saveMoney(ps1);
            }
        }
    }
}
