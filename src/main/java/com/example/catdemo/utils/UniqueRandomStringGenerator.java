package com.example.catdemo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author: jennyzhuzhu
 * @date: 2024-11-12 上午9:35
 */
public class UniqueRandomStringGenerator {
    // 随机生成N位随机字符
    public static String generateRandomString(int n) {
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (Math.random() * possibleChars.length());
            sb.append(possibleChars.charAt(index));
        }
        return sb.toString();
    }
    // 生成YYYYmmdd + N位随机字符
    public static String generateUniqueRandomString(int n) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYmmdd");
        String formattedDate = now.format(formatter);
        String randomString = generateRandomString(n);
        return formattedDate + randomString;
    }
}
