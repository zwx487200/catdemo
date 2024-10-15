package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2024-12-05 19:37
 */
@Data
@ApiModel("")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务Id")
    private String taskId;

    @ApiModelProperty("任务发起人Id")
    private String initiatorId;

    @ApiModelProperty("任务发起人姓名")
    private String initiatorName;

    @ApiModelProperty("任务接受人Id")
    private String executorId;

    @ApiModelProperty("任务接受人姓名")
    private String executorName;

    @ApiModelProperty("任务类型，长期任务01，短期任务02，一次性任务03")
    private String taskType;

    @ApiModelProperty("任务开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("任务结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endTime;


    @ApiModelProperty("奖励类型，01-积分奖励02-其他奖励")
    private String rewardType;

    @ApiModelProperty("任务奖励")
    private String reward;

    @ApiModelProperty("是否存在惩罚")
    private String hasPenalty;

    @ApiModelProperty("惩罚内容")
    private String penalty;

    @ApiModelProperty("任务描述")
    private String taskContent;

    @ApiModelProperty("任务状态，01：发布态，02：接受态，03：待审核，04完成态")
    private String taskStatus;

    @ApiModelProperty("创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
}
