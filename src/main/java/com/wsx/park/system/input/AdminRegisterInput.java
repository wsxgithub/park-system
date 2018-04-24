package com.wsx.park.system.input;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AdminRegisterInput {
    @NotNull(message = "用户名不能为空")
    private String adminName;

    @NotNull(message = "密码不能为空")
    private String password;
}
