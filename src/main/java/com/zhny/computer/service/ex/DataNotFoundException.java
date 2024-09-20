package com.zhny.computer.service.ex;

public class DataNotFoundException extends ServiceException{
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException() {
        super();
    }
}
