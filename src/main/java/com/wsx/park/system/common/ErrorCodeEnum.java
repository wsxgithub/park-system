package com.wsx.park.system.common;

public enum ErrorCodeEnum {
    UNKONW_ERROR(501, "服务器打嗝儿了，不巧被您遇上，请再试试~"),
    NOT_SUPPORT(502, "Method not support"),
    PASSWORD_INVALIDATE(503, "密码错误");

    public final int code;
    public final String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
