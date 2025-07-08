package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 学习成绩记录表
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:02
 */
@Data
@TableName("score_record")
public class ScoreRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 家庭成员ID（需关联家庭成员表，且角色为子女）
     */
    private String familyMemberId;

    /**
     * 科目id
     */
    private String subjectId;

    /**
     * 考试类型（允许值：期中考试/期末考试/月考/模拟考/小测试）
     */
    private String examType;

    /**
     * 考试日期
     */
    private Date examDate;

    /**
     * 分制（如100/120/150分制）
     */
    private Integer scoreScale;

    /**
     * 分数（允许空，若用等级制可不填）
     */
    private BigDecimal score;

    /**
     * 等级（A，B，C，D）
     */
    private String grade;

    /**
     * 班级排名（允许空）
     */
    private Integer classRank;

    /**
     * 年级排名（允许空）
     */
    private Integer gradeRank;

    /**
     * 评语（支持长文本）
     */
    private String comment;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
