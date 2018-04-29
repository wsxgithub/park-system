package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateChargeRuleInput {
    @NotNull(message = "请输入ID")
    private Integer id;

    private String userType;

    private Byte discountType;

    private String discountInfo;

}
