package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.domain.parking_system.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
