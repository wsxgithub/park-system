package com.wsx.park.system.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateParkingSpaceInput {
    @NotNull(message = "请输入车位ID")
    private Integer id;

    private String spaceArea;

    private Integer spaceNo;

    private String spaceType;
}
