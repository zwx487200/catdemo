package com.example.catdemo.entity;

import java.io.Serializable;
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
@TableName("pet_health_record")
public class PetHealthRecord implements Serializable {

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
    private Date recordDate;

    /**
     * 记录类型
     */
    private String recordType;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 主治医师
     */
    private String veterinarian;

    /**
     * 下次复诊日期
     */
    private Date nextVisit;

    /**
     * 创建时间
     */
    private Date createdAt;
}
