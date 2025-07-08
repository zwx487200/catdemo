package com.example.catdemo.entity;

import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 食谱食材明细表
 *
 * @author zhanhuibin
 * @since 2025-06-03 17:31
 */
@Data
@TableName("recipe_ingredients")
public class RecipeIngredients implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 食材明细唯一ID
     */
    @TableId(value = "ingredient_id", type = IdType.AUTO)
    private String ingredientId;

    /**
     * 关联的菜谱ID
     */
    private String recipeId;

    /**
     * 食材名称
     */
    private String ingredientName;

    /**
     * 食材分量
     */
    private String ingredientPortion;

    /**
     * 是否可替换 (0=不可,1=可)
     */
    private Integer replaceable;

    /**
     * 是否可省略 (0=不可,1=可)
     */
    private Integer omissible;

    /**
     * 替换食材名称
     */
    private String replaceIngredientName;

    /**
     * 替换食材分量
     */
    private String replaceIngredientPortion;
}
