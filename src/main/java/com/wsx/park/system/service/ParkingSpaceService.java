package com.wsx.park.system.service;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.dao.ParkingSpaceDao;
import com.wsx.park.system.domain.parking_system.ParkingSpace;
import com.wsx.park.system.input.UpdateParkingSpaceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkingSpaceService {

    @Autowired
    private ParkingSpaceDao parkingSpaceDao;
    public void addParkingSpace(String spaceType, String spaceArea, int spaceNo) {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setStationType(spaceType);
        parkingSpace.setStationArea(spaceArea);
        parkingSpace.setStationNo(spaceNo);

        parkingSpaceDao.saveParkingSpace(parkingSpace);
    }

    public void updateParkingSpace(UpdateParkingSpaceInput input) throws BusinessException {
        if(parkingSpaceDao.selectParkingSpaceById(input.getId()) == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "ID不存在");
        }
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(input.getId());
        parkingSpace.setStationType(input.getSpaceType());
        parkingSpace.setStationArea(input.getSpaceArea());
        parkingSpace.setStationNo(input.getSpaceNo());
        parkingSpace.setUpdateTime(new Date());
        parkingSpaceDao.updateParkingSpace(parkingSpace);
    }

    public void deleteParkingSpace(Integer id)throws BusinessException {
        ParkingSpace parkingSpace = parkingSpaceDao.selectParkingSpaceById(id);
        if (parkingSpace == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "ID不存在");
        } else {
            parkingSpace.setIsDel((byte) 1);
        }
    }
}
