package com.wsx.park.system.service;

import com.wsx.park.system.bean.ManageBean;
import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.dao.RechargeHistoryDao;
import com.wsx.park.system.dao.UserDao;
import com.wsx.park.system.domain.parking_system.RechargeHistory;
import com.wsx.park.system.domain.parking_system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RechargeHistoryDao rechargeHistoryDao;

    public void rechargeAccount(Integer id, Double rechargeFee, int payTpye) throws BusinessException{
        User user = userDao.getUserById(id);
        if(user == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "用户不存在");
        } else {
            Double feeAfterRecharge = rechargeFee + user.getCountFee();
            user.setCountFee(feeAfterRecharge);
            user.setUpdateTime(new Date());
            userDao.updateUser(user);

            RechargeHistory rechargeHistory = new RechargeHistory();
            rechargeHistory.setUserId(user.getId());
            rechargeHistory.setCountFee(feeAfterRecharge);
            rechargeHistory.setRechargeFee(rechargeFee);
            rechargeHistory.setPayType(payTpye);
            rechargeHistoryDao.saveRechargeHistory(rechargeHistory);
        }
    }

    public List<RechargeHistory> getRechargeHistory(Integer userId, Integer pageSize, Integer pageNum) {
        ManageBean bean = new ManageBean(userId, pageSize, pageNum);
        List<RechargeHistory> historyList = rechargeHistoryDao.getRechargeHistory(bean);
        return historyList;
    }

    public int getCountById(Integer userId) {
        return rechargeHistoryDao.getCountById(userId);
    }
}
