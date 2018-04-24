package com.wsx.park.system.input;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AdminLoginInput {
    @NotNull(message = "登录名不能为空")
    private Integer id;

    @NotNull(message = "密码不能为空")
    private String password;
}
