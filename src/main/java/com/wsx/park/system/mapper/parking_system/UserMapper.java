package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByPhone(String phone);

    Integer getNextId();
}
