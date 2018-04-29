package com.wsx.park.system.dao;

import com.wsx.park.system.domain.parking_system.ParkingSpace;
import com.wsx.park.system.mapper.parking_system.ParkingSpaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingSpaceDao {
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;

    public void saveParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaceMapper.insert(parkingSpace);
    }

    public void updateParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaceMapper.updateByPrimaryKey(parkingSpace);
    }

    public void deleteParckingSpace(ParkingSpace parkingSpace) {
        parkingSpaceMapper.updateByPrimaryKey(parkingSpace);
    }

    public ParkingSpace selectParkingSpaceById(Integer id) {
        return parkingSpaceMapper.selectByPrimaryKey(id);
    }
}
