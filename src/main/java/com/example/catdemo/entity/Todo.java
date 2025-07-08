package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 待办事项核心表
 *
 * @author zhanhuibin
 * @since 2025-03-24 17:16
 */
@Data
@ApiModel("待办事项核心表")
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一任务标识")
    private String id;

    @ApiModelProperty("任务内容")
    private String taskContent;

    @ApiModelProperty("完成状态 (0-未完成/1-已完成)")
    private Integer completed;

    @ApiModelProperty("优先级")
    private String priority;

    @ApiModelProperty("截止日期")
    private Date dueDate;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("最后更新时间")
    private Date updatedAt;

    @ApiModelProperty("所属用户ID，对应的是家庭成员的memberId")
    private String userId;

    @ApiModelProperty("前置任务ID")
    private Integer predecessorId;

    @ApiModelProperty("任务标题")
    private String title;

    @ApiModelProperty("是否重复 (0-否/1-是)")
    private Integer isRepeating;

    @ApiModelProperty("重复模式")
    private String repeatPattern;

    @ApiModelProperty("重复间隔（如每周3次）")
    private Integer repeatInterval;

    @ApiModelProperty("重复星期几")
    private List<String> repeatDays;

    @ApiModelProperty("重复截止日期")
    private Date repeatUntil;
}
