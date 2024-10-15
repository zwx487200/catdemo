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
 * @since 2024-12-09 15:12
 */
@Data
@ApiModel("")
public class Pocketbank implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("口袋银行ID，唯一标识")
    private String pocketBankId;

    @ApiModelProperty("用户ID，该口袋银行归属的用户")
    private String userId;

    @ApiModelProperty("口袋银行余额")
    private BigDecimal balance;

    @ApiModelProperty("活期余额")
    private BigDecimal currentBalance;

    @ApiModelProperty("定期余额")
    private BigDecimal fixedBalance;

    @ApiModelProperty("利率")
    private BigDecimal interestRate;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @ApiModelProperty("修改时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
