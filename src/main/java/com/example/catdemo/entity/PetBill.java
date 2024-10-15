package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 宠物健康档案表
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@Data
@TableName("pet_bill")
public class PetBill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录唯一ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 关联宠物ID
     */
    private String petId;

    /**
     * 记录日期
     */
    private Date petBillDate;

    /**
     * 记录类型
     */
    private String petBillType;

    /**
     * 费用
     */
    private BigDecimal amount;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 家庭id
     */
    private String familyId;

    /**
     * 操作人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdAt;
}
