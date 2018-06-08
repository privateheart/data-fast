package io.renren.modules1.daycount.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.Date;

/**
 * 每天机器检测数量
 *
 * @author huyi
 * @create 2018/5/8 9:06
 */
public class DayCount {

    private Integer countId;
    private BigInteger sessionId;
    private BigInteger flowCount;

    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date countDate;
    private String monthDate;
    private String yearDate;

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public BigInteger getSessionId() {
        return sessionId;
    }

    public void setSessionId(BigInteger sessionId) {
        this.sessionId = sessionId;
    }

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

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    public String getYearDate() {
        return yearDate;
    }

    public void setYearDate(String yearDate) {
        this.yearDate = yearDate;
    }
}
