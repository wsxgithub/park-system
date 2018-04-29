package com.wsx.park.system.bean;

import lombok.Data;

@Data
public class ManageBean {
    int userId;
    int pageSize;
    int startRow;

    public ManageBean(int userId, int pageSize, int pageNum) {
        this.userId = userId;
        this.pageSize = pageSize;
        this.startRow = (pageNum - 1) * pageSize;
    }
}
