package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * 家庭食谱主表
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
@Data
@TableName("recipes")
public class Recipes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜谱唯一标识
     */
    @TableId(value = "recipe_id", type = IdType.AUTO)
    @NotNull(groups = {updateGroup.class, deleteGroup.class, queryGroup.class}, message = "菜谱唯一标识不能为空")
    private String recipeId;

    /**
     * 所属家庭ID
     */
    @NotNull(groups = {addGroup.class}, message = "所属家庭ID不能为空")
    private String familyId;

    /**
     * 创建者用户ID
     */
    @NotNull(groups = {addGroup.class}, message = "创建者用户ID不能为空")
    private String creatorId;

    /**
     * 菜品名称
     */
    @NotNull(groups = {addGroup.class}, message = "菜品名称不能为空")
    private String foodName;

    /**
     * 份量（几人份）
     */
    @NotNull(groups = {addGroup.class}, message = "份量（几人份）不能为空")
    private Integer servings;

    private List<RecipeIngredients> recipeIngredients;

    private List<CookingSteps> cookingSteps;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt = new Date();
}
