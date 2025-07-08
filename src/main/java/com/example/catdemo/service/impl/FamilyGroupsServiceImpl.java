package com.example.catdemo.service.impl;

import com.example.catdemo.entity.FamilyGroups;
import com.example.catdemo.entity.FamilyGroupsExample;
import com.example.catdemo.entity.FamilyMember;
import com.example.catdemo.entity.FamilyMemberExample;
import com.example.catdemo.mapper.FamilyGroupsMapper;
import com.example.catdemo.mapper.FamilyMemberMapper;
import com.example.catdemo.service.FamilyGroupsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 家庭群组表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-03-06 17:37
 */
@Service
public class FamilyGroupsServiceImpl implements FamilyGroupsService {


    @Autowired
    FamilyGroupsMapper familyGroupsMapper;

    @Autowired
    FamilyMemberMapper familyMemberMapper;

    @Autowired
    FamilyMemberServiceImpl familyMemberService;

    /**
     * 创建家庭群组
     *
     * @param familyGroups 家庭群组信息对象，包含群组名称、成员列表等详细信息
     * @return Response 返回响应对象
     */
    @Override
    public Response createFamilyGroups(FamilyGroups familyGroups) {
        if (familyGroups == null) {
            return Response.error("参数不能为空");
        }
        // 先添加用户
        if(!CollectionUtils.isEmpty(familyGroups.getFamilyMemberList())){
            List<FamilyMember> familyMembers = familyGroups.getFamilyMemberList();
            // 判断是否有户主，且户主的个数只能为1
            if(familyMembers.stream().noneMatch(familyMember -> "01".equals(familyMember.getRole()))){
                return Response.error("家庭成员中必须有户主");
            }
            if(familyMembers.stream().filter(familyMember -> "01".equals(familyMember.getRole())).count() > 1){
                return Response.error("家庭成员中不能有多个户主");
            }
            // 户主信息
            FamilyMember headOfHouse = familyMembers.stream().filter(familyMember -> "01".equals(familyMember.getRole())).findFirst().orElse(null);

            List<FamilyMember> members = familyMembers.stream().filter(familyMember -> !"01".equals(familyMember.getRole())).toList();

            familyGroups.setId(UUID.randomUUID().toString());
            int result = familyGroupsMapper.insert(familyGroups);
            if(result == 1){
                if(headOfHouse != null){
                    headOfHouse.setMemberId(UUID.randomUUID().toString());
                    headOfHouse.setFamilyGroupsId(familyGroups.getId());
                    headOfHouse.setRelationship("本人");
                    headOfHouse.setUserId(familyGroups.getCreatedBy());
                    familyMemberService.createFamilyMember(headOfHouse);
                }
                if(!CollectionUtils.isEmpty(members)){
                    for(FamilyMember member : members){
                        member.setMemberId(UUID.randomUUID().toString());
                        member.setFamilyGroupsId(familyGroups.getId());
                        familyMemberService.createFamilyMember(member);
                    }
                }
                return Response.success("创建家庭组成功");
            } else {
                return Response.error("创建家庭组失败");
            }
        }
        return Response.noDateSuccess();
    }

    @Override
    public Response updateFamilyGroups(FamilyGroups familyGroups) {
        return null;
    }

    @Override
    public Response deleteFamilyGroups(String familyGroupsId) {
        return null;
    }


    @Override
    public Response getFamilyGroupss() {
        return null;
    }


    @Override
    public Response getFamilyGroupss(FamilyGroups familyGroups) {
        return null;
    }


    @Override
    public Response getFamilyGroups(String familyGroupsId) {
        return null;
    }


    @Override
    public Response getFamilyGroups(FamilyGroups familyGroups) {
        return null;
    }


    @Override
    public Response queryFamilyGroupsAndMembers(FamilyGroups familyGroups) {
        List<FamilyGroups> returnFamilyGroupsList = new ArrayList<>();
        // 先根据户主id查询家庭信息，在根据家庭id查询成员信息
        if(familyGroups == null || familyGroups.getOwnerId() == null){
            return Response.error("参数不能为空");
        }
        FamilyGroupsExample example = new FamilyGroupsExample();
        example.createCriteria().andOwnerIdEqualTo(familyGroups.getOwnerId());
        List<FamilyGroups> familyGroupsList = familyGroupsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(familyGroupsList)){
            return Response.noDateSuccess();
        }
        for(FamilyGroups familyGroup : familyGroupsList){
            FamilyMemberExample familyMemberExample = new FamilyMemberExample();
            familyMemberExample.createCriteria().andFamilyGroupsIdEqualTo(familyGroup.getId());
            List<FamilyMember> familyMemberList = familyMemberMapper.selectByExample(familyMemberExample);
            familyGroup.setFamilyMemberList(familyMemberList);
            returnFamilyGroupsList.add(familyGroup);
        }
        return Response.success(returnFamilyGroupsList);
    }

    @Override
    public Response queryFamilyGroupsByUserId(FamilyMember familyMember) {
        List<FamilyGroups> returnFamilyGroupsList = new ArrayList<>();
        // 先只考虑单家庭，一人多家庭的后续再考虑
        // 先查用户表，查到用户所属家庭id，再根据家庭id查家庭信息
        if(familyMember == null || familyMember.getUserId() == null){
            return Response.error("参数不能为空");
        }
        FamilyMemberExample familyMemberExample = new FamilyMemberExample();
        familyMemberExample.createCriteria().andUseridEqualTo(familyMember.getUserId());
        List<FamilyMember> familyMemberList = familyMemberMapper.selectByExample(familyMemberExample);
        if(CollectionUtils.isEmpty(familyMemberList)){
            return Response.noDateSuccess();
        }
        for (FamilyMember member : familyMemberList) {
            FamilyGroupsExample familyGroupsExample = new FamilyGroupsExample();
            familyGroupsExample.createCriteria().andIdEqualTo(familyMemberList.get(0).getFamilyGroupsId());
            List<FamilyGroups> familyGroupsList = familyGroupsMapper.selectByExample(familyGroupsExample);
            if(CollectionUtils.isEmpty(familyGroupsList)){
                return Response.noDateSuccess();
            }
            FamilyGroups familyGroups = familyGroupsList.get(0);
            FamilyMemberExample memberExample = new FamilyMemberExample();
            memberExample.createCriteria().andFamilyGroupsIdEqualTo(familyGroups.getId());
            List<FamilyMember> memberList = familyMemberMapper.selectByExample(memberExample);
            familyGroups.setFamilyMemberList(memberList);
            returnFamilyGroupsList.add(familyGroups);
            return Response.success(returnFamilyGroupsList);
        }
        return Response.noDateSuccess();
    }
}
