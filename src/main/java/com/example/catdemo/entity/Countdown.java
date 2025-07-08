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
 * 倒数日
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Data
@TableName("countdown")
@NotNull(groups = {addGroup.class, updateGroup.class, deleteGroup.class, queryGroup.class} ,message = "倒数日不能为空")
public class Countdown implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {queryGroup.class, updateGroup.class, deleteGroup.class}, message = "id不能为空")
    private String id;

    @NotBlank(groups = {addGroup.class}, message = "标题不能为空")
    private String title;

    @NotNull(groups = {addGroup.class}, message = "目标日期不能为空")
    private Date targetDate;

    private Date remindStartDate;

    private String description;

    /**
     * 家庭id
     */
    @NotBlank(groups = {addGroup.class}, message = "家庭id不能为空")
    private String familyId;

    /**
     * 家庭成员id
     */
    private String familyMemberId;

    /**
     * 用户id
     */
    private String userId;

    private Integer remindDays;

}
