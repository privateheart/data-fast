package io.renren.modules.data.service.impl;

import io.renren.modules.data.dao.CustomerDao;
import io.renren.modules.data.entity.Customer;
import io.renren.modules.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
