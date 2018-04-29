package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.bean.ChargeRuleBean;
import com.wsx.park.system.domain.parking_system.ChargeRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChargeRuleMapper {
    int insert(ChargeRule record);

    ChargeRule selectByPrimaryKey(Integer id);

    List<ChargeRule> selectAll();

    int updateByPrimaryKey(ChargeRule record);

    List<ChargeRule> selectChargeRuleLimit(ChargeRuleBean bean);

    int getCount();
}
