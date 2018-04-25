package com.wsx.park.system.dao;

import com.wsx.park.system.domain.parking_system.User;
import com.wsx.park.system.mapper.parking_system.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public User getUserPasswordByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }

    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int deleteUserById(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int getNextId() {
        return userMapper.getNextId();
    }
}
