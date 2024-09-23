package com.example.catdemo.utils;

import lombok.Data;

/**
 * @author jennyzhuzhu
 */
@Data
public class RequestInfo  {
    Object data;
    int pageSize;
    int pageNum;
}
