package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RechargeInput {
    @NotNull(message = "用户ID不能为空")
    private Integer id;

    @NotNull(message = "充值金额不能为空")
    private Double rechargeFee;

    private Integer payType;
}
