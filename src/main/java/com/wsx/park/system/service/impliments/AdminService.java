package com.wsx.park.system.service.impliments;

import com.wsx.park.system.dao.AdminDao;
import com.wsx.park.system.domain.parking_system.Admin;
import com.wsx.park.system.output.AdminRegisterOutput;
import com.wsx.park.system.service.IAdminServiceImpl;
import com.wsx.park.system.utils.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminServiceImpl {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean adminLogin(Integer id, String password) {
        String passwordAfterEncode = DigestUtils.encodePassword(password);
        Admin admin = adminDao.getAdminPasswordbyId(id);
        if(admin != null && admin.getPassword().equals(passwordAfterEncode)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AdminRegisterOutput saveAdmin(String adminName, String password) {
        String passwordAfterEncode = DigestUtils.encodePassword(password);
        Admin admin = new Admin();
        admin.setAdminname(adminName);
        admin.setPassword(passwordAfterEncode);
        admin.setIsDel((byte)0);

        Integer id = adminDao.saveAdimin(admin);

        AdminRegisterOutput output = new AdminRegisterOutput();
        output.setAdminName(adminName);
        output.setId(id);

        return output;
    }

}
