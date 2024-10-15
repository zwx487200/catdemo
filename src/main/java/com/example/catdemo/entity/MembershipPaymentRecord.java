package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员支付记录表
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Data
@ApiModel("会员支付记录表")
public class MembershipPaymentRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("支付ID")
    private String paymentId;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("会员ID")
    private String membershipId;

    @ApiModelProperty("支付金额")
    private BigDecimal paymentAmount;

    @ApiModelProperty("支付时间")
    private Date paymentDate;

    @ApiModelProperty("支付状态 (1-成功, 0-失败)")
    private Integer paymentStatus;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
