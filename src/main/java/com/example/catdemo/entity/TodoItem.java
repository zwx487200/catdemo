package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Data
@TableName("todo_item")
@NotNull(groups = {addGroup.class, updateGroup.class, deleteGroup.class, queryGroup.class} ,message = "待办不能为空")
public class TodoItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {queryGroup.class, updateGroup.class, deleteGroup.class}, message = "id不能为空")
    private String id;

    @NotBlank(groups = {addGroup.class}, message = "标题不能为空")
    private String title;


    private String description;

    /**
     * weekly:[1,3,5]
     */
    @NotBlank(groups = {addGroup.class}, message = "重复规则不能为空")
    private String repeatRule;

    /**
     * 家庭id
     */
    @NotBlank(groups = {addGroup.class}, message = "家庭id不能为空")
    private String familyId;

    /**
     * 家庭成员id
     */
    @NotBlank(groups = {addGroup.class},message = "家庭成员id不能为空")
    private String familyMemberId;

    /**
     * 用户id
     */
    private String userId;

    @NotNull(groups = {addGroup.class}, message = "开始时间不能为空")
    private Date startDate;

    @NotNull(groups = {addGroup.class}, message = "结束时间不能为空")
    private Date endDate;

    private List<TodoRepeatInstance> repeatInstances;
}
