package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateInput {
    @NotNull(message = "用户ID不能为空")
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String carId;

    private String userType;
}
