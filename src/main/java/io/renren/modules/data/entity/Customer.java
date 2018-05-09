package io.renren.modules.data.entity;

/**
 * 机器实体类
 *
 * @author huyi
 * @create 2018/5/8 11:11
 */
public class Customer {

    private Integer customerId;
    private String customer;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
