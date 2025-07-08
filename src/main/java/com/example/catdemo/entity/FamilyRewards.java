package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2025-04-21 14:29
 */
public class FamilyRewards implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 关联家庭ID
     */
    private String familyId;

    /**
     * 奖励名称（如“玩1小时游戏”）
     */
    private String rewardName;

    /**
     * 兑换所需积分（正数）
     */
    private Integer pointsNeeded;

    /**
     * 是否可兑换
     */
    private Integer isActive;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 添加人
     */
    private String createBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public Integer getPointsNeeded() {
        return pointsNeeded;
    }

    public void setPointsNeeded(Integer pointsNeeded) {
        this.pointsNeeded = pointsNeeded;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
