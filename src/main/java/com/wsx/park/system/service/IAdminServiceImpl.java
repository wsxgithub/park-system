package com.wsx.park.system.service;

import com.wsx.park.system.output.AdminRegisterOutput;

public interface IAdminServiceImpl {
    boolean adminLogin(Integer id, String password);

    AdminRegisterOutput saveAdmin(String adminName, String password);
}
