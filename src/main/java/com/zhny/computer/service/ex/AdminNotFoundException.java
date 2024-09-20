package com.zhny.computer.service.ex;

public class AdminNotFoundException extends ServiceException{
    public AdminNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected AdminNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AdminNotFoundException(Throwable cause) {
        super(cause);
    }

    public AdminNotFoundException(String message) {
        super(message);
    }

    public AdminNotFoundException() {
        super();
    }
}
