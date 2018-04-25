package com.wsx.park.system.service;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
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

        adminDao.saveAdmin(admin);
        int id = adminDao.getNextId();
        AdminRegisterOutput output = new AdminRegisterOutput();
        output.setAdminName(adminName);
        output.setId(id);

        return output;
    }

    public void deleteUser(Integer id) throws BusinessException{
        Admin admin = adminDao.getAdminPasswordById(id);
        if(admin == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "用户不存在");
        } else {
            admin.setIsDel((byte)1);
            adminDao.deleteAdminById(admin);
        }
    }
}
