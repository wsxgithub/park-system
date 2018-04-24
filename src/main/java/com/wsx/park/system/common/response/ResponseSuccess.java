package com.wsx.park.system.common.response;

public class ResponseSuccess extends Response {

    private Object content;

    public ResponseSuccess() {
        super(STATUS_SUCCESS);
    }

    public ResponseSuccess(Object content) {
        super(STATUS_SUCCESS);
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object data) {
        this.content = data;
    }
}
