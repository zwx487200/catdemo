package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 积分流水表
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@Data
@ApiModel("积分流水表")
public class PointsChangeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("points_change_log表主键")
    private String logId;

    @ApiModelProperty("关联用户")
    private String userId;

    @ApiModelProperty("变动类型(01新增，02扣除，03兑换)")
    private String changeType;

    @ApiModelProperty("变动数值")
    private BigDecimal changeAmount;

    @ApiModelProperty("来源(如订单ID/活动ID)")
    private String source;

    @ApiModelProperty("操作人ID")
    private String operatorId;

    @ApiModelProperty("变动描述")
    private String changeDesc;

    @ApiModelProperty("创建时间")
    private Date createdAt;
}
