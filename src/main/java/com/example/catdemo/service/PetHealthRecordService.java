package com.example.catdemo.service;

import com.example.catdemo.entity.PetHealthRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.Response;

/**
 * 宠物健康档案表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
public interface PetHealthRecordService extends IService<PetHealthRecord> {

    Response addRecord(PetHealthRecord record);
    Response updateRecord(PetHealthRecord record);
    Response deleteRecord(String id);
    Response getRecord(String id);
    Response getRecords(PetHealthRecord record);


}
