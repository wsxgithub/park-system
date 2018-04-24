package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.Park;
import java.util.List;

public interface ParkMapper {
    int insert(Park record);

    Park selectByPrimaryKey(Integer id);

    List<Park> selectAll();

    int updateByPrimaryKey(Park record);
}
