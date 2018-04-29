package com.wsx.park.system.controller;

import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.domain.parking_system.ChargeRule;
import com.wsx.park.system.input.AddChargeRuleInput;
import com.wsx.park.system.input.IdInput;
import com.wsx.park.system.input.UpdateChargeRuleInput;
import com.wsx.park.system.output.DisplayChargeRuleOutput;
import com.wsx.park.system.service.ChargeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/charge/rule")
public class ChargeRuleController extends BaseController {
    @Autowired
    private ChargeRuleService chargeRuleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addChargeRule(@RequestBody @Valid AddChargeRuleInput input) {
        chargeRuleService.addChargeRule(input.getDiscountInfo(), input.getDiscountType(), input.getUserType());
        return success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Response deleteChargeRule(@RequestBody @Valid IdInput input) {
        try {
            chargeRuleService.deleteChargeRule(input.getId());
            return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Response updateChargeRule(@RequestBody @Valid UpdateChargeRuleInput input) {
        try {
            chargeRuleService.updateChargeRule(input);
            return success();
        } catch (BusinessException e) {
            return fail(e.getErrorCode());
        }
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public Response displayChargeRule(Integer pageSize, Integer pageNum) {
        List<ChargeRule> chargeRuleList = chargeRuleService.displayChargeRule(pageSize, pageNum);
        DisplayChargeRuleOutput displayChargeRuleOutput = new DisplayChargeRuleOutput();
        displayChargeRuleOutput.setChargeRuleList(chargeRuleList);
        displayChargeRuleOutput.setPageCount(chargeRuleList.size());
        displayChargeRuleOutput.setTotalCount(chargeRuleService.getCount());
        return success(displayChargeRuleOutput);
    }
}
