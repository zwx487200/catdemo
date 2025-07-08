package com.example.catdemo.service.impl;


import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.FeatureMapper;
import com.example.catdemo.mapper.UserMapper;
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

    @Autowired
    private FeatureMapper featureMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Response addUserSubscription(UserSubscription userSubscription) {
        // 先查询用户用户是否存在
        User user = userMapper.selectByPrimaryKey(userSubscription.getUserId());
        if (user == null || "DELETED".equals(user.getStatus())){
            return Response.error("用户不存在或已注销");
        }
        // 查询 功能信息
        Feature feature = featureMapper.selectByPrimaryKey(userSubscription.getFeatureId());
        if (feature == null || "2".equals(feature.getStatus())){
            return Response.error("功能不存在或已删除");
        }
        // 如果功能是01，及免费功能，订阅结束时间为2099年12月31日 23:59:59
        if (feature.getType().equals("01")){
            userSubscription.setSubscriptionEnd(new java.util.Date(2099,12,31,23,59,59));
        }
        // 先查询用户用户是否已经订阅过该功能
        UserSubscriptionExample example = new UserSubscriptionExample();
        example.createCriteria().andUserIdEqualTo(userSubscription.getUserId()).andFeatureIdEqualTo(userSubscription.getFeatureId());
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectByExample(example);
        if (!userSubscriptions.isEmpty()){
            // 正常情况下只有一条数据
            UserSubscription  oldUserSubscription = userSubscriptions.get(0);
            // 将试用改为否
            oldUserSubscription.setIsTrial(0);
            // 如果结束时间大于当前时间，则更新结束时间
            if (oldUserSubscription.getSubscriptionEnd().after(new Date(System.currentTimeMillis()))){
                // 结束时间大于当前时间，则更新结束时间
                if ("M".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionEnd().getTime() + 30L * 24 * 60 * 60 * 1000));
                }
                if ("Q".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionEnd().getTime() + 90L * 24 * 60 * 60 * 1000));
                }
                if ("Y".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionEnd().getTime() + 365L * 24 * 60 * 60 * 1000));
                }

            } else {
                // 否则更新开始时间和结束时间
                oldUserSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
                if ("M".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionStart().getTime() + 30L * 24 * 60 * 60 * 1000));
                }
                if ("Q".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionStart().getTime() + 90L * 24 * 60 * 60 * 1000));
                }
                if ("Y".equals(userSubscription.getSubscriptionDurationType())){
                    oldUserSubscription.setSubscriptionEnd(new Date(oldUserSubscription.getSubscriptionStart().getTime() + 365L * 24 * 60 * 60 * 1000));
                }
            }
            oldUserSubscription.setStatus("1");
            userSubscriptionMapper.updateByPrimaryKeySelective(oldUserSubscription);
            return Response.success(oldUserSubscription);
        } else {
            userSubscription.setId(UUID.randomUUID().toString());
            userSubscription.setStatus("1");
            userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
            if ("M".equals(userSubscription.getSubscriptionDurationType())){
                userSubscription.setSubscriptionEnd(new Date(userSubscription.getSubscriptionStart().getTime() + 30L * 24 * 60 * 60 * 1000));
            }
            if ("Q".equals(userSubscription.getSubscriptionDurationType())){
                userSubscription.setSubscriptionEnd(new Date(userSubscription.getSubscriptionStart().getTime() + 90L * 24 * 60 * 60 * 1000));
            }
            if ("Y".equals(userSubscription.getSubscriptionDurationType())){
                userSubscription.setSubscriptionEnd(new Date(userSubscription.getSubscriptionStart().getTime() + 365L * 24 * 60 * 60 * 1000));
            }
            userSubscriptionMapper.insertSelective(userSubscription);
            return Response.success(userSubscription);
        }
    }


    @Override
    public Response addUserSubscriptionProbation(UserSubscription userSubscription) {

        // 查询用户目前的订阅
        UserSubscriptionExample example = new UserSubscriptionExample();
        example.createCriteria().andUserIdEqualTo(userSubscription.getUserId());
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectByExample(example);
        for (UserSubscription userSubscription1 : userSubscriptions){
            if (userSubscription1.getFeatureId().equals(userSubscription.getFeatureId()) && userSubscription1.getIsTrial() == 1){
                if("0".equals(userSubscription1.getStatus())){
                    return Response.error("您的试用已经过期,请重新订阅");
                }
                return Response.error("您正在试用该功能,无法重新试用");
            }
            if (userSubscription1.getFeatureId().equals(userSubscription.getFeatureId()) && userSubscription1.getIsTrial() == 0){
                return Response.error("您已订阅过该功能,请勿重复订阅");
            }
        }
        int count = userSubscriptions.size();
        userSubscription.setId(UUID.randomUUID().toString());
        userSubscription.setSort(count+1);
        userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
        userSubscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000));
        userSubscription.setAutoRenew(0);
        userSubscription.setIsTrial(1);
        userSubscription.setStatus("1");
        userSubscriptionMapper.insertSelective(userSubscription);
        return Response.success(userSubscription);
    }


    @Override
    public Response deleteUserSubscription(UserSubscription userSubscription) {
        int count = userSubscriptionMapper.deleteByPrimaryKey(userSubscription.getId());
        if (count == 0) {
            return Response.error("User subscription not found");
        } else {
            return Response.noDateSuccess();
        }
    }


    @Override
    public Response getUserSubscriptions(UserSubscription userSubscription) {
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectUserSubscriptionsWithFeature(userSubscription);
        return Response.success(userSubscriptions);
    }


    @Override
    public Response updateUserSubscription(UserSubscription userSubscription) {
        return null;
    }


    @Override
    public Response getSubscriptionByUserId(String userId) {
        return null;
    }


    @Override
    public Response getSubscriptionBySubscriptionId(String subscriptionId) {
         UserSubscription example = new UserSubscription();
         example.setId(subscriptionId);
        List<UserSubscription> userSubscriptions = userSubscriptionMapper.selectUserSubscriptionsWithFeature(example);
        if (userSubscriptions.isEmpty()) {
            return Response.error("User subscription not found");
            }
        else {
            return Response.success(userSubscriptions.get(0));
            }
        }


    @Override
    public Response getSubscriptionByUserIdAndSubscriptionId(String userId, String subscriptionId) {
        return null;
    }

    @Override
    public Response getUserNotSubscriptionByUserId(String userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null || "DELETED".equals(user.getStatus())){
            return Response.error("用户不存在或已注销");
        }

        // 先查所有的Feature，在查用户的Feature，剩下的就是用户没有订阅的Feature
        FeatureExample featureExample = new FeatureExample();
        featureExample.createCriteria().andStatusEqualTo("1");
        List<Feature> featureList = featureMapper.selectByExample(featureExample);

        UserSubscriptionExample userSubscriptionExample = new UserSubscriptionExample();
        userSubscriptionExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo("1");
        List<UserSubscription> userSubscriptionList = userSubscriptionMapper.selectByExample(userSubscriptionExample);

        for (UserSubscription userSubscription : userSubscriptionList) {
            for (Feature feature : featureList) {
                if (userSubscription.getFeatureId().equals(feature.getFeatureId())) {
                    featureList.remove(feature);
                    break;
                }
            }
        }
        return Response.success(featureList);
    }
}
