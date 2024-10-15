package com.example.catdemo.service.impl;

import com.example.catdemo.entity.PetBillExample;
import com.example.catdemo.entity.PetInfoExample;
import com.example.catdemo.service.PetBillService;
import com.example.catdemo.entity.PetBill;
import com.example.catdemo.mapper.PetBillMapper;
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
public class PetBillServiceImpl extends ServiceImpl<PetBillMapper, PetBill> implements PetBillService {

    @Override
    public Response addPetBill(PetBill petBill) {
        if (petBill == null){
            return Response.error("1001", "宠物健康档案不能为空");
        }
        if (petBill.getPetId() == null){
            return Response.error("1002",  "宠物ID不能为空");
        }
        if (petBill.getPetBillDate() == null){
            return Response.error("1003",  "档案日期不能为空");
        }
        if (petBill.getPetBillType() == null){
            return Response.error("1004",  "档案类型不能为空");
        }
        if (petBill.getAmount() == null){
            return Response.error("1005",  "金额不能为空");
        }
        if (petBill.getDescription() == null){
            return Response.error("1006",  "档案描述不能为空");
        }
        if (petBill.getFamilyId() == null){
            return Response.error("1007",  "家庭ID不能为空");
        }
        if (petBill.getCreatedBy() == null){
            return Response.error("1008",  "创建人不能为空");
        }

        petBill.setId(UUID.randomUUID().toString());
        petBill.setCreatedAt(new Date());
        int result = baseMapper.insertSelective(petBill);
        if (result > 0){
            return Response.success(petBill);
        } else{
            return Response.error("1009", "添加宠物健康档案失败");
        }
    }

    @Override
    public Response getPetBill(PetBill petBill) {
        if (petBill == null){
            return Response.error("1001", "宠物健康档案不能为空");
        }
        if (!StringUtils.hasLength(petBill.getId())){
            return Response.error("1002", "宠物健康档案ID不能为空");
        }
        PetBill result = baseMapper.selectByPrimaryKey(petBill.getId());
        if (result != null){
            return Response.success(result);
        } else  {
            return Response.error("1010", "宠物健康档案不存在");
        }
    }

    @Override
    public Response updatePetBill(PetBill petBill) {
        if (petBill == null){
            return Response.error("1001", "宠物健康档案不能为空");
        }
        if (!StringUtils.hasLength(petBill.getId())){
            return Response.error("1002", "宠物健康档案ID不能为空");
        }
        int result = baseMapper.updateByPrimaryKeySelective(petBill);
        if (result > 0){
            return Response.success(petBill);
        } else {
            return Response.error("1011", "更新宠物健康档案失败");
        }
    }

    @Override
    public Response deletePetBill(PetBill petBill) {
        if (petBill == null){
            return Response.error("1001", "宠物健康档案不能为空");
        }
        if (!StringUtils.hasLength(petBill.getId())){
            return Response.error("1002", "宠物健康档案ID不能为空");
        }
        int result = baseMapper.deleteByPrimaryKey(petBill.getId());
        if (result > 0){
            return Response.success("删除成功");
        } else {
            return Response.error("1012", "删除宠物健康档案失败");
        }
    }

    @Override
    public Response getPetBillList(PetBill petBill) {
        if (petBill == null){
            return Response.error("1001", "宠物健康档案不能为空");
        }
        if (!StringUtils.hasLength(petBill.getPetId()) || !StringUtils.hasLength(petBill.getFamilyId())
                || !StringUtils.hasLength(petBill.getCreatedBy())){
            return Response.error("1002", "参数不能为空");
        }
        PetBillExample example = new PetBillExample();
        if (StringUtils.hasLength(petBill.getPetId())){
            example.createCriteria().andPetIdEqualTo(petBill.getPetId());
        }
        if (StringUtils.hasLength(petBill.getFamilyId())){
            example.createCriteria().andFamilyIdEqualTo(petBill.getFamilyId());
        }
        if (StringUtils.hasLength(petBill.getCreatedBy())){
            example.createCriteria().andCreatedByEqualTo(petBill.getCreatedBy());
        }
        List<PetBill> petBillList = baseMapper.selectByExample(example);
        if (petBillList != null){
            return Response.success(petBillList);
        } else {
            return Response.error("1013", "宠物健康档案表不存在");
        }
    }
}
