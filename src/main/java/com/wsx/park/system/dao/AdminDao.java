package com.wsx.park.system.dao;

import com.wsx.park.system.domain.parking_system.Admin;
import com.wsx.park.system.mapper.parking_system.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @Autowired
    private AdminMapper adminMapper;
    public Admin getAdminPasswordById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public Integer saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    public int getNextId() {
        return adminMapper.getNextId();
    }

    public Integer deleteAdminById(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

}
