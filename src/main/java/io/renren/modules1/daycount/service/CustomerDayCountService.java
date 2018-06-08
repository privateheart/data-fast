package io.renren.modules1.daycount.service;

import io.renren.modules1.daycount.vo.CustomerDayCounts;

import java.util.List;

/**
 * @author huyi
 */
public interface CustomerDayCountService {

    /**
     * 查询 机器每天的检测数量
     * @param customerIds
     * @param startDate
     * @param endDate
     * @param dateType
     * @return
     */
    List<CustomerDayCounts> queryCustomerDayCounts(List<Integer> customerIds, String startDate, String endDate, String dateType);

}
