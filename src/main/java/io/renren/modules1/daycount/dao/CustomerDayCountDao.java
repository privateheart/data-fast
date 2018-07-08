package io.renren.modules1.daycount.dao;

import io.renren.modules1.daycount.entity.DayCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author huyi
 * @create 2018/5/7 9:24
 */
@Mapper
public interface CustomerDayCountDao {

    /**
     * 查询 这台机器 所有的 每天检测的数量
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    List<DayCount> queryDayCountList(@Param("customerId") int customerId, @Param("endDate") String endDate, @Param("startDate") String startDate);

    /**
     * 查询 这台机器 这段时间 所有检测的总数
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    BigInteger queryDayTotalCount(@Param("customerId") int customerId, @Param("endDate") String endDate, @Param("startDate") String startDate);

    /**
     * 某一年的 或者某几年的 每个月检测的数量
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    List<DayCount> queryMonthCountList(@Param("customerId") int customerId,@Param("endDate")String endDate, @Param("startDate") String startDate);

    /**
     * 某一年的 或者某几年的 每个月检测的数量
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    BigInteger queryMonthTotalCount(@Param("customerId") int customerId,@Param("endDate")String endDate, @Param("startDate") String startDate);

    /**
     *某一年或者某几年的  检测数量
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    List<DayCount> queryYearCountList(@Param("customerId")int customerId,@Param("endDate")String endDate, @Param("startDate") String startDate);

    /**
     *某一年或者某几年的  检测数量
     * @param customerId
     * @param endDate
     * @param startDate
     * @return
     */
    BigInteger queryYearTotalCount(@Param("customerId")int customerId,@Param("endDate")String endDate, @Param("startDate") String startDate);

    /**
     * 查询 customer_id_day_count是否存在
     * @param customerId
     * @return
     */
    int checkDayCountTableIfExists(@Param("customerId")int customerId);

    /**
     * 查询 customer 总共检查的数量
     * @param params
     * @return
     */
    BigInteger queryTotalCheck(Map<String, Object> params);
}
