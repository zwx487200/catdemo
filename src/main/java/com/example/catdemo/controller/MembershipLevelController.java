package com.example.catdemo.controller;

import com.example.catdemo.entity.MembershipLevel;
import com.example.catdemo.service.MembershipLevelService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员等级表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@RestController
@RequestMapping("/membership-level")
public class MembershipLevelController {

    @Autowired
    MembershipLevelService membershipLevelService;

    @PostMapping("/getAll")
    public Response getAllMembershipLevels() {
        return membershipLevelService.getAllMembershipLevels();
    }

    @PostMapping("/add")
    public Response addMembershipLevel(@RequestBody MembershipLevel membershipLevel) {
        return membershipLevelService.addMembershipLevel(membershipLevel);
    }

}
