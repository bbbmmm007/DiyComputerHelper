package com.zhny.computer.service.ex;

/**
 * 数据在插入时的异常
 */
public class InsertException extends ServiceException{
    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException() {
        super();
    }
}
