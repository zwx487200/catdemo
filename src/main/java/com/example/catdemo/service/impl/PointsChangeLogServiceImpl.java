package com.example.catdemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.catdemo.entity.PointsChangeLog;
import com.example.catdemo.entity.UserPoints;
import com.example.catdemo.entity.UserPointsExample;
import com.example.catdemo.mapper.PointsChangeLogMapper;
import com.example.catdemo.mapper.UserPointsMapper;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * 积分流水表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@Service
public class PointsChangeLogServiceImpl implements PointsChangeLogService {

    @Autowired
    private UserPointsMapper userPointsMapper;

    @Autowired
    private PointsChangeLogMapper pointsChangeLogMapper;

    @Override
    public Response addPointsChangeLog(PointsChangeLog pointsChangeLog) {
        // 查询用户当前积分，如果用户当前没有积分，则创建积分记录，否则更新积分记录
        UserPointsExample example = new UserPointsExample();
        example.createCriteria().andUserIdEqualTo(pointsChangeLog.getUserId());
        List<UserPoints> userPointsList = userPointsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userPointsList)){
            // 创建积分记录
            UserPoints userPoints = new UserPoints();
            userPoints.setId(UUID.randomUUID().toString());
            userPoints.setUserId(pointsChangeLog.getUserId());
            userPoints.setTotalPoints(BigDecimal.valueOf(0));
            userPoints.setVersion(0);
            int insert = userPointsMapper.insertSelective(userPoints);
            if(insert == 1){
                // 写了调度，这里只要更新流水表就可以了
                pointsChangeLog.setLogId(UUID.randomUUID().toString());
                int logInsert = pointsChangeLogMapper.insertSelective(pointsChangeLog);
                if(logInsert == 1){
                    return Response.success("创建积分记录成功");
                } else {
                    return Response.error("创建积分记录失败");
                }
            }
        }else {
            if (userPointsList.size() != 1) {
               return Response.error("用户积分记录异常");
            }
            // 数据库写了调度，这里只要更新流水表就可以了
            pointsChangeLog.setLogId(UUID.randomUUID().toString());
            int logInsert = pointsChangeLogMapper.insertSelective(pointsChangeLog);
            if(logInsert == 1){
                return Response.success("创建积分记录成功");
            } else {
                return Response.error("用户积分记录异常");
            }
        }
        return Response.success("创建积分记录成功");
    }


    @Override
    public Response getPointsChangeLogs(PointsChangeLog pointsChangeLog) {
        return null;
    }
}
