package com.example.catdemo.service;

import com.example.catdemo.entity.PetBill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.Response;

/**
 * 宠物健康档案表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
public interface PetBillService extends IService<PetBill> {

    Response addPetBill(PetBill petBill);
    Response getPetBill(PetBill petBill);
    Response updatePetBill(PetBill petBill);
    Response deletePetBill(PetBill petBill);
    Response getPetBillList(PetBill petBill);

}
