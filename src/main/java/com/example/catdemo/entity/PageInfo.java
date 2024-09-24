package com.example.catdemo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@Data
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public int pageSize = 10;

    public int pageNum = 1;


}
