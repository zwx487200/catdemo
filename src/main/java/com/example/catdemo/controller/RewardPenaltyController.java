package com.example.catdemo.controller;

import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.catdemo.entity.RewardPenalty;
import com.example.catdemo.service.RewardPenaltyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-09 14:40
 */
@Api(tags = "前端控制器")
@RestController
@RequestMapping("/rewardPenalty")
public class RewardPenaltyController {

    @Autowired
    private RewardPenaltyService rewardPenaltyService;

    /**
     * 添加奖罚记录
     *
     * @param rewardPenalty 奖罚记录
     * @return 添加结果
     */
    @ApiOperation(value = "添加奖罚记录")
    @PostMapping
    public Response addRewardPenalty(@RequestBody RewardPenalty rewardPenalty) {
        return rewardPenaltyService.addRewardPenalty(rewardPenalty);
    }

    /**
     * 删除奖罚记录
     *
     * @param id 奖罚记录ID
     * @return 删除结果
     */
    @ApiOperation(value = "删除奖罚记录")
    @DeleteMapping("/{id}")
    public Response deleteRewardPenalty(@PathVariable int id) {
        return  rewardPenaltyService.deleteRewardPenalty(id);
    }

    /**
     * 更新奖罚记录
     *
     * @param rewardPenalty 奖罚记录
     * @return 更新结果
     */
    @ApiOperation(value = "更新奖罚记录")
    @PostMapping("/updateRewardPenalty")
    public Response updateRewardPenalty(@RequestBody RewardPenalty rewardPenalty) {
        return rewardPenaltyService.updateRewardPenalty(rewardPenalty);
    }

    /**
     * 根据ID查找奖罚记录
     *
     * @param familyMemberId 家人ID
     * @return 奖罚记录
     */
    @ApiOperation(value = "根据ID查找奖罚记录")
    @GetMapping("/{familyMemberId}")
    public Response getRewardPenaltyById(@PathVariable String familyMemberId) {
        return rewardPenaltyService.getRewardPenaltyByfamilyMemberId(familyMemberId);
    }

    /**
     * 查询所有奖罚记录
     *
     * @return 奖罚记录列表
     */
    @ApiOperation(value = "查询所有奖罚记录")
    @PostMapping("/getAllRewardPenalties")
    public Response getAllRewardPenalties(@RequestBody RequestInfo requestInfo) {
        Response  response= rewardPenaltyService.getAllRewardPenalties(requestInfo);
        return response;
    }

    /**
     * 批量添加奖罚记录
     *
     * @param rewardPenalties 奖罚记录列表
     * @return 添加结果
     */
    @ApiOperation(value = "批量添加奖罚记录")
    @PostMapping("/batch")
    public Response addBatchRewardPenalties(@RequestBody List<RewardPenalty> rewardPenalties) {
        return rewardPenaltyService.addBatchRewardPenalties(rewardPenalties);
    }

    /**
     * 批量删除奖罚记录
     *
     * @param ids 奖罚记录ID列表
     * @return 删除结果
     */
    @ApiOperation(value = "批量删除奖罚记录")
    @DeleteMapping("/batch")
    public Response deleteBatchRewardPenalties(@RequestBody List<Integer> ids) {
        return rewardPenaltyService.deleteBatchRewardPenalties(ids);
    }
}

