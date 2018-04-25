package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteAdminInput {
    @NotNull(message = "请输入管理员ID")
    private Integer id;
}
