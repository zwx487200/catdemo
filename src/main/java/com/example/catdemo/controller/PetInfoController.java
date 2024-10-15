package com.example.catdemo.controller;

import com.example.catdemo.entity.PetInfo;
import com.example.catdemo.service.PetInfoService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宠物基本信息表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@RestController
@RequestMapping("/petInfo")
public class PetInfoController {

    @Autowired
    private PetInfoService petInfoService;

    @RequestMapping("/addPetInfo")
    public Response addPetInfo(PetInfo petInfo){
        return petInfoService.addPetInfo(petInfo);
    }

    @RequestMapping("/getPetInfo")
    public Response getPetInfo(PetInfo petInfo){
        return petInfoService.getPetInfoById(petInfo);
    }

    @RequestMapping("/updatePetInfo")
    public Response updatePetInfo(PetInfo petInfo){
        return petInfoService.updatePetInfo(petInfo);
    }

    @RequestMapping("/deletePetInfo")
    public Response deletePetInfo(PetInfo petInfo){
        return petInfoService.deletePetInfo(petInfo);
    }

    @RequestMapping("/getPetInfoList")
    public Response getPetInfoList(PetInfo petInfo){
        return petInfoService.getPetInfoList(petInfo);
    }
}
