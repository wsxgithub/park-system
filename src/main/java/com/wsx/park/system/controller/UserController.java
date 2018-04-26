package com.wsx.park.system.controller;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.constants.TypeConstants;
import com.wsx.park.system.domain.parking_system.User;
import com.wsx.park.system.input.IdInput;
import com.wsx.park.system.input.UserLoginInput;
import com.wsx.park.system.input.UserRegisterInput;
import com.wsx.park.system.input.UserUpdateInput;
import com.wsx.park.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Response userRegister(@RequestBody @Valid UserRegisterInput input) {
        if(input.getUserType().isEmpty()) {
            input.setUserType(TypeConstants.DOMESTIC_USER);
        }
        try {
            User output = userService.saveUser(input);
            if(output != null) {
                return success(output);
            } else {
                return fail(ErrorCodeEnum.SAVE_FAILURE);
            }
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Response deleteUser(@RequestBody @Valid IdInput input) {
        try {
            userService.deleteUser(input.getId());
            return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Response updateUser(@RequestBody @Valid UserUpdateInput input) {
        try {
            userService.updateUser(input);
            return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }
}
