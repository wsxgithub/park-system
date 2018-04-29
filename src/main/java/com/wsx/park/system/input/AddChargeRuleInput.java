package com.wsx.park.system.input;

import lombok.Data;

@Data
public class AddChargeRuleInput {
    private String userType;

    private Byte discountType;

    private String discountInfo;
}
