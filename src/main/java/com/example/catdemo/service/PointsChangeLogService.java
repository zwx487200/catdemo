package com.example.catdemo.service;


import com.example.catdemo.entity.PointsChangeLog;
import com.example.catdemo.utils.Response;

/**
 * 积分流水表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
public interface PointsChangeLogService {

    Response addPointsChangeLog(PointsChangeLog pointsChangeLog);

    Response getPointsChangeLogs(PointsChangeLog pointsChangeLog);

}
