package com.example.catdemo.entity;

import lombok.Data;

/**
 * @author jennyzhuzhu
 */
@Data
public class WxUserInfo {
    // 微信openId
    private String openId;
    // 微信unionId
    private String unionId;
    // 用户昵称
    private String nickName;
    // 用户头像
    private String avatarUrl;
    // 性别
    private String gender;
    // 国家
    private String country;
    // 省份
    private String province;
    // 城市
    private String city;
    // 语言
    private String language;
    // 手机号
    private String phone;
    // 用户ID
    private String userId;
} 