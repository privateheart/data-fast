package io.renren.modules1.daycount.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * 机器每月的数量
 *
 * @author huyi
 * @create 2018/6/8 9:33
 */
public class MonthCount {

    private BigInteger flowCount;
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM")
    private Date countDate;

    public BigInteger getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(BigInteger flowCount) {
        this.flowCount = flowCount;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }
}
