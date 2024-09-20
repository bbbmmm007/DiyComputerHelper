package com.zhny.computer.service.ex;

/**
 * 密码不匹配异常
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException() {
        super();
    }
}
