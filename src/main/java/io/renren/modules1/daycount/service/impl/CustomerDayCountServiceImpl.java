package io.renren.modules1.daycount.service.impl;

import io.renren.modules.data.dao.CustomerDao;
import io.renren.modules.data.entity.Customer;
import io.renren.modules1.daycount.dao.CustomerDayCountDao;
import io.renren.modules1.daycount.entity.DayCount;
import io.renren.modules1.daycount.service.CustomerDayCountService;
import io.renren.modules1.daycount.vo.CustomerDayCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 机器检测每天检测数量查询
 *
 * @author huyi
 * @create 2018/5/8 14:01
 */
@Service("CustomerDayCountService")
public class CustomerDayCountServiceImpl implements CustomerDayCountService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerDayCountDao customerDayCountDao;

    @Override
    public List<CustomerDayCounts> queryCustomerDayCounts(List<Integer> customerIds, String startDate, String endDate) {
        List<Customer> customers = null;
        if (customerIds ==null || customerIds.size()<1){
            customers = customerDao.queryAllCustomer();
        }else {
            customers = customerDao.queryCustomers(customerIds);
        }

        List<CustomerDayCounts> customerDayCounts = new ArrayList<>();
        CustomerDayCounts dayCounts = null;
        List<DayCount> counts = null;
        for (Customer c: customers) {
            dayCounts = new CustomerDayCounts();
            counts = customerDayCountDao.queryDayCountList(c.getCustomerId(), endDate, startDate);
            dayCounts.setCustomer(c.getCustomer());
            dayCounts.setDayCounts(counts);
            customerDayCounts.add(dayCounts);
        }

        return customerDayCounts;
    }
}
