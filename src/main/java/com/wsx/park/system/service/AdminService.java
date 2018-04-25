package com.wsx.park.system.service;

import com.wsx.park.system.dao.AdminDao;
import com.wsx.park.system.domain.parking_system.Admin;
import com.wsx.park.system.output.AdminRegisterOutput;
import com.wsx.park.system.utils.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public boolean adminLogin(Integer id, String password) {
        String passwordAfterEncode = DigestUtils.encodePassword(password);
        Admin admin = adminDao.getAdminPasswordById(id);
        if(admin != null && admin.getPassword().equals(passwordAfterEncode)) {
            return true;
        } else {
            return false;
        }
    }

    public AdminRegisterOutput saveAdmin(String adminName, String password) {
        String passwordAfterEncode = DigestUtils.encodePassword(password);
        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setPassword(passwordAfterEncode);
        admin.setIsDel((byte)0);

        Integer id = adminDao.saveAdmin(admin);

        AdminRegisterOutput output = new AdminRegisterOutput();
        output.setAdminName(adminName);
        output.setId(id);

        return output;
    }

}
