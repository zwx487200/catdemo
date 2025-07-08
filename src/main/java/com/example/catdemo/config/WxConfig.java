package com.example.catdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "wx")
public class WxConfig {
    private String appId;         // 小程序appId
    private String appSecret;     // 小程序appSecret
    private String grantType;     // 授权类型
    private String loginUrl;      // 登录接口地址
    private String userInfoUrl;   // 用户信息接口地址
} 