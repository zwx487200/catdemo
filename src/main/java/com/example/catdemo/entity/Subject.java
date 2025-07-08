package com.example.catdemo.entity;

import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 科目字典表
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:56
 */
@Data
@TableName("subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 科目名称（唯一约束）
     */
    private String name;

    /**
     * 是否自定义科目
     */
    private Integer isCustom;

    /**
     * 所属家庭ID
     */
    private String familyId;
}
