package com.wsx.park.system.dao;

import com.wsx.park.system.domain.parking_system.Admin;
import com.wsx.park.system.mapper.parking_system.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @Autowired AdminMapper adminMapper;
    public Admin getAdminPasswordbyId(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public Integer saveAdimin(Admin admin) {
        return adminMapper.insert(admin);
    }
}
