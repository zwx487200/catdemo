package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;


/**
 * 宠物健康档案表
 *
 * @author zhanhuibin
 * @since 2025-05-19 20:12
 */
@Data
@TableName("pet_health_record")
@NotNull(message = "宠物健康档案表不能为空")
public class PetHealthRecord implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 记录唯一ID
     */
    @TableId(value = "id")
    @NotNull(groups = {updateGroup.class, deleteGroup.class,  queryGroup.class} ,message = "记录唯一ID不能为空")
    private String id;

    /**
     * 关联宠物ID
     */
    @NotNull(groups = {addGroup.class} ,message = "关联宠物ID不能为空")
    private String petId;

    /**
     * 记录类型(1-疫苗,2-体检,3-疾病,4-用药)
     */
    @NotNull(groups = {addGroup.class} ,message = "记录类型不能为空")
    private String recordType;

    /**
     * 记录日期
     */
    private Date recordDate;

    /**
     * 医院名称
     */
    private String hospital;

    /**
     * 医生姓名
     */
    private String doctor;

    /**
     * 诊断结果
     */
    private String diagnosis;

    /**
     * 治疗方案
     */
    private String treatment;

    /**
     * 下次复诊日期
     */
    private Date nextVisitDate;

    /**
     * 费用
     */
    private BigDecimal cost;

    /**
     * 附件URL(JSON数组)
     */
    private String attachmentUrls;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime = new Date();
}
