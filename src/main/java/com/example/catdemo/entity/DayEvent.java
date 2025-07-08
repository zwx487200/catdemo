package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 日程表
 *
 * @author zhanhuibin
 * @since 2025-07-07 09:27
 */
@Data
@TableName("day_event")
@NotNull(groups = {addGroup.class, updateGroup.class, deleteGroup.class, queryGroup.class} ,message = "日程不能为空")
public class DayEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {queryGroup.class, updateGroup.class, deleteGroup.class}, message = "id不能为空")
    private String id;

    @NotBlank(groups = {addGroup.class}, message = "标题不能为空")
    private String title;

    @NotNull(groups = {addGroup.class}, message = "日程日历不为空")
    private Date date;

    @NotNull(groups = {addGroup.class}, message = "开始时间不能为空")
    private Date startTime;

    @NotNull(groups = {addGroup.class}, message = "结束时间不能为空")
    private Date endTime;

    private String description;

    /**
     * 家庭id
     */
    @NotBlank(groups = {addGroup.class}, message = "家庭id不能为空")
    private String familyId;

    /**
     * 家庭成员id
     */
    @NotBlank(groups = {addGroup.class}, message = "家庭成员id不能为空")
    private String familyMemberId;

    /**
     * 用户id
     */

    private String userId;

    /**
     * 重要程度
     */
    private Integer importance;

    /**
     * 是否完成
     */
    private Integer isDone;
}
