package com.example.catdemo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.checkerframework.checker.units.qual.A;

/**
 * <p>
 * 账单表
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("billinfo")
@ApiModel(value="Billinfo对象", description="账单表")
public class Billinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账单id")
    private String billId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "账单类型，来源于attributeinfo表的billType  其中当billType为99的时候，表示收入")
    private String billType;

    @ApiModelProperty(value = "账单来源，来源于attributeinfo表的billSource，当billType为99的来源为 于attributeinfo表的inComeSource")
    private String billSource;

    @ApiModelProperty(value = "金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "账单时间")
    private String billTime;

    @ApiModelProperty(value = "是否同步到零钱")
    private String isSyncWithPocketMoney;

    @ApiModelProperty(value = "创建者")
    private String creator;

}
