package io.renren.modules1.daycount.service.impl;

import io.renren.common.constant.Constant;
import io.renren.common.exception.RRException;
import io.renren.modules.data.dao.CustomerDao;
import io.renren.modules.data.entity.Customer;
import io.renren.modules1.daycount.dao.CustomerDayCountDao;
import io.renren.modules1.daycount.entity.DayCount;
import io.renren.modules1.daycount.service.CustomerDayCountService;
import io.renren.modules1.daycount.vo.CustomerDayCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
    public List<CustomerDayCounts> queryCustomerDayCounts(List<Integer> customerIds, String startDate, String endDate, String dateType) {
        List<Customer> customers = null;
        if (customerIds ==null || customerIds.size()<1){
            customers = customerDao.queryAllCustomer();
        }else {
            customers = customerDao.queryCustomers(customerIds);
        }

        List<CustomerDayCounts> customerDayCounts = new ArrayList<>();
        CustomerDayCounts dayCounts = null;
        List<DayCount> counts = null;
        BigInteger total = BigInteger.ZERO;
        for (Customer c: customers) {
            int i = customerDayCountDao.checkDayCountTableIfExists(c.getCustomerId());
            if (i<1){
                throw new RRException(c.getCustomer() +" 没有检测记录！");
            }
            switch (dateType){
                case Constant.DAY :
                    counts = customerDayCountDao.queryDayCountList(c.getCustomerId(), endDate, startDate);
                    total = customerDayCountDao.queryDayTotalCount(c.getCustomerId(),endDate,startDate);
                    break;
                case Constant.MONTH :
                    counts = customerDayCountDao.queryMonthCountList(c.getCustomerId(), endDate, startDate);
                    total = customerDayCountDao.queryMonthTotalCount(c.getCustomerId(), endDate, startDate);
                    break;
                case Constant.YEAR :
                    counts = customerDayCountDao.queryYearCountList(c.getCustomerId(), endDate, startDate);
                    total = customerDayCountDao.queryYearTotalCount(c.getCustomerId(), endDate, startDate);
                    break;
                default:
                    break;
            }
            if (total.compareTo(BigInteger.ZERO) > 0) {
                dayCounts = new CustomerDayCounts();
                dayCounts.setCustomer(c.getCustomer());
                dayCounts.setDayCounts(counts);
                customerDayCounts.add(dayCounts);
            }
        }
        return customerDayCounts;
    }
}
