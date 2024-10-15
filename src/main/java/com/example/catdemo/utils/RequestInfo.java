package com.example.catdemo.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jennyzhuzhu
 */
@Data
public class RequestInfo  {
    Object data;
    int pageSize;
    int pageNum;
    int totalCount;
    String token;
    List<String> familyMemberIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date endDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date queryDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    Date queryMonth;

    String sort;
    String order;

}
