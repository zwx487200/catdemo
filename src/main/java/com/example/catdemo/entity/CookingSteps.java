package com.example.catdemo.entity;

import java.io.Serializable;

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
 * 烹饪步骤表
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
@Data
@TableName("cooking_steps")
public class CookingSteps implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 烹饪步骤唯一ID
     */
    @TableId(value = "cooking_step_id", type = IdType.AUTO)
    @NotNull(groups = {updateGroup.class, deleteGroup.class, queryGroup.class}, message = "烹饪步骤唯一ID不能为空")
    private String cookingStepId;

    /**
     * 关联的菜谱ID
     */
    @NotNull(groups = {addGroup.class}, message = "关联的菜谱ID不能为空")
    private String recipeId;

    /**
     * 步骤顺序 (1开始)
     */
    @NotNull(groups = {addGroup.class}, message = "步骤顺序不能为空")
    private Integer stepOrder;

    /**
     * 步骤详细说明
     */
    @NotNull(groups = {addGroup.class}, message = "步骤详细说明不能为空")
    private String customNotes;

    /**
     * 步骤图片URL（扩展字段）
     */
    private String stepImage;

    /**
     * 预估时间(分钟)（扩展字段）
     */
    private Integer estimatedTime;
}
