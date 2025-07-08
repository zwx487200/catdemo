package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import jakarta.validation.constraints.NotNull;


/**
 * 宠物健康档案表
 *
 * @author zhanhuibin
 * @since 2025-05-19 21:36
 */
@Data
@TableName("pet_bill")
@NotNull(message = "宠物健康档案表不能为空")
public class PetBill implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 记录唯一ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = {updateGroup.class, deleteGroup.class,  queryGroup.class} ,message = "记录唯一ID不能为空")
    private String id;

    /**
     * 关联宠物ID
     */
    @NotNull(groups = {addGroup.class} ,message = "关联宠物ID不能为空")
    private String petId;

    /**
     * 账单类型(1-医疗,2-食品,3-用品,4-美容,5-其他)
     */
    @NotNull(groups = {addGroup.class} ,message = "账单类型不能为空")
    private String billType;

    /**
     * 金额
     */
    @NotNull(groups = {addGroup.class} ,message = "金额不能为空")
    private BigDecimal amount;

    /**
     * 账单日期
     */
    private Date billDate;

    /**
     * 支付方式(1-现金,2-支付宝,3-微信,4-银行卡)
     */
    @NotNull(groups = {addGroup.class} ,message = "支付方式不能为空")
    private Integer paymentMethod;

    /**
     * 具体分类
     */
    private String category;

    /**
     * 描述
     */
    private String description;

    /**
     * 附件URL(JSON数组)
     */
    private String attachmentUrls;

    /**
     * 家庭id
     */
    @NotNull(groups = {addGroup.class} ,message = "家庭id不能为空")
    private String familyId;

    /**
     * 创建人
     */
    @NotNull(groups = {addGroup.class} ,message = "创建人不能为空")
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime = new Date();
}
