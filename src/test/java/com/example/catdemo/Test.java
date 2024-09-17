package com.example.catdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParseException {
//        List<SortTest>  sortTests= new ArrayList<SortTest>();
//        SortTest test1= new SortTest("test","test",null,null);
//        SortTest test2= new SortTest("test2","test2","2024-07-18 00:00:00",null);
//        SortTest test3= new SortTest("test3","test3","2024-07-19 00:00:00",null);
//        SortTest test4= new SortTest("test4","test4","2024-07-20 00:00:00",null);
//        SortTest test5= new SortTest("test5","test5","2024-07-21 00:00:00",null);
//        sortTests.add(test1);
//        sortTests.add(test2);
//        sortTests.add(test3);
//        sortTests.add(test4);
//        sortTests.add(test5);
//        sortTests.sort((o1, o2) -> o2.getLastMrData().compareTo(o1.getLastMrData()));
//        String lastMrData = sortTests.get(0).getLastMrData();
//        System.out.println("Last MrData: " + lastMrData);
//        for (SortTest test: sortTests) {
//            System.out.println(test.getName());
//        }


        // 2024-07-17 00:00:00
        String endTime = "2024-07-17 00:00:00";
        String startTime = "2024-07-11 00:00:00";

        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

        cal.setTime(sdf.parse(endTime));
        cal2.setTime(sdf.parse(startTime));
        int startExpYm = Integer.parseInt(sdf1.format(cal.getTime()));
        int endExpYm = Integer.parseInt(sdf1.format(cal2.getTime()));
        System.out.println("Start ExpYm: " + startExpYm);
        System.out.println("End ExpYm: " + endExpYm);
        System.out.println("时间差: " + (startExpYm - endExpYm));
    }

}
