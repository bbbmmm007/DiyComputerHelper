package com.zhny.computer.service.ex;

public class PasswordOldAndNewMatchException extends ServiceException{
    public PasswordOldAndNewMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    protected PasswordOldAndNewMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PasswordOldAndNewMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordOldAndNewMatchException(String message) {
        super(message);
    }

    public PasswordOldAndNewMatchException() {
        super();
    }
}
