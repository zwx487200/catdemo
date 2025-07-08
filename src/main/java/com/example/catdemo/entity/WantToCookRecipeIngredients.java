package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 想吃食谱食材关联表
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
@Data
@TableName("want_to_cook_recipe_ingredients")
public class WantToCookRecipeIngredients implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 想吃记录ID
     */
    private String wantToCookId;

    /**
     * 食谱食材ID
     */
    private String recipeIngredientId;

    /**
     * 状态(0:未采购,1:已采购)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private RecipeIngredients recipeIngredients;
}
