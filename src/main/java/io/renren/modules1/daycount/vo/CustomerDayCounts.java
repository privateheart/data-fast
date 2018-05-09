package io.renren.modules1.daycount.vo;

import io.renren.modules1.daycount.entity.DayCount;

import java.util.List;

/**
 * 机器每天检测的数量
 *
 * @author huyi
 * @create 2018/5/8 13:50
 */
public class CustomerDayCounts {

    private String customer;

    private List<DayCount> dayCounts;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<DayCount> getDayCounts() {
        return dayCounts;
    }

    public void setDayCounts(List<DayCount> dayCounts) {
        this.dayCounts = dayCounts;
    }
}
