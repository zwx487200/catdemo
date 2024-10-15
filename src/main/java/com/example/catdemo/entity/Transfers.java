package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2024-12-10 10:44
 */
@Data
@ApiModel("")
public class Transfers implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private String transferId;

    @ApiModelProperty("转出户")
    private String outAccountId;

    @ApiModelProperty("转入户")
    private String inAccountId;

    @ApiModelProperty("转账类型01定时，02定期，03实时转账")
    private String transferType;

    @ApiModelProperty("定时任务的开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date scheduledTransferTime;

    @ApiModelProperty("定期任务的执行周期")
    private String periodicTransferTime;

    @ApiModelProperty("转入期数")
    private Integer transferCount;

    @ApiModelProperty("转入金额")
    private BigDecimal transferAmount;
}
