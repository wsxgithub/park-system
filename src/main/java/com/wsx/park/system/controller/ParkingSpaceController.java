package com.wsx.park.system.controller;

import com.wsx.park.system.common.mvc.BaseController;
import com.wsx.park.system.common.response.Response;
import com.wsx.park.system.constants.TypeConstants;
import com.wsx.park.system.dao.ParkingSpaceDao;
import com.wsx.park.system.input.AddParkingSpaceInput;
import com.wsx.park.system.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/parking/space")
public class ParkingSpaceController extends BaseController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Response addParkingSpace(@RequestBody @Valid AddParkingSpaceInput input) {
        if(input.getSpaceType().isEmpty()) {
            input.setSpaceType(TypeConstants.COMMON_SPACE);
        }
        if(input.getSpaceArea().isEmpty()) {
           input.setSpaceArea(TypeConstants.UNKOWN);
        }
        if(input.getSpaceNo() == null) {
            input.setSpaceNo(0);
        }
        parkingSpaceService.addParkingSpace(input.getSpaceType(), input.getSpaceArea(), input.getSpaceNo());
        return success();
    }

}
