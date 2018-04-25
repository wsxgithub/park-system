package com.wsx.park.system.controller;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.input.AdminLoginInput;
import com.wsx.park.system.input.AdminRegisterInput;
import com.wsx.park.system.input.DeleteAdminInput;
import com.wsx.park.system.output.AdminRegisterOutput;
import com.wsx.park.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/admin")

public class AdminController extends BaseController{

    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response adminLogin(@RequestBody @Valid AdminLoginInput adminLoginInput) {
        if(adminService.adminLogin(adminLoginInput.getId(), adminLoginInput.getPassword())) {
            return success();
        } else {
            return fail(ErrorCodeEnum.PASSWORD_INVALIDATE);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response adminRegister(@RequestBody @Valid AdminRegisterInput input) {
        AdminRegisterOutput output = adminService.saveAdmin(input.getAdminName(), input.getPassword());
        return success(output);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Response deleteAdmin(@RequestBody @Valid DeleteAdminInput input) {
        try {
            adminService.deleteUser(input.getId());
            return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

}

