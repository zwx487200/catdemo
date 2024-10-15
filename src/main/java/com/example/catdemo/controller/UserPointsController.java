package com.example.catdemo.controller;

import com.example.catdemo.entity.UserPoints;
import com.example.catdemo.service.UserPointsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户积分主表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@RestController
@RequestMapping("/userPoints")
public class UserPointsController {

    @Autowired
    private UserPointsService userPointsService;

    //新增用户积分主表
    @RequestMapping("/addPoints")
    public Response addPoints(@RequestBody UserPoints userPoints) {
        return userPointsService.addUserPoints(userPoints);
    }

    //查询用户积分主表
    @RequestMapping("/queryPoints")
        public Response queryPoints(@RequestBody UserPoints userPoints) {
        return userPointsService.getUserPoints(userPoints);
    }

}
