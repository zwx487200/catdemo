package com.example.catdemo.service;


import com.example.catdemo.entity.FamilyInvites;
import com.example.catdemo.utils.Response;

/**
 * 家庭成员邀请码表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-03-10 09:54
 */
public interface FamilyInvitesService {

    Response createFamilyInvites(FamilyInvites familyInvites);

    Response updateFamilyInvites(FamilyInvites familyInvites);

    Response getFamilyInvites(FamilyInvites familyInvites);

    Response deleteFamilyInvites(FamilyInvites familyInvites);

}
