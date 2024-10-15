package com.example.catdemo.service.impl;

import com.example.catdemo.entity.UserSubscription;
import com.example.catdemo.entity.UserSubscriptionExample;
import com.example.catdemo.mapper.UserSubscriptionMapper;
import com.example.catdemo.service.UserSubscriptionService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户订阅表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-02-18 10:04
 */
@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    @Autowired
    private UserSubscriptionMapper userSubscriptionMapper;

    /**
     * 添加用户订阅信息
     * @param userSubscription 用户订阅信息
     * @return 响应结果
     */
    @Override
    public Response addUserSubscription(UserSubscription userSubscription) {
        check(userSubscription);
        userSubscription.setId(UUID.randomUUID().toString());
        userSubscription.setStatus("1");
        userSubscriptionMapper.insertSelective(userSubscription);
        return Response.success(userSubscription);
    }

    /**
     * 添加用户订阅信息
     * @param userSubscription 用户订阅信息
     * @return
     */
    @Override
    public Response addUserSubscriptionProbation(UserSubscription userSubscription) {
        check(userSubscription);
        // 查询用户目前的订阅
        UserSubscriptionExample example = new UserSubscriptionExample();
        example.createCriteria().andUserIdEqualTo(userSubscription.getUserId());
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectByExample(example);
        int count = userSubscriptions.size();
        userSubscription.setId(UUID.randomUUID().toString());
        userSubscription.setSort(count+1);
        userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
        userSubscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
        userSubscription.setAutoRenew(0);
        userSubscription.setIsTrial(1);
        userSubscription.setStatus("1");
        userSubscriptionMapper.insertSelective(userSubscription);
        return Response.success(userSubscription);
    }

    /**
     * @param userSubscription
     * @return
     */
    @Override
    public Response deleteUserSubscription(UserSubscription userSubscription) {
        int count = userSubscriptionMapper.deleteByPrimaryKey(userSubscription.getId());
        if (count == 0) {
            return Response.error("User subscription not found");
        } else {
            return Response.noDateSuccess();
        }
    }

    /**
     * @param userSubscription
     * @return
     */
    @Override
    public Response getUserSubscriptions(UserSubscription userSubscription) {
        UserSubscriptionExample example = new UserSubscriptionExample();
        UserSubscriptionExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userSubscription.getUserId());
        if (userSubscription.getFeatureId()!= null){
            criteria.andFeatureIdEqualTo(userSubscription.getFeatureId());
        }
        if (userSubscription.getId()!= null) {
            criteria.andIdEqualTo(userSubscription.getId());
        }
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectUserSubscriptionsWithFeature(example);
        return Response.success(userSubscriptions);
    }

    /**
     * @param userSubscription
     * @return
     */
    @Override
    public Response updateUserSubscription(UserSubscription userSubscription) {
        return null;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public Response getSubscriptionByUserId(String userId) {
        return null;
    }

    /**
     * @param subscriptionId
     * @return
     */
    @Override
    public Response getSubscriptionBySubscriptionId(String subscriptionId) {
        UserSubscriptionExample example = new UserSubscriptionExample();
        UserSubscriptionExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(subscriptionId);
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectUserSubscriptionsWithFeature(example);
        if (userSubscriptions.isEmpty()) {
            return Response.error("User subscription not found");
            }
        else {
            return Response.success(userSubscriptions.get(0));
            }
        }

    /**
     * @param userId
     * @param subscriptionId
     * @return
     */
    @Override
    public Response getSubscriptionByUserIdAndSubscriptionId(String userId, String subscriptionId) {
        return null;
    }

    private void check(UserSubscription userSubscription) {
        if (userSubscription == null) { throw new IllegalArgumentException("userSubscription cannot be null"); }
        if (userSubscription.getUserId() == null) { throw new IllegalArgumentException("userId cannot be null"); }
        if (userSubscription.getFeatureId() == null) { throw new IllegalArgumentException("subscriptionId cannot be null"); }

    }
}
