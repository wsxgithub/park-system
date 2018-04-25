package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRegisterInput {
    @NotNull(message = "用户名不能为空")
    private String name;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "电话号码不能为空")
    private String phone;

    @NotNull(message = "车牌号不能为空")
    private String carId;

    private String userType;
}
