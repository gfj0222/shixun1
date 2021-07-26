package com.cx.Utils;

/**
 * 存款负数异常
 */
public class InvalidDepositException extends Exception{
    private String message;

    public InvalidDepositException(String message){
        this.message = message;
    }

    public static void isInvalidDeposit(double save) throws InvalidDepositException {
        if(save < 0){
            throw new InvalidDepositException("存款不能为负数");
        }
    }
}
