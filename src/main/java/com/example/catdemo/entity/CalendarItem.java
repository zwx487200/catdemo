package com.example.catdemo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarItem {

    // 事件类型 anniversary, birthday, todoItem,countdown, dateEvent
    private String type;

    // 事件id
    private String id;

    // 待办id
    private String todoItemId;

    // 标题
    private String title;

    // 描述
    private String description;

    //日期
    private Date date;

    // 开始时间
    private Date startDate;

    // 结束时间
    private Date endDate;

    // 是否完成
    private Integer isDone;

    // 重要程度
    private Integer importance;

    // 家庭id
    private String familyId;

    // 家庭成员id
    private String familyMemberId;

    // 用户id
    private String userId;

    // 提前几天提醒
    private Integer remindDays;


}
