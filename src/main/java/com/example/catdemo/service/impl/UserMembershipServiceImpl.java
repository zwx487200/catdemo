package com.example.catdemo.service.impl;

import com.example.catdemo.entity.MembershipLog;
import com.example.catdemo.entity.User;
import com.example.catdemo.entity.UserMembership;
import com.example.catdemo.mapper.UserMapper;
import com.example.catdemo.mapper.UserMembershipMapper;
import com.example.catdemo.service.UserService;
import com.example.catdemo.service.MembershipLogService;
import com.example.catdemo.service.UserMembershipService;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * 用户会员表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Service
public class UserMembershipServiceImpl implements UserMembershipService {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private UserMembershipMapper userMembershipMapper;

    @Autowired
    MembershipLogService membershipLogService;
    /**
     * 开通会员
     */
    @Override
    public Response openMembership(UserMembership userMembership) {
        String error = checkUser(userMembership);
        if (StringUtils.isNotBlank(error)) {
            return Response.error(error);
        }
        setStartAndEndDate(userMembership);
        userMembership.setMembershipStatus(1);
        userMembership.setMembershipId(UUID.randomUUID().toString());
        int result = userMembershipMapper.insertSelective(userMembership);

        if (result == 1) {
            // 更新用户表中的会员状态
            User user = new User();
            user.setUserId(userMembership.getUserId());
            user.setMemberShip("1");
            userMapper.updateByPrimaryKeySelective(user);
            // 记录日志
            MembershipLog membershipLog = new MembershipLog();
            membershipLog.setUserId(userMembership.getUserId());
            membershipLog.setMembershipId(userMembership.getMembershipId());
            membershipLog.setOperationType(1);
            membershipLogService.addMembershipLog(membershipLog);
            return Response.success("开通会员成功");
        } else {
            return Response.error("开通会员失败");
        }
    }

    /**
     * @param userMembership userMembership
     * @return Response
     */
    @Override
    public Response queryUserMembership(UserMembership userMembership) {

        return null;
    }

    /**
     * @param userMembership
     * @return
     */
    @Override
    public Response updateUserMembership(UserMembership userMembership) {
        return null;
    }

    /**
     * @param userMembership
     * @return
     */
    @Override
    public Response closeMembership(UserMembership userMembership) {
        return null;
    }

    private void setStartAndEndDate(UserMembership userMembership) {
        userMembership.setMembershipStartDate(new Date(System.currentTimeMillis()));
        if ("D".equals(userMembership.getDurationUnit())){
            userMembership.setMembershipEndDate(new Date(System.currentTimeMillis() +  24 * 60 * 60 * 1000));
        }
        else if ("W".equals(userMembership.getDurationUnit())){
            userMembership.setMembershipEndDate(new Date(System.currentTimeMillis() +  7 * 24 * 60 * 60 * 1000));
        }
        else if ("M".equals(userMembership.getDurationUnit())){
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime oneMonthLater = now.plusMonths(1);
            Date date = Date.from(oneMonthLater.atZone(ZoneId.systemDefault()).toInstant());
            userMembership.setMembershipEndDate(date);
        }
        else if ("Y".equals(userMembership.getDurationUnit())){
            // 结束时间为当前时间+1年 不是365天
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime oneYearLater = now.plusYears(1);
            Date date = Date.from(oneYearLater.atZone(ZoneId.systemDefault()).toInstant());
            userMembership.setMembershipEndDate(date);
        }
        else if ("L".equals(userMembership.getDurationUnit())){
            userMembership.setMembershipEndDate(new Date(Long.MAX_VALUE));
        } else {
            // 其他情况，默认7天
            userMembership.setDurationUnit("W");
            userMembership.setMembershipEndDate(new Date(System.currentTimeMillis() +  7 * 24 * 60 * 60 * 1000));
        }


    }

    public String checkUser(UserMembership userMembership) {
        if (userMembership == null) {
            return "用户信息不能为空";
        }
        if (StringUtils.isBlank(userMembership.getUserId())) {
            return "用户id不能为空";
        }
        User user = userMapper.selectByPrimaryKey(userMembership.getUserId());
        if (user == null) {
            return "用户不存在";
        } else {
            if ("1".equals(user.getMemberShip())) {
                return "用户已开通会员";
            } else {
                return null;
            }
        }
    }
}
