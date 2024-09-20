package com.zhny.computer.service.ex;


//设置默认地址时非法访问的异常
public class AccessDeniedException extends ServiceException {
    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException() {
        super();
    }
}
