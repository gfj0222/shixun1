package com.cx.Utils;

import com.cx.pojo.Money;

/**
 * 取款超出时异常
 */
public class AccountOverDrawnException extends Exception {

    private String message;

    public AccountOverDrawnException(String message) {
        super(message);
    }

    public static void isAccountOver(double money,double get) throws AccountOverDrawnException {
        if((money-get)<0){
            throw new AccountOverDrawnException("余额不足");
        }
    }
}
