package com.zhny.computer.service.ex;

/**
 * 用户名被占用的异常
 */
public class UsernameDuplicatedException extends ServiceException {
    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException() {
        super();
    }
}
