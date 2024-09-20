package com.zhny.computer.service.ex;

/**
 * 用户在更新密码时产生的异常
 *
 */
public class UpdateException extends ServiceException{
    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException() {
        super();
    }
}
