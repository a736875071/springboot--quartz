package com.utils.exception;

/**
 * 自定义消息异常
 *
 * @author YangQing
 *  @version 1.0.0
 */
public class MsgException extends RuntimeException {


    public MsgException() {
        super();
    }

    public MsgException(String message) {
        super(message);
    }

    public MsgException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgException(Throwable cause) {
        super(cause);
    }

    protected MsgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
