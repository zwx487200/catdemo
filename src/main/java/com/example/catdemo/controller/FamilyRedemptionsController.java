package com.example.catdemo.controller;

import com.example.catdemo.entity.FamilyRedemptions;
import com.example.catdemo.service.FamilyRedemptionsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2025-04-21 20:22
 */
@RestController
@RequestMapping("/familyRedemptions")
public class FamilyRedemptionsController {

    @Autowired
    FamilyRedemptionsService familyRedemptionsService;

    @RequestMapping("/addFamilyRedemption")
    public Response addFamilyRedemption(@RequestBody FamilyRedemptions familyRedemption) {
        return familyRedemptionsService.addFamilyRedemption(familyRedemption);
    }

}
