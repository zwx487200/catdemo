package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 宠物基本信息表
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@Data
@TableName("pet_info")
public class PetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 宠物唯一ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 宠物名称
     */
    private String name;

    /**
     * 物种
     */
    private String species;

    /**
     * 品种
     */
    private String breed;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 主人id
     */
    private String ownerId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 最后更新时间
     */
    private Date updatedAt;
}
