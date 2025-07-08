package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2025-04-21 20:22
 */
public class FamilyRedemptions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 关联家庭ID
     */
    private String familyId;

    /**
     * 兑换人ID
     */
    private String userId;

    /**
     * 关联奖励ID
     */
    private String rewardId;

    /**
     * 奖励的名字
     */
    private String rewardName;

    /**
     * 兑换时间
     */
    private Date redeemedAt;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public Date getRedeemedAt() {
        return redeemedAt;
    }

    public void setRedeemedAt(Date redeemedAt) {
        this.redeemedAt = redeemedAt;
    }
}
