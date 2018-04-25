package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.Park;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkMapper {
    int insert(Park record);

    Park selectByPrimaryKey(Integer id);

    List<Park> selectAll();

    int updateByPrimaryKey(Park record);
}
