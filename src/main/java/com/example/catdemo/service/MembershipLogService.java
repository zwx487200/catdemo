package com.example.catdemo.service;


import com.example.catdemo.entity.MembershipLog;
import com.example.catdemo.utils.Response;

/**
 * 会员日志表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
public interface MembershipLogService {

    Response addMembershipLog(MembershipLog membershipLog);

}
