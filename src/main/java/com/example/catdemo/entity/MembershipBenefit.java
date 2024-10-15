package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员权益表
 *
 * @author zhanhuibin
 * @since 2025-01-13 11:11
 */
@Data
@ApiModel("会员权益表")
public class MembershipBenefit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权益ID")
    private String benefitId;

    @ApiModelProperty("等级ID")
    private String levelId;

    @ApiModelProperty("权益名称")
    private String benefitName;

    @ApiModelProperty("权益描述")
    private String benefitDescription;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
