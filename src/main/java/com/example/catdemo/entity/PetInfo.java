package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 宠物基本信息表
 *
 * @author zhanhuibin
 * @since 2025-05-19 20:12
 */
@Data
@TableName("pet_info")
@NotNull(message = "宠物信息不能为空")
public class PetInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 宠物唯一ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = {updateGroup.class, deleteGroup.class,  queryGroup.class} ,message = "宠物唯一ID不能为空")
    private String id;

    /**
     * 宠物名称
     */
    @NotNull(groups = {addGroup.class} ,message = "宠物名称不能为空")
    private String petName;

    /**
     * 宠物类型(猫/狗等)
     */
    @NotNull(groups = {addGroup.class} ,message = "宠物类型不能为空")
    private String petType;

    /**
     * 品种
     */
    private String breed;

    /**
     * 性别(0-未知,1-公,2-母)
     */
    private Integer gender;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 体重(kg)
     */
    private BigDecimal weight;

    /**
     * 毛色
     */
    private String color;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 是否绝育(0-否,1-是)
     */
    private Integer isSterilized;

    /**
     * 备注
     */
    private String remark;

    /**
     * 主人id
     */
    @NotNull(groups = {addGroup.class} ,message = " mastersId不能为空")
    private String ownerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;
}
