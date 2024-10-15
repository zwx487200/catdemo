package com.example.catdemo.service;


import com.example.catdemo.entity.UserMembership;
import com.example.catdemo.utils.Response;

/**
 * 用户会员表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
public interface UserMembershipService {

    Response openMembership (UserMembership userMembership);

    Response queryUserMembership (UserMembership userMembership);

    Response updateUserMembership (UserMembership userMembership);

    Response closeMembership (UserMembership userMembership);

}
