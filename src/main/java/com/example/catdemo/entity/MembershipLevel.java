package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员等级表
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Data
@ApiModel("会员等级表")
public class MembershipLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("等级ID")
    private String levelId;

    @ApiModelProperty("会员等级")
    private String level;

    @ApiModelProperty("等级名称")
    private String levelName;

    @ApiModelProperty("等级描述")
    private String levelDescription;

    @ApiModelProperty("等级权益")
    private String levelBenefits;

    @ApiModelProperty("权益列表")
    private List<MembershipBenefit> membershipBenefitList;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;

    @ApiModelProperty("等级价格")
    private List<MembershipPrice> membershipPrices;
}
