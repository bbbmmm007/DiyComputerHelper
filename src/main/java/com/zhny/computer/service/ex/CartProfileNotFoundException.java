package com.zhny.computer.service.ex;

//用户购物车查询不到的异常
public class CartProfileNotFoundException extends ServiceException{
    public CartProfileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected CartProfileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CartProfileNotFoundException(Throwable cause) {
        super(cause);
    }

    public CartProfileNotFoundException(String message) {
        super(message);
    }

    public CartProfileNotFoundException() {
        super();
    }
}
