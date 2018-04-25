package com.wsx.park.system.common;

public enum ErrorCodeEnum {
    UNKONW_ERROR(501, "服务器打嗝儿了，不巧被您遇上，请再试试~"),
    NOT_SUPPORT(502, "Method not support"),
    PASSWORD_INVALIDATE(503, "密码错误"),
    SAVE_FAILURE(504, "失败，请重试"),
    ALREADY_EXITS(505, "该用户已存在，请直接登录"),
    REQUEST_PARAM(506, "请检查输入参数"),
    NOT_EXIST(507, "用户不存在，请确认后再删除");


    public final int code;
    public final String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
