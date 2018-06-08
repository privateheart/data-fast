package io.renren.modules.data.vo;

import java.math.BigInteger;

/**
 * 机器查询Vo
 *
 * @author huyi
 * @create 2018/6/8 15:33
 */
public class CustomerVo {

    private Integer customerId;
    private String customer;

    private BigInteger totalCheck;

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

    public BigInteger getTotalCheck() {
        return totalCheck;
    }

    public void setTotalCheck(BigInteger totalCheck) {
        this.totalCheck = totalCheck;
    }
}
