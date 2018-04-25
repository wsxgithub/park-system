package com.wsx.park.system.service;

import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.dao.UserDao;
import com.wsx.park.system.domain.parking_system.User;
import com.wsx.park.system.input.UserRegisterInput;
import com.wsx.park.system.utils.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean userLogin(String phone, String password) {
        String passwordAfterEncode = DigestUtils.encodePassword(password);
        User user = userDao.getUserPasswordByPhone(phone);
        if(user != null && user.getPassword().equals(passwordAfterEncode) && user.getIsDel() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public User saveUser(UserRegisterInput input) throws BusinessException{

        if(userDao.getUserPasswordByPhone(input.getPhone()) == null) {
            String passwordAfterEncode = DigestUtils.encodePassword(input.getPassword());

            User user = new User();
            user.setCarId(input.getCarId());
            user.setCountFee((double) 0);
            user.setPassword(passwordAfterEncode);
            user.setPhone(input.getPhone());
            user.setUsername(input.getName());
            user.setUserType(input.getUserType());

            userDao.saveUser(user);
            return userDao.getUserPasswordByPhone(input.getPhone());
        }else {
            throw new BusinessException(ErrorCodeEnum.ALREADY_EXITS, "用户已注册");
        }
    }

    public void deleteUser(Integer id) throws BusinessException{
        User user = userDao.getUserById(id);
        if(user == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "用户不存在");
        } else {
            user.setIsDel((byte)1);
            userDao.deleteUserById(user);
        }
    }

    public void updateUser(UserRegisterInput input) throws BusinessException {
        if(userDao.getUserPasswordByPhone(input.getPhone()) == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "用户不存在");
        } else {
            String passwordAfterEncode = DigestUtils.encodePassword(input.getPassword());

            User user = new User();
            user.setCarId(input.getCarId());
            user.setCountFee((double) 0);
            user.setPassword(passwordAfterEncode);
            user.setPhone(input.getPhone());
            user.setUsername(input.getName());
            user.setUserType(input.getUserType());

            userDao.updateUser(user);
        }

    }
}
