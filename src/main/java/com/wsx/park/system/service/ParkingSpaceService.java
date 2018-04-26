package com.wsx.park.system.service;

import com.wsx.park.system.dao.ParkingSpaceDao;
import com.wsx.park.system.domain.parking_system.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
