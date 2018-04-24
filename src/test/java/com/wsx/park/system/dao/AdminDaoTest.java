package com.wsx.park.system.dao;

import com.wsx.park.system.ParkSystemApplication;
import com.wsx.park.system.domain.parking_system.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = ParkSystemApplication.class)
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    public void testSaveAdmin() {
        Admin admin = new Admin();
        admin.setAdminname("wsx");
        admin.setPassword("123");
        admin.setIsDel((byte)0);
        int id =adminDao.saveAdimin(admin);
        assertTrue(id>0);
    }
}
