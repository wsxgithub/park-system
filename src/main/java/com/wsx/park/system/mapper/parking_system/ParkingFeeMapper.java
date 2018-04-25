package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.ParkingFee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingFeeMapper {
    int insert(ParkingFee record);

    ParkingFee selectByPrimaryKey(Integer id);

    List<ParkingFee> selectAll();

    int updateByPrimaryKey(ParkingFee record);

}
