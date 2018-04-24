package com.wsx.park.system.common.mvc;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.common.response.ResponseFail;
import com.wsx.park.system.common.response.ResponseSuccess;

public class BaseController {

    // 成功，但没有返回内容
    protected Response success() {
        return new ResponseSuccess();
    }

    // 成功，且有出参
    protected Response success(Object content) {
        return new ResponseSuccess(content);
    }

    protected Response fail() {
        return new ResponseFail();
    }

    // 失败，出错码和错误提示
    protected Response fail(ErrorCodeEnum error) {
        return new ResponseFail(error);
    }
}
