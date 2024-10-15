package com.example.catdemo.service;


import com.example.catdemo.entity.UserSubscription;
import com.example.catdemo.utils.Response;

/**
 * 用户订阅表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-02-18 10:04
 */
public interface UserSubscriptionService {

    Response addUserSubscription(UserSubscription userSubscription);

    Response addUserSubscriptionProbation(UserSubscription userSubscription);

    Response deleteUserSubscription(UserSubscription userSubscription);

    Response getUserSubscriptions(UserSubscription userSubscription);

    Response updateUserSubscription(UserSubscription userSubscription);

    Response getSubscriptionByUserId(String userId);

    Response getSubscriptionBySubscriptionId(String subscriptionId);

    Response getSubscriptionByUserIdAndSubscriptionId(String userId, String subscriptionId);

}
