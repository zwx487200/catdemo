package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * 会员日志表
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Data
@ApiModel("会员日志表")
public class MembershipLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志ID")
    private String logId;

    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private String userId;

    @NotBlank(message = "会员ID不能为空")
    @ApiModelProperty("会员ID")
    private String membershipId;

    @NotBlank(message = "操作类型不能为空")
    @ApiModelProperty("操作类型 (1-开通, 2-续费, 3-升级, 4-降级, 5-取消)")
    private Integer operationType;


    @ApiModelProperty("操作时间")
    private Date operationDate;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
