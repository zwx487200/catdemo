package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户积分主表
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@Data
@ApiModel("用户积分主表")
public class UserPoints implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private String id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("总积分")
    private BigDecimal totalPoints;

    @ApiModelProperty("乐观锁版本号")
    private Integer version;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;
}
