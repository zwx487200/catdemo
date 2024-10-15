package com.example.catdemo.controller;

import com.example.catdemo.entity.PetBill;
import com.example.catdemo.service.PetBillService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宠物健康档案表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@RestController
@RequestMapping("/petBill")
public class PetBillController {

    @Autowired
    PetBillService petBillService;

    @RequestMapping("/addPetBill")
    public Response addPetBill(PetBill petBill) {
        return petBillService.addPetBill(petBill);
    }

    @RequestMapping("/getPetBill")
    public Response getPetBill(PetBill petBill) {
        return petBillService.getPetBill(petBill);
    }

    @RequestMapping("/updatePetBill")
    public Response updatePetBill(PetBill petBill) {
        return petBillService.updatePetBill(petBill);
    }

    @RequestMapping("/deletePetBill")
    public Response deletePetBill(PetBill petBill) {
        return petBillService.deletePetBill(petBill);
    }

    @RequestMapping("/getPetBillList")
    public Response getPetBillList(PetBill petBill) {
        return petBillService.getPetBillList(petBill);
    }

}
