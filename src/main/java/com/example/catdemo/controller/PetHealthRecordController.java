package com.example.catdemo.controller;

import com.example.catdemo.entity.PetHealthRecord;
import com.example.catdemo.service.PetHealthRecordService;
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
@RequestMapping("/petHealthRecord")
public class PetHealthRecordController {

    @Autowired
    private PetHealthRecordService petHealthRecordService;

    @RequestMapping("/addPetHealthRecord")
    public Response addPetHealthRecord(PetHealthRecord petHealthRecord) {
        return petHealthRecordService.addRecord(petHealthRecord);
    }

    @RequestMapping("/updatePetHealthRecord")
    public Response updatePetHealthRecord(PetHealthRecord petHealthRecord) {
        return petHealthRecordService.updateRecord(petHealthRecord);
    }

    @RequestMapping("/deletePetHealthRecord")
    public Response deletePetHealthRecord(PetHealthRecord petHealthRecord) {
        return petHealthRecordService.deleteRecord(petHealthRecord.getId());
    }

    @RequestMapping("/getPetHealthRecord")
    public Response getPetHealthRecord(PetHealthRecord petHealthRecord) {
        return petHealthRecordService.getRecord(petHealthRecord.getId());
    }

    @RequestMapping("/getPetHealthRecordList")
    public Response getPetHealthRecordList (PetHealthRecord petHealthRecord) {
        return petHealthRecordService.getRecords(petHealthRecord);
    }

}
