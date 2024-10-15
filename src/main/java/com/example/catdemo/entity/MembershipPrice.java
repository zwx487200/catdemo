package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员价格表
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:53
 */
@Data
@ApiModel("会员价格表")
public class MembershipPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("价格ID")
    private String priceId;

    @ApiModelProperty("会员等级ID")
    private String levelId;

    @ApiModelProperty("价格金额")
    private BigDecimal priceAmount;

    @ApiModelProperty("有效期单位 (D-天, W-周, M-月, Y-年, L-永久)")
    private String durationUnit;

    @ApiModelProperty("有效期数量")
    private Integer duration;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
