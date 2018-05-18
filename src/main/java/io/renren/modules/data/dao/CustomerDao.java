package io.renren.modules.data.dao;

import io.renren.modules.data.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author huyi
 * @create 2018/5/7 9:24
 */
@Mapper
public interface CustomerDao {

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
    List<Customer> queryList(Map<String, Object> params);

    /**
     * 条件查询 机器 总条数
     * @param params
     * @return
     */
    int queryListCount(Map<String, Object> params);
}
