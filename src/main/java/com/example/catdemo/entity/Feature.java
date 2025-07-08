package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能表
 *
 * @author zhanhuibin
 * @since 2025-02-18 09:54
 */
@Data
@ApiModel("功能表")
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("功能ID")
    private String featureId;

    @ApiModelProperty("功能标题中文")
    @NotNull(groups = {addGroup.class} ,message = "功能标题中文不能为空")
    private String featureTitleZh;

    @ApiModelProperty("功能标题英文")
    private String featureTitleEn;

    @ApiModelProperty("功能描述中文")
    private String featureDescriptionZh;

    @ApiModelProperty("功能描述英文")
    private String featureDescriptionEn;

    @ApiModelProperty("功能对应地址")
    private String featureUrl;

    @ApiModelProperty("功能是否需要订阅 (1-是, 0-否)")
    private Integer requiresSubscription;

    @ApiModelProperty("类型（01默认,02非默认）")
    private String type;

    @ApiModelProperty("是否允许家庭成员共享 (1-是, 0-否)")
    private Integer isAvailableForFamily;
    @ApiModelProperty("允许共享的家庭角色（多个角色用逗号分隔，如 \"01,02\"）")
    private String allowedFamilyRoles;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("7天订阅价格")
    private BigDecimal sevenDaysSubscriptionPrice;

    @ApiModelProperty("一个月订阅价格")
    private BigDecimal oneMonthSubscriptionPrice;

    @ApiModelProperty("一个季度订阅价格")
    private BigDecimal oneQuarterSubscriptionPrice;

    @ApiModelProperty("一年订阅价格")
    private BigDecimal oneYearSubscriptionPrice;

    @ApiModelProperty("是否有折扣 (1-是, 0-否)")
    private Integer hasDiscount;

    @ApiModelProperty("折扣比例")
    private BigDecimal discountRate;

    @ApiModelProperty("是否可以试用 (1-是, 0-否)")
    private Integer isTrialAvailable;

    @ApiModelProperty("试用时长")
    private Integer trialDuration;

    @ApiModelProperty("试用时长单位(D-天，W-周，M-月，Y-年)")
    private String trialDurationUnit;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;

    @ApiModelProperty("图标")
    private String icons;

    @ApiModelProperty("功能状态,0-下架，1-上架")
    private String status;
}
