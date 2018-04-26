package com.wsx.park.system.mapper.parking_system;

import com.wsx.park.system.bean.PageHelperBean;
import com.wsx.park.system.domain.parking_system.RechargeHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RechargeHistoryMapper {
    int insert(RechargeHistory record);

    RechargeHistory selectByPrimaryKey(Integer id);

    List<RechargeHistory> selectAll();

    int updateByPrimaryKey(RechargeHistory record);

    List<RechargeHistory> selectHistoryById(PageHelperBean bean);
}
