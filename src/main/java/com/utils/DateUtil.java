package com.utils;

import com.service.cm.quartz.enums.QuartzEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author YangQing
 * @version 1.0.0
 */

public class DateUtil {
    private static final long serialVersionUID = 1L;
    /**
     * 英文简写（默认）如：2015-11-09
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 英文全称，无秒针  如：2015-11-09 12:10
     */
    public static String FORMAT_NO_SECOND = "yyyy-MM-dd HH:mm";

    /**
     * 英文全称  如：2015-11-09 12:10:08
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 英文全称，无秒针  如：2015-11-09 12:10
     */
    public static String FORMAT_NO_SECOND_CN = "yyyy-MM-dd HH:mm";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 中文简写  如：2015年11月09日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称  如：2015年11月09日  12时10分08秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间  如：2015年11月09日  12时10分08秒335毫秒
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 将指定格式的字符串转换为时间
     */
    public static Date parse(String dateString, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将时间转换为指定格式的字符串
     */
    public static String format(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 将时间戳转换为指定格式的字符串
     */
    public static String format(Long date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date(date));
    }

    /**
     * 获取指定时间的当天0点
     */
    public static Date getFirstOfDayByDate(Date date) {
        String dateStr = format(date, FORMAT_SHORT) + " 00:00:00";
        return parse(dateStr, FORMAT_LONG);
    }


    /**
     * 得到指定月的第一天或者最后一天
     */
    public static Date getDayOfMonthByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getFirstOfDayByDate(calendar.getTime());
    }

    /**
     * 得到指定月的第一天或者最后一天
     */
    public static Date getDayOfYearByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return getFirstOfDayByDate(calendar.getTime());
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat(FORMAT_SHORT).format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat(FORMAT_SHORT)
                .format(c.getTime());
        return dayAfter;
    }

    // 判断选择的日期是否是本周
    public static boolean isThisWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == currentWeek) {
            return true;
        }
        return false;
    }

    // 判断选择的日期是否是今天
    public static boolean isToday(long time) {
        return isThisTime(time, FORMAT_SHORT);
    }

    // 判断选择的日期是否是本月
    public static boolean isThisMonth(long time) {
        return isThisTime(time, FORMAT_SHORT);
    }

    private static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);// 参数时间
        String now = sdf.format(new Date());// 当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }

    /***
     * 将时间转为cron convert Date to cron ,eg. "14 26 09 06 03 ? 2017"
     *
     * @param date
     *            : 设置时间
     * @return
     */
    public static String getCron(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_SHORT);
        try {
            smdate = sdf.parse(sdf.format(smdate));

            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_SHORT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 时间转int
     *
     * @param smdate 时间
     * @return int型
     */
    public static int dateFomateYM(Date smdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return Integer.parseInt(sdf.format(smdate));
    }

    /**
     * 时间格式转换
     *
     * @param smdate 时间
     * @return string型
     */
    public static String dateFomate(Date smdate, String simpleDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
        return sdf.format(smdate);
    }

    /**
     * 获取当前时间字符串
     */
    public static String getNowStr() {
        DateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 获取今天周几（中国）
     *
     * @return
     */
    public static int getChineseDayOffsetOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            return 7;
        } else {
            return weekday - 1;
        }
    }

    /**
     * 获取今天周几（国际）
     *
     * @return
     */
    public static int getDayOffsetOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    /**
     * 获取今天是本月的第几天
     *
     * @return
     */
    public static int getDayOffsetOfMonth() {
        Calendar c = Calendar.getInstance();
        int datenum = c.get(Calendar.DATE);
        return datenum;
    }

    /**
     * 根据日期字符串生成cron表达式
     *
     * @param pattern
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static String DateToCronExpression(String pattern, String dateStr) throws ParseException {
        // 每天 "0 15 10 * * ?" 每天上午10:15触发 每天
        // 日期格式 :yyyy-mm-dd hh:mm:ss
        if (QuartzEnum.DeduCycle.EVERYDAY.value().equals(pattern)) {
            String hms = dateStr.split(" ")[1];
            return Integer.parseInt(hms.split(":")[2]) + " " + Integer.parseInt(hms.split(":")[1]) + " "
                    + Integer.parseInt(hms.split(":")[0]) + " " + "*" + " " + "*" + " " + "?";
        }
        // 按月 "0 15 10 15 * ?" 每月15日上午10:15触发
        if (QuartzEnum.DeduCycle.MONTHAFTERMONTH.value().equals(pattern)) {
            String ymd = dateStr.split(" ")[0];
            String hms = dateStr.split(" ")[1];
            return Integer.parseInt(hms.split(":")[2]) + " " + Integer.parseInt(hms.split(":")[1]) + " "
                    + Integer.parseInt(hms.split(":")[0]) + " " + Integer.parseInt(ymd.split("-")[2]) + " " + "*" + " "
                    + "?";
        }
        // 按周 0 0 12 ? * WED 表示每个星期三中午12点
        if (QuartzEnum.DeduCycle.WEEKLY.value().equals(pattern)) {
            int dateOfWeek = getDayOffsetOfWeek(StrToDate(dateStr));
            String ymd = dateStr.split(" ")[0];
            String hms = dateStr.split(" ")[1];
            return Integer.parseInt(hms.split(":")[2]) + " " + Integer.parseInt(hms.split(":")[1]) + " "
                    + Integer.parseInt(hms.split(":")[0]) + " " + "?" + " " + "*" + " " + dateOfWeek;
        }
        // 按年 "0 15 10 23 3 ?" 每年3月23号上午10点15分
        if (QuartzEnum.DeduCycle.YEARLY.value().equals(pattern)) {
            String ymd = dateStr.split(" ")[0];
            String hms = dateStr.split(" ")[1];
            return Integer.parseInt(hms.split(":")[2]) + " " + Integer.parseInt(hms.split(":")[1]) + " "
                    + Integer.parseInt(hms.split(":")[0]) + " " + Integer.parseInt(ymd.split("-")[2]) + " "
                    + Integer.parseInt(ymd.split("-")[1]) + " " + "?" + " " + "*";
        }
        //执行一次
        if (QuartzEnum.DeduCycle.ONCE.value().equals(pattern)) {
            SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat(FORMAT_LONG);
            String formatTimeStr = sdf.format(sdf2.parse(dateStr));
            return formatTimeStr;
        }
        return null;
    }

    public static Date StrToDate(String dateStr) {
        DateFormat format = new SimpleDateFormat(FORMAT_LONG);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToStr(Date date) {
        DateFormat format = new SimpleDateFormat(FORMAT_LONG);
        return format.format(date);
    }

    /**
     * 指定当前时间最一秒
     *
     * @param date 时间
     * @return
     */
    public static Date getLastOfDayByDate(Date date) {
        String dateStr = format(date, FORMAT_SHORT) + " 23:59:59";
        return parse(dateStr, FORMAT_LONG);
    }

//	public static void main(String[] args) {
//		try {
//            Date date=new Date();
//            System.out.println(getLastOfDayByDate(date));
//            System.out.println(getFirstOfDayByDate(date));
//        } catch(Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
