package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import org.springframework.validation.annotation.Validated;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Data
@TableName("todo_repeat_instance")
public class TodoRepeatInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @NotBlank(groups = {addGroup.class},  message = "todoId不能为空")
    private String todoId;

    @NotNull(groups = {addGroup.class},  message = "实例时间不能为空")
    private Date instanceDate;

    @NotNull(groups = {addGroup.class},  message = "是否完成不能为空")
    private Integer isDone;

    private Date remindTime;
}
