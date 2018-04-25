package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeleteUserInput {
    @NotNull(message = "请输入用户id")
    private Integer id;
}
