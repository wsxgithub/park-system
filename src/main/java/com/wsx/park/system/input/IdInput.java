package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IdInput {
    @NotNull(message = "请输入ID")
    private Integer id;
}
