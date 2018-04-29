package com.wsx.park.system.dao;

import com.wsx.park.system.bean.ChargeRuleBean;
import com.wsx.park.system.domain.parking_system.ChargeRule;
import com.wsx.park.system.mapper.parking_system.ChargeRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChargeRuleDao {
    @Autowired
    private ChargeRuleMapper chargeRuleMapper;

    public void saveChargeRule(ChargeRule chargeRule) {
        chargeRuleMapper.insert(chargeRule);
    }

    public ChargeRule getById(Integer id) {
        return chargeRuleMapper.selectByPrimaryKey(id);
    }

    public void updateChargeRule(ChargeRule chargeRule) {
        chargeRuleMapper.updateByPrimaryKey(chargeRule);
    }

    public List<ChargeRule> selectChargeRuleLimit(ChargeRuleBean bean) {
        return chargeRuleMapper.selectChargeRuleLimit(bean);
    }

    public int getCount() {
        return chargeRuleMapper.getCount();
    }
}
