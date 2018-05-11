package io.renren.modules.data.service;

import io.renren.modules.data.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * 查询 所有的机器
     * @return
     */
    List<Customer> queryAllCustomer();

    /**
     * 查询所有机器的总数
     * @return
     */
    int queryAllCustomerCount();

    /**
     * 根据 id 查询机器
     * @param customerIds
     * @return
     */
    List<Customer> queryCustomers(List<Integer> customerIds);
}
