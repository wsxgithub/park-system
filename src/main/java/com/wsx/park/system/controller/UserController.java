package com.wsx.park.system.controller;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.input.UserLoginInput;
import com.wsx.park.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response userLogin(@RequestBody @Valid UserLoginInput input) {
        if(userService.userLogin(input.getPhone(), input.getPassword())) {
            return success();
        } else {
            return fail(ErrorCodeEnum.PASSWORD_INVALIDATE);
        }
    }

}
