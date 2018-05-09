package io.renren.common.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式(HH:mm:ss)
     */
    public final static String TIME_PATTERN = "HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static Calendar aCalendar = Calendar.getInstance();

    /**
     * 日期字符串转日期
     *
     * @param dateStr
     * @return
     */
    public static Date strFormatDate(String dateStr) {
        return format(dateStr, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 日期截取时分
     *
     * @param date
     * @return
     */
    public static Date formatToTime(Date date) {
        return format(format(date, TIME_PATTERN), TIME_PATTERN);
    }

    public static Date format(String dateStr, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期加天数
     *
     * @param date 原日期
     * @param days 天数
     * @return
     */
    public static Date addDate(Date date, Integer days) {
        Calendar specialDate = Calendar.getInstance();
        specialDate.setTime(date);
        specialDate.add(Calendar.DAY_OF_MONTH, days);
        return specialDate.getTime();
    }

    /**
     * 指定日期加上指定月数
     *
     * @param date   指定日期
     * @param months 指定月数
     * @return 新日期
     */
    public static Date addDateWithMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 指定日期加上指定分钟
     *
     * @param date    指定日期
     * @param minutes 指定分钟
     * @return 新日期
     */
    public static Date addDateWithMinute(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }


    /**
     * @param begin
     * @param end
     * @return
     */
    public static int daysBetweenDate(Date begin, Date end) {
        aCalendar.setTime(begin);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(end);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        int days = day2 - day1;
        return days;
    }

    /**
     * 获取时间小时
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取时间天
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }


    /**
     * 得到两个日期相差的小时数
     *
     * @param sDate
     * @param eDate
     * @return
     */
    public static BigDecimal hoursBetweenDate(Date sDate, Date eDate) {
        double hours = ((double) (sDate.getTime() - eDate.getTime())) / (1000 * 60 * 60);
        return new BigDecimal(Math.abs(hours));
    }
}
