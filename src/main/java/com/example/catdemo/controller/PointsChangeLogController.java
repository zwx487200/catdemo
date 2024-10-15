package com.example.catdemo.controller;

import com.example.catdemo.entity.PointsChangeLog;
import com.example.catdemo.mapper.PointsChangeLogMapper;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分流水表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@RestController
@RequestMapping("/pointsChangeLog")
public class PointsChangeLogController {

    @Autowired
    private PointsChangeLogService pointsChangeLogService;

    @PostMapping("/addPointsChangeLog")
    public Response addPointsChangeLog(@RequestBody PointsChangeLog pointsChangeLog) {
        return  pointsChangeLogService.addPointsChangeLog(pointsChangeLog);
    }

}
