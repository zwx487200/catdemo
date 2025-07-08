package com.example.catdemo.service;

import com.example.catdemo.entity.Countdown;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 倒数日 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface CountdownService extends IService<Countdown> {

    Response addCountdown(Countdown countdown);

    Response updateCountdown(Countdown countdown);

    Response deleteCountdown(String countdownId);

    Response getCountdowns(RequestInfo requestInfo);

    Response batchAddCountdowns(List<Countdown> countdowns);

    Response getCountdownById(String id);


}
