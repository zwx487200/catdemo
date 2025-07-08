package com.example.catdemo.controller;

import com.example.catdemo.entity.Countdown;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import com.example.catdemo.service.CountdownService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 倒数日 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@RestController
@RequestMapping("/countdown")
public class CountdownController {

    @Autowired
    private CountdownService countdownService;

    @RequestMapping("/addCountdown")
    public Response addCountdown(@Validated(addGroup.class) @RequestBody Countdown countdown) {
        return countdownService.addCountdown(countdown);
    }

    @RequestMapping("/updateCountdown")
    public Response updateCountdown(@Validated(updateGroup.class) @RequestBody Countdown countdown) {
        return countdownService.updateCountdown(countdown);
    }

    @RequestMapping("/deleteCountdown")
    public Response deleteCountdown(@Validated(deleteGroup.class) @RequestBody Countdown countdown) {
        return countdownService.deleteCountdown(countdown.getId());
    }

    @RequestMapping("/getCountdowns")
    public Response getCountdowns( @RequestBody RequestInfo requestInfo) {
        return countdownService.getCountdowns(requestInfo);
    }

    @RequestMapping("/getCountdownById")
    public Response getCountDownById(@Validated(queryGroup.class) @RequestBody Countdown countdown) {
        return countdownService.getCountdownById(countdown.getId());
    }
}
