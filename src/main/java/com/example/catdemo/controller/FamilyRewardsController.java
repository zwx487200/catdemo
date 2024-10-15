package com.example.catdemo.controller;

import com.example.catdemo.entity.FamilyRewards;
import com.example.catdemo.service.FamilyRewardsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2025-04-21 14:29
 */
@RestController
@RequestMapping("/familyRewards")
public class FamilyRewardsController {

    @Autowired
    private FamilyRewardsService familyRewardsService;

    @RequestMapping("/queryFamilyRewards")
    public Response queryFamilyRewards(@RequestBody FamilyRewards  familyRewards) {
        return familyRewardsService.getFamilyRewards(familyRewards);
    }

    @RequestMapping("/addFamilyRewards")
    public Response addFamilyRewards(@RequestBody FamilyRewards familyRewards) {
        return familyRewardsService.addFamilyRewards(familyRewards);
    }

    @RequestMapping("/deleteFamilyRewards")
    public Response deleteFamilyRewards(@RequestBody FamilyRewards familyRewards) {
        return familyRewardsService.deleteFamilyRewards(familyRewards.getId());
        }

    @RequestMapping("/updateFamilyRewards")
    public Response updateFamilyRewards(@RequestBody FamilyRewards familyRewards) {
        return familyRewardsService.updateFamilyRewards(familyRewards);
    }

}
