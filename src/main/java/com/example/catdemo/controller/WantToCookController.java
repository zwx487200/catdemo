package com.example.catdemo.controller;

import com.example.catdemo.entity.WantToCook;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.service.WantToCookService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我想吃表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
@RestController
@RequestMapping("/wantToCook")
public class WantToCookController {

    @Autowired WantToCookService wantToCookService;

    @RequestMapping("/addWantToCook")
    public Response addWantToCook(@Validated(addGroup.class)  @RequestBody WantToCook wantToCook){
        return wantToCookService.addWantToCook(wantToCook);
    }

    @RequestMapping("/getWantToCookList")
    public Response getWantToCookList(@RequestBody RequestInfo requestInfo){
        return wantToCookService.getWantToCookList(requestInfo);
    }

    @RequestMapping("/updateIngredientsStatus")
    public Response updateIngredientsStatus(@RequestBody WantToCook wantToCook){
        return wantToCookService.updateIngredientsStatus(wantToCook);
    }



}
