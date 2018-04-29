package com.wsx.park.system.controller;

import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/park")
public class ParkController extends BaseController {
    @RequestMapping(value = "/car/in", method = RequestMethod.POST)
    public Response carIn() {
        return success();
    }
}
