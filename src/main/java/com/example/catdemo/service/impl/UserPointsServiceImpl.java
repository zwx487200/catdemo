package com.example.catdemo.service.impl;

import com.example.catdemo.entity.UserPoints;
import com.example.catdemo.entity.UserPointsExample;
import com.example.catdemo.mapper.UserPointsMapper;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.service.UserPointsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户积分主表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-04-14 09:13
 */
@Service
public class UserPointsServiceImpl implements UserPointsService {

    @Autowired
    private UserPointsMapper userPointsMapper;

    @Autowired
    private PointsChangeLogService pointsChangeLogService;

    @Override
    public Response addUserPoints(UserPoints userPoints) {
        return Response.noDateSuccess();
    }

    @Override
    public Response updateUserPoints(UserPoints userPoints) {
        return null;
    }

    @Override
    public Response deleteUserPoints(UserPoints userPoints) {
        return null;
    }

    @Override
    public Response getUserPoints(UserPoints userPoints) {
        UserPointsExample example = new UserPointsExample();
        example.createCriteria().andUserIdEqualTo(userPoints.getUserId());
        List<UserPoints> userPointsList = userPointsMapper.selectByExample(example);
        if (userPointsList.isEmpty()) {
            return Response.noDateSuccess();
        }
        return Response.success(userPointsList.get(0));
    }

}
