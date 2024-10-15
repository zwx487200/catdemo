package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2024-12-09 14:40
 */
@Data
@ApiModel("")
public class RewardPenalty implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String id;

    @ApiModelProperty("")
    private String userId;

    @ApiModelProperty("01奖励，02处罚）")
    private String rewardPenaltyType;

    @ApiModelProperty("")
    private String content;

    @ApiModelProperty("（01未核销，02已核销）")
    private String status;

    @ApiModelProperty("")
    private Date createdAt;

    @ApiModelProperty("")
    private Date updatedAt;
}
