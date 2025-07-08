package com.example.catdemo.service;


import com.example.catdemo.entity.UserPoints;
import com.example.catdemo.utils.Response;

/**
 * 用户积分主表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
public interface UserPointsService {

    Response addUserPoints(UserPoints userPoints);

    Response updateUserPoints(UserPoints userPoints);

    Response deleteUserPoints(UserPoints userPoints);
    Response getUserPoints(UserPoints userPoints);


}
