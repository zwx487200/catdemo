package com.example.catdemo.utils;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String hashPassword( String password) {
        String generatedPassword = null;
        try {
            // 创建一个MessageDigest实例，初始化为SHA-256算法
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // 计算password字符串的哈希值
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean equalsPassword(String password1, String password2) {
        return password1.equals(password2);
    }
}
