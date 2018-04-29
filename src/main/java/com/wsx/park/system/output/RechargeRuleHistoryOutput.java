package com.wsx.park.system.output;

import com.wsx.park.system.domain.parking_system.RechargeHistory;
import lombok.Data;
import java.util.List;

@Data
public class RechargeRuleHistoryOutput {
    List<RechargeHistory> rechargeHistoryList;

    int totalCount;

    int pageCount;
}
