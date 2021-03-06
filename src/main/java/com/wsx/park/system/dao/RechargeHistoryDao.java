package com.wsx.park.system.dao;

import com.wsx.park.system.bean.ManageBean;
import com.wsx.park.system.domain.parking_system.RechargeHistory;
import com.wsx.park.system.mapper.parking_system.RechargeHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RechargeHistoryDao {

    @Autowired
    private RechargeHistoryMapper rechargeHistoryMapper;
    public void saveRechargeHistory(RechargeHistory rechargeHistory) {
        rechargeHistoryMapper.insert(rechargeHistory);
    }

    public List<RechargeHistory> getRechargeHistory(ManageBean bean) {
        return rechargeHistoryMapper.selectHistoryById(bean);
    }

    public int getCountById(Integer userId) {
        return rechargeHistoryMapper.getCountById(userId);
    }
}
