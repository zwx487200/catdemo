package com.example.catdemo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.example.catdemo.entity.PetInfoExample;
import com.example.catdemo.service.PetInfoService;
import com.example.catdemo.entity.PetInfo;
import com.example.catdemo.mapper.PetInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 宠物基本信息表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-05-14 14:56
 */
@Service
public class PetInfoServiceImpl extends ServiceImpl<PetInfoMapper, PetInfo> implements PetInfoService {

    @Autowired
    private PetInfoMapper petInfoMapper;

    @Override
    public Response addPetInfo(PetInfo petInfo) {
        petInfo.setId(UUID.randomUUID().toString());
        petInfo.setCreateTime(new Date());
        petInfo.setUpdateTime(new Date());
        int result = petInfoMapper.insertSelective(petInfo);
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1003", "添加宠物信息失败");
        }
    }

    @Override
    public Response getPetInfoById(PetInfo petInfo) {
        PetInfo result = petInfoMapper.selectByPrimaryKey(petInfo.getId());
        if (result != null){
            return Response.success(result);
        } else {
            return Response.error("1005", "宠物信息不存在");
        }
    }


    @Override
    public Response updatePetInfo(PetInfo petInfo) {
        petInfo.setUpdateTime(new Date());
        int result = petInfoMapper.updateByPrimaryKeySelective(petInfo);
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1007", "更新宠物信息失败");
        }
    }

    @Override
    public Response deletePetInfo(PetInfo petInfo) {
        int result = petInfoMapper.deleteByPrimaryKey(petInfo.getId());
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1008", "删除宠物信息失败");
        }
    }

    @Override
    public Response getPetInfoList(RequestInfo requestInfo) {
        PetInfo petInfo =new PetInfo();
        if (requestInfo.getData() != null){
            petInfo = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<PetInfo>() { });
            if(petInfo!=null){
                if (!StringUtils.hasLength(petInfo.getOwnerId()) || !StringUtils.hasLength(petInfo.getId())){
                    return Response.error("1004", "宠物ID或所有人不能为空");
                }
            }
        }


        PetInfoExample example = new PetInfoExample();
        example.setOrderByClause("update_time desc");
        if (StringUtils.hasLength(petInfo.getId())){
            example.createCriteria().andIdEqualTo(petInfo.getId());
        }
        if (StringUtils.hasLength(petInfo.getOwnerId())){
            example.createCriteria().andOwnerIdEqualTo(petInfo.getOwnerId());
        }
        if (StringUtils.hasLength(petInfo.getPetName())){
            example.createCriteria().andPetNameLike("%" + petInfo.getPetName() + "%");
        }
        if (!CollectionUtils.isEmpty(requestInfo.getFamilyMemberIds())){
            example.createCriteria().andOwnerIdIn(requestInfo.getFamilyMemberIds());
        }
        return Response.success(petInfoMapper.selectByExample(example));
    }
}
