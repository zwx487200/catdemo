package com.example.catdemo.service;


import com.example.catdemo.entity.MembershipLevel;
import com.example.catdemo.utils.Response;

/**
 * 会员等级表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
public interface MembershipLevelService {

     Response getAllMembershipLevels();

     Response addMembershipLevel(MembershipLevel membershipLevel);

}
