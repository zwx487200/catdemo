package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.RewardPenalty;
import com.example.catdemo.entity.RewardPenaltyExample;
import com.example.catdemo.mapper.RewardPenaltyMapper;
import com.example.catdemo.service.RewardPenaltyService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-09 14:40
 */
@Service
public class RewardPenaltyServiceImpl implements RewardPenaltyService {

    @Autowired
    private RewardPenaltyMapper rewardPenaltyMapper;

    /**
     * @param rewardPenalty 奖罚记录
     */
    @Override
    public Response addRewardPenalty(RewardPenalty rewardPenalty) {
        if (rewardPenalty == null) {
            return Response.error("奖罚记录不能为空");
        }
        if (rewardPenalty.getId() == null) {
            rewardPenalty.setId(UUID.randomUUID().toString());
        }
        int result = rewardPenaltyMapper.insertSelective(rewardPenalty);
        if (result == 1) {
            return Response.success("添加奖罚记录成功");
        }
        return Response.error("添加奖罚记录失败");
    }

    /**
     * @param id 奖罚记录ID
     */
    @Override
    public Response deleteRewardPenalty(int id) {
        int result = rewardPenaltyMapper.deleteByPrimaryKey(id);
        if (result == 1) {
            return Response.success("删除奖罚记录成功");
        }
        return Response.error("删除奖罚记录失败");
        }

    /**
     * @param rewardPenalty 奖罚记录
     */
    @Override
    public Response updateRewardPenalty(RewardPenalty rewardPenalty) {
        int result = rewardPenaltyMapper.updateByPrimaryKeySelective(rewardPenalty);
        if (result == 1) {
            return Response.success("更新奖罚记录成功");
        }
        return Response.error("更新奖罚记录失败");
    }

    /**
     * @param id 奖罚记录ID
     */
    @Override
    public Response getRewardPenaltyById(int id) {
        RewardPenalty rewardPenalty = rewardPenaltyMapper.selectByPrimaryKey(id);
        if (rewardPenalty == null) {
            return Response.error("奖罚记录不存在");
        }
        return Response.success(rewardPenalty);
    }

    @Override
    public Response getRewardPenaltyByfamilyMemberId(String familyMemberId) {
        RewardPenaltyExample example = new RewardPenaltyExample();
        example.createCriteria().andUserIdEqualTo(familyMemberId).andStatusEqualTo("01");
        List<RewardPenalty> rewardPenalties = rewardPenaltyMapper.selectByExample(example);
        return Response.success(rewardPenalties);
    }

    /**
     * @param requestInfo 请求信息
     * @return 奖罚记录列表
     */
    @Override
    public Response getAllRewardPenalties(RequestInfo requestInfo) {
        RewardPenalty rewardPenalty = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<RewardPenalty>() { });
        RewardPenaltyExample example = new RewardPenaltyExample();
        if (rewardPenalty != null) {
            if (StringUtils.isNotBlank(rewardPenalty.getRewardPenaltyType())) {
                example.createCriteria().andRewardPenaltyTypeEqualTo(rewardPenalty.getRewardPenaltyType());
            }
            if (StringUtils.isNotBlank(rewardPenalty.getStatus())) {
                example.createCriteria().andStatusEqualTo(rewardPenalty.getStatus());
            }
            if (StringUtils.isNotBlank(rewardPenalty.getContent())) {
                example.createCriteria().andContentEqualTo(rewardPenalty.getContent());
            }
            if (StringUtils.isNotBlank(rewardPenalty.getUserId())) {
                example.createCriteria().andUserIdEqualTo(rewardPenalty.getUserId());
            }
        }
        PageHelper.startPage(requestInfo.getPageNum(), requestInfo.getPageSize());
        List<RewardPenalty> rewardPenalties = rewardPenaltyMapper.selectByExample(example);
        PageInfo<RewardPenalty> pageInfo = new PageInfo<>(rewardPenalties);
        return Response.success(pageInfo);
    }

    /**
     * @param rewardPenalties 奖罚记录列表
     */
    @Override
    public Response addBatchRewardPenalties(List<RewardPenalty> rewardPenalties) {
        return null;
    }

    /**
     * @param ids 奖罚记录ID列表
     */
    @Override
    public Response deleteBatchRewardPenalties(List<Integer> ids) {
        return null;
    }
}


