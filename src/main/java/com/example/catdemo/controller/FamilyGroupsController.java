package com.example.catdemo.controller;

import com.example.catdemo.entity.FamilyGroups;
import com.example.catdemo.entity.FamilyMember;
import com.example.catdemo.service.FamilyGroupsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 家庭群组表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-03-06 17:37
 */
@RestController
@RequestMapping("/familyGroups")
public class FamilyGroupsController {

    @Autowired
    FamilyGroupsService familyGroupsService;


    @PostMapping("/addFamilyGroups")
    public Response addFamilyGroups(@RequestBody FamilyGroups familyGroups) {
        return familyGroupsService.createFamilyGroups(familyGroups);
    }

    @PostMapping("/queryFamilyGroupsAndMembers")
    public Response queryFamilyGroupsAndMembers(@RequestBody FamilyGroups familyGroups) {
        return familyGroupsService.queryFamilyGroupsAndMembers(familyGroups);
    }

    @PostMapping("/queryFamilyGroupsByuserId")
    public Response queryFamilyGroupsByUserId(@RequestBody FamilyMember familyMember) {
        return familyGroupsService.queryFamilyGroupsByUserId(familyMember);
    }

}
