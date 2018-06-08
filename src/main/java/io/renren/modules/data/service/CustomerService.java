package io.renren.modules.data.service;

import io.renren.modules.data.entity.Customer;
import io.renren.modules.data.vo.CustomerVo;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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

    /**
     * 条件查询 机器
     * @param params
     * @return
     */
    List<CustomerVo> queryList(Map<String, Object> params);

    /**
     * 条件查询 机器 总条数
     * @param params
     * @return
     */
    int queryListCount(Map<String, Object> params);

    /**
     * 查询所有机器总的检测数量
     * @return
     */
    BigInteger queryAllTotalCheckCount();
}
