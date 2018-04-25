package com.wsx.park.system.common.exception;

import com.wsx.park.system.common.ErrorCodeEnum;

public class BusinessException extends Exception {
    private Throwable cause = null;
    private ErrorCodeEnum errorCode = null;

    public BusinessException(Throwable cause) {
        this.cause = cause;
    }

    public BusinessException(ErrorCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCodeEnum errorCode, String message, Throwable cause) {
        super(message);
        this.cause = cause;
        this.errorCode = errorCode;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

}
