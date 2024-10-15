package com.example.catdemo.controller;

import com.example.catdemo.entity.FamilyInvites;
import com.example.catdemo.service.FamilyInvitesService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 家庭成员邀请码表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-03-10 09:54
 */
@RestController
@RequestMapping("/familyInvites")
public class FamilyInvitesController {

    @Autowired
    private FamilyInvitesService familyInvitesService;

    // 添加邀请码接口
    @PostMapping("/addFamilyInvites")
    public Response addInvites(@RequestBody FamilyInvites familyInvites) {
        return familyInvitesService.createFamilyInvites(familyInvites);
    }

}
