package io.renren.modules.data.service.impl;

import io.renren.modules.data.dao.CustomerDao;
import io.renren.modules.data.entity.Customer;
import io.renren.modules.data.service.CustomerService;
import io.renren.modules.data.vo.CustomerVo;
import io.renren.modules1.daycount.dao.CustomerDayCountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 机器查询
 *
 * @author huyi
 * @create 2018/5/10 9:03
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerDayCountDao customerDayCountDao;

    @Override
    public List<Customer> queryAllCustomer() {
        return customerDao.queryAllCustomer();
    }

    @Override
    public int queryAllCustomerCount() {
        return customerDao.queryAllCustomerCount();
    }

    @Override
    public List<Customer> queryCustomers(List<Integer> customerIds) {
        return customerDao.queryCustomers(customerIds);
    }

    @Override
    public List<CustomerVo> queryList(Map<String, Object> params) {
        List<CustomerVo> customers = customerDao.queryList(params);
        BigInteger totalCheck = BigInteger.ZERO;
        int i = 0;
        for (CustomerVo c : customers){
            i = customerDayCountDao.checkDayCountTableIfExists(c.getCustomerId());
            if (i>0){
                totalCheck = customerDayCountDao.queryTotalCheck(c.getCustomerId());
            }else {
                totalCheck = BigInteger.ZERO;
            }
            c.setTotalCheck(totalCheck);
        }
        return customers;
    }

    @Override
    public int queryListCount(Map<String, Object> params) {
        return customerDao.queryListCount(params);
    }

    @Override
    public BigInteger queryAllTotalCheckCount() {
        List<Customer> customers = customerDao.queryAllCustomer();
        BigInteger totalCheck = BigInteger.ZERO;
        BigInteger count = BigInteger.ZERO;
        for (Customer c : customers){
            int i = customerDayCountDao.checkDayCountTableIfExists(c.getCustomerId());
            if (i>0){
                count = customerDayCountDao.queryTotalCheck(c.getCustomerId());
            }else {
                count = BigInteger.ZERO;
            }
            totalCheck = totalCheck.add(count);
        }
        return totalCheck;
    }
}
