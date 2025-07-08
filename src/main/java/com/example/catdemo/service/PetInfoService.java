package com.example.catdemo.service;

import com.example.catdemo.entity.PetInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

/**
 * 宠物基本信息表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
public interface PetInfoService extends IService<PetInfo> {

    Response addPetInfo(PetInfo petInfo);
    Response getPetInfoById(PetInfo petInfo);
    Response updatePetInfo(PetInfo petInfo);
    Response deletePetInfo(PetInfo petInfo);
    Response getPetInfoList(RequestInfo requestInfo);


}
