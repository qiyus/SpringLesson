package com.vigor.web.exception;

/**
 * Created by Vigor on 2017/10/15.
 * 统一异常处理
 */
public class UserEmptyException extends Exception{
    public UserEmptyException(String message) {
        super(message);
    }
}
