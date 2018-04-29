package com.wsx.park.system.output;

import com.wsx.park.system.domain.parking_system.ChargeRule;
import lombok.Data;

import java.util.List;

@Data
public class DisplayChargeRuleOutput {
    List<ChargeRule> chargeRuleList;

    int totalCount;

    int pageCount;
}
