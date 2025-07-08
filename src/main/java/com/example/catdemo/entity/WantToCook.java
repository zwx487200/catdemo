package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 我想吃表
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
@Data
@TableName("want_to_cook")
@NotNull(groups = {addGroup.class, updateGroup.class} , message = "不能为空")
public class WantToCook implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = {updateGroup.class, deleteGroup.class} , message = "id不能为空")
    private String id;

    /**
     * 菜谱ID
     */
    @NotNull(groups = {addGroup.class} , message = "recipeId不能为空")
    private String recipeId;

    private String recipeName;

    /**
     * 用户ID
     */
    @NotNull(groups = {addGroup.class} , message = "userId不能为空")
    private String userId;

    /**
     * 家庭ID
     */
    @NotNull(groups = {addGroup.class} , message = "familyId不能为空")
    private String familyId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 计划烹饪时间
     */
    private Date plannedCookingTime;

    /**
     * 过期时间
     */
    private Date expiryTime;

    /**
     * 优先级(1-5,1最高)
     */
    @NotNull(groups = {addGroup.class} , message = "priority不能为空")
    private Integer priority;

    /**
     * 状态(0:待采购,1:已采购,2:已取消)
     */
    private Integer status;

    /**
     * 采购食材列表
     */
    private List<WantToCookRecipeIngredients> wantToCookRecipeIngredients;
}
