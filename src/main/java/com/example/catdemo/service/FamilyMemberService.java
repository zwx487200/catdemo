package com.example.catdemo.service;


import com.example.catdemo.entity.FamilyMember;
import com.example.catdemo.utils.Response;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2024-12-25 19:22
 */
public interface FamilyMemberService {

    Response createFamilyMember(FamilyMember familyMember);

    Response updateFamilyMember(FamilyMember familyMember);

    Response deleteFamilyMember(String familyMemberId);

    Response getFamilyMembers();

    Response getFamilyMembers(FamilyMember familyMember);

    Response getFamilyMember(String familyMemberId);

    Response getFamilyMember(FamilyMember familyMember);



    //

}
