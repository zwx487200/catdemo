package com.example.catdemo.controller;

import com.example.catdemo.entity.UserMembership;
import com.example.catdemo.service.UserMembershipService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户会员表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@RestController
@RequestMapping("/user-membership")
public class UserMembershipController {

    @Autowired
    private UserMembershipService userMembershipService;


    // 用户开通会员接口
    @PostMapping("/open-membership")
    public Response openMembership(@RequestBody UserMembership userMembership) {
        return userMembershipService.openMembership(userMembership);
    }

    // 查询用户会员信息接口
    @PostMapping("/query-user-membership")
    public Response queryUserMembership(@RequestBody UserMembership userMembership) {
        return userMembershipService.queryUserMembership(userMembership);
    }




}
