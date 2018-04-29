package com.wsx.park.system.service;

import com.wsx.park.system.bean.ChargeRuleBean;
import com.wsx.park.system.common.ErrorCodeEnum;
import com.wsx.park.system.common.exception.BusinessException;
import com.wsx.park.system.dao.ChargeRuleDao;
import com.wsx.park.system.domain.parking_system.ChargeRule;
import com.wsx.park.system.input.UpdateChargeRuleInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChargeRuleService {

    @Autowired
    private ChargeRuleDao chargeRuleDao;

    public void addChargeRule(String discountInfo, Byte discountType, String userType) {
        ChargeRule chargeRule = new ChargeRule();
        chargeRule.setDiscountInfo(discountInfo);
        chargeRule.setDiscountType(discountType);
        chargeRule.setUserType(userType);

        chargeRuleDao.saveChargeRule(chargeRule);
    }

    public void deleteChargeRule(Integer id) throws BusinessException {
        ChargeRule chargeRule = chargeRuleDao.getById(id);
        if(chargeRule == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "ID不存在");
        } else {
            chargeRule.setIsDel((byte)1);
            chargeRuleDao.updateChargeRule(chargeRule);
        }
    }

    public void updateChargeRule(UpdateChargeRuleInput input) throws BusinessException {
        ChargeRule chargeRule = chargeRuleDao.getById(input.getId());
        if(chargeRule == null) {
            throw new BusinessException(ErrorCodeEnum.NOT_EXIST, "ID不存在");
        } else {
            chargeRule.setUserType(input.getUserType());
            chargeRule.setDiscountType(input.getDiscountType());
            chargeRule.setDiscountInfo(input.getDiscountInfo());
            chargeRule.setUpdateTime(new Date());
            chargeRuleDao.updateChargeRule(chargeRule);
        }
    }

    public List<ChargeRule> displayChargeRule(Integer pageSize, Integer pageNum) {
        ChargeRuleBean bean = new ChargeRuleBean();
        if(pageSize != null) {
            bean.setPageSize(pageSize);
        }
        int startRow = bean.getPageSize() * (pageNum - 1);
        bean.setStartRow(startRow);
        return chargeRuleDao.selectChargeRuleLimit(bean);
    }

    public int getCount() {
        return chargeRuleDao.getCount();
    }

}
