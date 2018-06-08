package io.renren.modules1.daycount.vo;

import java.util.List;

/**
 * 机器每月检测的数量 集合
 *
 * @author huyi
 * @create 2018/6/8 9:33
 */
public class CustomerMonthCounts {

    private String customer;
    private List<MonthCount> monthCounts;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<MonthCount> getMonthCounts() {
        return monthCounts;
    }

    public void setMonthCounts(List<MonthCount> monthCounts) {
        this.monthCounts = monthCounts;
    }
}
