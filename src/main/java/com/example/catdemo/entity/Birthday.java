package com.example.catdemo.entity;

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
 * 生日表
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Data
@TableName("birthday")
@NotNull(groups = {addGroup.class, updateGroup.class, deleteGroup.class, queryGroup.class} ,message = "生日不能为空")
public class Birthday implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {queryGroup.class, updateGroup.class, deleteGroup.class}, message = "id不能为空")
    private String id;

    @NotBlank(groups = {addGroup.class}, message = "姓名不能为空")
    private String name;

    @NotNull(groups = {addGroup.class}, message = "生日不能为空")
    private Date date;

    private String description;

    private Date remindStartDate;

    /**
     * 家庭id
     */
    @NotBlank(groups = {addGroup.class}, message = "家庭id不能为空")
    private String familyId;

    /**
     * 家庭成员id
     */
    //@NotBlank(groups = {addGroup.class}, message = "家庭成员id不能为空")
    private String familyMemberId;

    /**
     * 用户id
     */
    private String userId;

    private Integer remindDays;
}
