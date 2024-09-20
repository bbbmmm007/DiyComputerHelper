package com.zhny.computer.service.ex;


//商品找不到的异常
public class ProductNotFoundException extends ServiceException{
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
        super();
    }
}
