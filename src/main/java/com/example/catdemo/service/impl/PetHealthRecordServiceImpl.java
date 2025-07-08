package com.example.catdemo.service.impl;

import com.example.catdemo.entity.PetHealthRecordExample;
import com.example.catdemo.service.PetHealthRecordService;
import com.example.catdemo.entity.PetHealthRecord;
import com.example.catdemo.mapper.PetHealthRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 宠物健康档案表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@Service
public class PetHealthRecordServiceImpl extends ServiceImpl<PetHealthRecordMapper, PetHealthRecord> implements PetHealthRecordService {

    @Override
    public Response addRecord(PetHealthRecord record) {
        if (record == null) {
            return Response.error("1001", "宠物健康档案表不能为空");
        }
        if (!StringUtils.hasLength(record.getPetId()) ||
            !StringUtils.hasLength(record.getRecordType()) ||
            record.getRecordDate() == null) {
            
            String errorMessage = 
                !StringUtils.hasLength(record.getPetId()) ? "宠物ID不能为空" :
                !StringUtils.hasLength(record.getRecordType()) ? "档案类型不能为空" :
                "档案日期不能为空";
            
            String errorCode = 
                !StringUtils.hasLength(record.getPetId()) ? "1002" :
                !StringUtils.hasLength(record.getRecordType()) ? "1003" :
                "1005";
            
            return Response.error(errorCode, errorMessage);
        }
        record.setId(UUID.randomUUID().toString());
        record.setCreateTime(new Date());
        int result = baseMapper.insertSelective(record);
        if (result > 0){
            return Response.success(record);
        } else{
            return Response.error("1006", "添加宠物健康档案失败");
        }
    }

    @Override
    public Response updateRecord(PetHealthRecord record) {
        if (record == null){
            return Response.error("1001", "宠物健康档案表不能为空");
        }
        if (!StringUtils.hasLength(record.getId())){
            return Response.error("1002", "宠物健康档案表ID不能为空");
        }
        int result = baseMapper.updateByPrimaryKeySelective(record);
        if (result > 0){
            return Response.success(record);
        } else {
            return Response.error("1007", "更新宠物健康档案失败");
        }
    }

    @Override
    public Response deleteRecord(String id) {
        if (!StringUtils.hasLength(id)){
            return Response.error("1002", "宠物健康档案表ID不能为空");
        }
        int result = baseMapper.deleteByPrimaryKey(id);
        if (result > 0){
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除宠物健康档案失败");
        }
    }

    @Override
    public Response getRecord(String id) {
        if (!StringUtils.hasLength(id)){
            return Response.error("1002", "宠物健康档案表ID不能为空");
        }
        PetHealthRecord petHealthRecord = baseMapper.selectByPrimaryKey(id);
        if (petHealthRecord != null){
            return Response.success(petHealthRecord);
        } else {
            return Response.error("1009", "宠物健康档案表不存在");
        }
    }

    @Override
    public Response getRecords(PetHealthRecord record) {
        if (record == null){
            return Response.error("1001", "宠物健康档案表不能为空");
        }
        PetHealthRecordExample example = new PetHealthRecordExample();
        example.setOrderByClause("created_at desc");
        if (StringUtils.hasLength(record.getPetId())){
            example.createCriteria().andPetIdEqualTo(record.getPetId());
        }
        if (StringUtils.hasLength(record.getRecordType())){
            example.createCriteria().andRecordTypeEqualTo(record.getRecordType());
        }
        List<PetHealthRecord> records = baseMapper.selectByExample(example);
        if (records != null){
            return Response.success(records);
        } else {
            return Response.error("1010", "宠物健康档案表不存在");
        }
    }
}
