package com.wsx.park.system.controller;

import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.domain.parking_system.RechargeHistory;
import com.wsx.park.system.input.RechargeInput;
import com.wsx.park.system.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/manage")
public class manageController extends BaseController {

    @Autowired
    private ManageService manageService;

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public Response rechargeAccount(@RequestBody @Valid RechargeInput input) {
        try{
           manageService.rechargeAccount(input.getId(), input.getRechargeFee(), input.getPayType());
           return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

    @RequestMapping(value = "/get/recharge/history", method = RequestMethod.GET)
    public Response getRechargeHistory(@RequestParam Integer userId, Integer pageSize, Integer pageNum) {
            List<RechargeHistory> historyList = manageService.getRechargeHistory(userId, pageSize, pageNum);
            return success(historyList);
    }


}
