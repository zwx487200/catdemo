package com.example.catdemo.controller;

import com.example.catdemo.entity.UserSubscription;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.service.UserSubscriptionService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户订阅表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-02-18 10:04
 */
@RestController
@RequestMapping("/userSubscription")
public class UserSubscriptionController {

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    // 查询用户订阅表
    @PostMapping("/queryUserSubscription")
    public Response queryUserSubscription( @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.getUserSubscriptions(userSubscription);
    }

    // 新增用户订阅表
    @PostMapping("/addUserSubscription")
    public Response addUserSubscription(@Validated(addGroup.class) @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.addUserSubscription(userSubscription);
    }

    // 新增用户订阅表（试用）
    @PostMapping("/addUserSubscriptionProbation")
    public Response addUserSubscriptionProbation( @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.addUserSubscriptionProbation(userSubscription);
    }

    // 删除用户订阅表
    @PostMapping("/deleteUserSubscription")
    public Response deleteUserSubscription( @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.deleteUserSubscription(userSubscription);
    }

    // 查询用户订阅表（使用）
    @PostMapping("/queryUserSubscriptionById")
    public Response queryUserSubscriptionProbation( @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.getSubscriptionBySubscriptionId(userSubscription.getId());
    }

    // 查询用户未订阅的产品
    @PostMapping("/queryUserNotSubscriptionFeatures")
    public Response queryUserNotSubscriptionFeatures( @RequestBody UserSubscription userSubscription) {
        return  userSubscriptionService.getUserNotSubscriptionByUserId(userSubscription.getUserId());
    }


}
