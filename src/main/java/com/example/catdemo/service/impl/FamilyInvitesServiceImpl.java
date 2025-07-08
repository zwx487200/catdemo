package com.example.catdemo.service.impl;

import com.example.catdemo.entity.FamilyInvites;
import com.example.catdemo.mapper.FamilyInvitesMapper;
import com.example.catdemo.service.FamilyInvitesService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.catdemo.utils.UniqueRandomStringGenerator.generateRandomString;

/**
 * 家庭成员邀请码表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-03-10 09:54
 */
@Service
public class FamilyInvitesServiceImpl implements FamilyInvitesService {

    @Autowired
    private FamilyInvitesMapper familyInvitesMapper;

    /**
     * @param familyInvites
     * @return
     */
    @Override
    public Response createFamilyInvites(FamilyInvites familyInvites) {
        // 生成一个6位数的随机邀请码，带大小写字母和数字,校验是否存在，存在则重新生成
        String inviteCode = generateRandomString(6);
        while (familyInvitesMapper.selectByPrimaryKey(inviteCode)!= null) {
            inviteCode = generateRandomString(6);
        }
        familyInvites.setInviteCode(inviteCode);
        familyInvites.setStatus("ACTIVE");
        int result = familyInvitesMapper.insertSelective(familyInvites);
        if (result == 1) {
            return Response.success("创建成功");
        } else {
            return Response.error("创建失败");
        }
    }

    /**
     * @param familyInvites
     * @return
     */
    @Override
    public Response updateFamilyInvites(FamilyInvites familyInvites) {
        return null;
    }

    /**
     * @param familyInvites
     * @return
     */
    @Override
    public Response getFamilyInvites(FamilyInvites familyInvites) {
        return null;
    }

    /**
     * @param familyInvites
     * @return
     */
    @Override
    public Response deleteFamilyInvites(FamilyInvites familyInvites) {
        return null;
    }
}
