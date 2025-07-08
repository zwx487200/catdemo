package com.example.catdemo.entity;

import java.io.Serializable;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;


/**
 * 属性表
 *
 * @author zhanhuibin
 * @since 2025-05-10 14:50
 */
@Data
@TableName("attribute")
public class Attribute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 属性Id
     */
    @TableId(value = "id")
    @NotNull(groups = {updateGroup.class} ,message = "属性Id不能为空")
    private String id;



    /**
     * 属性Value
     */
    private String attributeValue;

    /**
     * 父级属性Id
     */
    private String fatherAttributeId;

    /**
     * 属性Type
     */
    private String attributeType;

    /**
     * 是否自定义
     */
    private Integer isCustom;

    /**
     * 所属家庭id
     */
    private String familyId;
}
