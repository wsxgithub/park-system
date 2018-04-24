package com.wsx.park.system.common.response;

import com.wsx.park.system.common.ErrorCodeEnum;

public class ResponseFail extends Response {

    private Integer errCode;
    private String errMsg;

    public ResponseFail() {
        super(STATUS_FAIL);
    }

    public ResponseFail(ErrorCodeEnum error) {
        super(STATUS_FAIL);
        this.errCode = error.code;
        this.errMsg = error.msg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
