package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户订阅表
 *
 * @author zhanhuibin
 * @since 2025-02-18 10:04
 */
@Data
@ApiModel("用户订阅表")
@NotNull(message = "用户订阅表不能为空")
public class UserSubscription implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户订阅表主键ID")
    private String id;

    @ApiModelProperty("用户ID")
    @NotNull(groups = {addGroup.class}, message = "用户ID不能为空")
    private String userId;

    @ApiModelProperty("功能ID")
    @NotNull(groups = {addGroup.class}, message = "功能ID不能为空")
    private String featureId;

    @ApiModelProperty("订阅开始时间")
    private Date subscriptionStart;

    @ApiModelProperty("订阅结束时间")
    private Date subscriptionEnd;

    @ApiModelProperty("是否自动续订 (1-是, 0-否)")
    private Integer autoRenew;

    @ApiModelProperty("是否试用 (1-是, 0-否)")
    private Integer isTrial;

    @ApiModelProperty("功能排序")
    private Integer sort;

    @ApiModelProperty("是否有效 (1-是, 0-否)")
    private String status;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt = new Date();

    @ApiModelProperty("功能")
    private Feature feature;

    @ApiModelProperty("本次订阅时长类型，M,Q,Y")
    private String subscriptionDurationType;
}
