package com.example.catdemo.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@Data
public class QueryInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    public int pageSize = 10;
    public int pageNum = 1;
    public int totalCount = 0;
    public String sortField;
    public String sortOrder;
    public String startDate;
    public String endDate;
}
