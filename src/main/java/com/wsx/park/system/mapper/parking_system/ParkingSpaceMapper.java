package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.ParkingSpace;
import java.util.List;

public interface ParkingSpaceMapper {
    int insert(ParkingSpace record);

    ParkingSpace selectByPrimaryKey(Integer id);

    List<ParkingSpace> selectAll();

    int updateByPrimaryKey(ParkingSpace record);
}
