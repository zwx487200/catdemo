package com.example.catdemo.entity;

import lombok.Data;

/**
 * @author: jennyzhuzhu
 * @date: 2024-12-18 上午10:34
 */
@Data
public class ApiMapping {
    private Long id;
    private String url;
    private String controllerName;
    private String methodName;
    private String requestParamsJson;
    // 省略getter和setter
}

