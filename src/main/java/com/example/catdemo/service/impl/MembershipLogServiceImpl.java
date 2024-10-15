package com.example.catdemo.service.impl;

import com.example.catdemo.entity.MembershipLog;
import com.example.catdemo.mapper.MembershipLogMapper;
import com.example.catdemo.service.MembershipLogService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员日志表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Service
public class MembershipLogServiceImpl implements MembershipLogService {

    @Autowired
    MembershipLogMapper membershipLogMapper;

    /**
     * @param membershipLog
     * @return
     */
    @Override
    public Response addMembershipLog(MembershipLog membershipLog) {
        int result = membershipLogMapper.insert(membershipLog);
        if (result == 1) {
            return Response.success("添加会员日志成功");
        }else {
            return Response.error("添加会员日志失败");
        }
    }
}

