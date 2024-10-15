package com.example.catdemo.service;

import com.example.catdemo.entity.RewardPenalty;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 服务类接口
 *
 * @author zhanhuibin
 * @since 2024-12-09 14:40
 */
public interface RewardPenaltyService {

    /**
     * 添加奖罚记录
     *
     * @param rewardPenalty 奖罚记录
     * @return 添加结果
     */
    Response addRewardPenalty(RewardPenalty rewardPenalty);

    /**
     * 删除奖罚记录
     *
     * @param id 奖罚记录ID
     * @return 删除结果
     */
    Response deleteRewardPenalty(int id);

    /**
     * 更新奖罚记录
     *
     * @param rewardPenalty 奖罚记录
     * @return 更新结果
     */
    Response updateRewardPenalty(RewardPenalty rewardPenalty);

    /**
     * 根据ID查找奖罚记录
     *
     * @param id 奖罚记录ID
     * @return 奖罚记录
     */
    Response getRewardPenaltyById(int id);

    /**
     * 根据ID查找奖罚记录
     *
     * @param familyMemberId 奖罚记录ID
     * @return 奖罚记录
     */
    Response getRewardPenaltyByfamilyMemberId(String familyMemberId);

    /**
     * 查询所有奖罚记录
     *
     * @return 奖罚记录列表
     */
    Response getAllRewardPenalties(RequestInfo requestInfo);

    /**
     * 批量添加奖罚记录
     *
     * @param rewardPenalties 奖罚记录列表
     * @return 添加结果
     */
    Response addBatchRewardPenalties(List<RewardPenalty> rewardPenalties);

    /**
     * 批量删除奖罚记录
     *
     * @param ids 奖罚记录ID列表
     * @return 删除结果
     */
    Response deleteBatchRewardPenalties(List<Integer> ids);
}
