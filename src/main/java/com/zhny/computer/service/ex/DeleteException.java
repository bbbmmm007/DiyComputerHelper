package com.zhny.computer.service.ex;

//删除数据时产生的异常
public class DeleteException extends ServiceException{
    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException() {
        super();
    }
}
