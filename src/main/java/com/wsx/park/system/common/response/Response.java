package com.wsx.park.system.common.response;

public class Response {

    final static String STATUS_SUCCESS = "success";
    final static String STATUS_FAIL = "fail";

    private String status;

    Response(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
