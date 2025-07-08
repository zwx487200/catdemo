package com.example.catdemo.service;

import com.example.catdemo.entity.WxUserInfo;
import com.example.catdemo.utils.Response;

public interface IWxLoginService {
    /**
     * 微信登录
     * @param code 微信登录code
     * @return Response
     */
    Response wxLogin(String code);

    /**
     * 更新微信用户信息
     * @param wxUserInfo 微信用户信息
     * @return Response
     */
    Response updateWxUserInfo(WxUserInfo wxUserInfo);
} 