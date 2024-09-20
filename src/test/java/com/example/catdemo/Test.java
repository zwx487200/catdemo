package com.example.catdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {

        String aaa = "2024-09-22 00:00:00";
        System.out.println(aaa.substring(0, 10));
        String endTime = "2024-10-11";
        String startTime = "2024-09-30";
        // 计算两天之间差多少天
        LocalDate startDate = LocalDate.parse(startTime);
        LocalDate endDate = LocalDate.parse(endTime);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1  ;
        System.out.println("Days between: " + daysBetween);

        // 补班时间集合
        List<String> bubanlist = new ArrayList<String>();
        bubanlist.add("2024-09-14");

        // 放假时间的集合
        List<String> fangjialist = new ArrayList<String>();
        fangjialist.add("2024-09-15");
        fangjialist.add("2024-09-16");
        fangjialist.add("2024-09-17");

        int alldayNum = (int) daysBetween;
        Set<LocalDate> totalFangjiaList = new HashSet<>();

        for (int i = 0; i < alldayNum; i++) {
            LocalDate date = startDate.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                totalFangjiaList.add(date);
            }
        }

        for (String fangjia : fangjialist) {
            LocalDate fangjiaDate = LocalDate.parse(fangjia);
            totalFangjiaList.add(fangjiaDate);
        }
       System.out.println("全部假期包含周末和节假日，未减去补班"+totalFangjiaList.size());
       System.out.println("总工作日" + (alldayNum  - totalFangjiaList.size() +bubanlist.size()));












        // 将yyyy-MM-dd HH:mm:ss格式的时间改成yyyy-MM-dd格式的时间
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateFormat.parse(begTime));
//        int begYear = calendar.get(Calendar.YEAR);
//        int begMonth = calendar.get(Calendar.MONTH) + 1;
//        int begDay = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println("Beg date: " + begYear + "-" + begMonth + "-" + begDay);

        // 循环计算每一天是星期几
//        List<LocalDate> dateList = new ArrayList<>();
//        for (int i = 0; i < daysBetween; i++) {
//            // 计算两天之间是星期几
//            DayOfWeek dayOfWeek = startDate.getDayOfWeek();
//            // 时间加一天
//            startDate = startDate.plusDays(1);
//            // 如果是星期六或星期日 就添加到
//            // 如果是星期六或星期日 就输出
//            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
//                System.out.println("The day of the week is: " + startDate + dayOfWeek);
//            }
//        }
    }
}
