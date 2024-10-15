package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户会员表
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Data
@ApiModel("用户会员表")
public class UserMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会员ID")
    private String membershipId;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("会员等级 (1-白银会员, 2-黄金会员, 3-钻石会员)")
    private Integer membershipLevel;

    @ApiModelProperty("会员时长单位 (D-天, W-周, M-月, Y-年, L-永久)")
    private String durationUnit;

    @ApiModelProperty("会员开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date membershipStartDate;

    @ApiModelProperty("会员结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date membershipEndDate;

    @ApiModelProperty("会员状态 (1-有效, 0-过期)")
    private Integer membershipStatus;

    @ApiModelProperty("是否自动续费 (1-自动续费, 0-手动续费)")
    private Integer isAutoRenewal;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
