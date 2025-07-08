package com.example.catdemo.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author jennyzhuzhu
 */
public class DateUtils {
    // 获取今天日期
    public static Date getToday() {
        return new Date();
    }

    // 获取这个月的月初
    public static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    // 获取这个月的月尾
    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    // 获取这周的周一
    public static Date getMondayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -6);
        } else {
            calendar.add(Calendar.DAY_OF_WEEK, Calendar.MONDAY - dayOfWeek);
        }
        return calendar.getTime();
    }

    // 获取这周的周五
    public static Date getFridayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -2);
        } else if (dayOfWeek == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        } else {
            calendar.add(Calendar.DAY_OF_WEEK, Calendar.FRIDAY - dayOfWeek);
        }
        return calendar.getTime();
    }

    // 判断两个日期谁大
    public static boolean isAfter(Date date1, Date date2) {
        return date1.after(date2);
    }

    // 当前日期N天后的日期
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    // 当前日期N天前的日期
    public static Date subtractDays(Date date, int days) {
        return addDays(date, -days);
    }

    // 当前日期N周后的日期
    public static Date addWeeks(Date date, int weeks) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, weeks);
        return calendar.getTime();
    }

    // 当前日期N周前的日期
    public static Date subtractWeeks(Date date, int weeks) {
        return addWeeks(date, -weeks);
    }

    // 当前日期N月后的日期
    public static Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    // 当前日期N月前的日期
    public static Date subtractMonths(Date date, int months) {
        return addMonths(date, -months);
    }

    // 当前日期N年后的日期
    public static Date addYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    // 当前日期N年前的日期
    public static Date subtractYears(Date date, int years) {
        return addYears(date, -years);
    }

    // 将日期转换为"YYYY-MM-DD"格式的字符串
    public static String formatDateToString(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return String.format("%d-%02d-%02d", year, month, day);
    }
}