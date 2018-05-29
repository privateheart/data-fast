package io.renren.modules1.daycount.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules1.daycount.service.CustomerDayCountService;
import io.renren.modules1.daycount.vo.CustomerDayCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 机器每天统计的数量控制器
 *
 * @author huyi
 * @create 2018/5/9 9:20
 */
@RestController
@RequestMapping("/dayCounts")
public class DayCountsController {

    @Autowired
    CustomerDayCountService customerDayCountService;

    @RequestMapping("/list")
    @SysLog("查询每天每台机器的数量")
    public R list(@RequestBody Map<String,Object> params){

        List<Integer> customerIds = (List<Integer>) params.get("customerIds");

        String startDate = (String) params.get("startDate");
        String endDate =  (String) params.get("endDate");

        List<CustomerDayCounts> customerDayCounts = customerDayCountService.queryCustomerDayCounts(customerIds, startDate, endDate);

        return R.ok().put("customerDayCounts",customerDayCounts);

    }
}
