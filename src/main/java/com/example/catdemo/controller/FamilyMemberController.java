package com.example.catdemo.controller;

import com.example.catdemo.entity.FamilyMember;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import com.example.catdemo.service.FamilyMemberService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-25 19:22
 */
@RestController
@RequestMapping("/familyMember")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberService familyMemberService;

    // 新增家庭成员
    @PostMapping("/addFamilyMember")
    public Response addFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.createFamilyMember(familyMember);
    }

    //查询家庭成员
    @PostMapping("/queryAllFamilyMembersByHouseholdId")
    public Response queryFamilyMembers(@RequestBody FamilyMember familyMember) {
        return familyMemberService.getFamilyMembers(familyMember);
    }

    // 查询家庭成员
    @PostMapping("/queryFamilyMemberById")
    public Response queryFamilyMemberById( @Validated(queryGroup.class) @RequestBody FamilyMember familyMember) {
        return familyMemberService.getFamilyMember(familyMember.getMemberId());
        }

    // 绑定已有家庭成员
    // 新增家庭成员
    @PostMapping("/deleteFamilyMember")
    public Response deleteFamilyMember(@Validated(deleteGroup.class) @RequestBody FamilyMember familyMember) {
        return familyMemberService.deleteFamilyMember(familyMember.getMemberId());
    }

    @PostMapping("/updateFamilyMember")
    public Response updateFamilyMember(@Validated(updateGroup.class) @RequestBody FamilyMember familyMember) {
        return familyMemberService.updateFamilyMember(familyMember);
    }




}
