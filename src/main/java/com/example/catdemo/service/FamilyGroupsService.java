package com.example.catdemo.service;


import com.example.catdemo.entity.FamilyGroups;
import com.example.catdemo.entity.FamilyMember;
import com.example.catdemo.utils.Response;

/**
 * 家庭群组表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-03-06 17:37
 */
public interface FamilyGroupsService {
    Response createFamilyGroups(FamilyGroups familyGroups);

    Response updateFamilyGroups(FamilyGroups familyGroups);

    Response deleteFamilyGroups(String familyMemberId);

    Response getFamilyGroupss();

    Response getFamilyGroupss(FamilyGroups familyGroups);

    Response getFamilyGroups(String familyMemberId);

    Response getFamilyGroups(FamilyGroups familyGroups);

    Response queryFamilyGroupsAndMembers(FamilyGroups familyGroups);

    Response queryFamilyGroupsByUserId(FamilyMember familyMember);

}
