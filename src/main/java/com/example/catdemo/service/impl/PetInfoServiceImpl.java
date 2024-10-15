package com.example.catdemo.service.impl;

import com.example.catdemo.entity.PetInfoExample;
import com.example.catdemo.service.PetInfoService;
import com.example.catdemo.entity.PetInfo;
import com.example.catdemo.mapper.PetInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        if (petInfo == null){
            return Response.error("1001", "宠物信息不能为空");
        }
        if (StringUtils.hasLength(petInfo.getName())){
            return Response.error("1002", "宠物名称不能为空");
        }
        if (StringUtils.hasLength(petInfo.getOwnerId())){
            return Response.error("1006", "宠物所有人不能为空");
        }
        petInfo.setId(UUID.randomUUID().toString());
        petInfo.setCreatedAt(new Date());
        petInfo.setUpdatedAt(new Date());
        int result = petInfoMapper.insertSelective(petInfo);
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1003", "添加宠物信息失败");
        }
    }

    @Override
    public Response getPetInfoById(PetInfo petInfo) {
        if (petInfo == null){
            return Response.error("1001", "宠物信息不能为空");
        }
        if (StringUtils.hasLength(petInfo.getId())){
            return Response.error("1004", "宠物ID不能为空");
        }
        PetInfo result = petInfoMapper.selectByPrimaryKey(petInfo.getId());
        if (result != null){
            return Response.success(result);
        } else {
            return Response.error("1005", "宠物信息不存在");
        }
    }


    @Override
    public Response updatePetInfo(PetInfo petInfo) {
        if (petInfo == null){
            return Response.error("1001", "宠物信息不能为空");
        }
        if (!StringUtils.hasLength(petInfo.getId())){
            return Response.error("1004", "宠物ID不能为空");
        }
        petInfo.setUpdatedAt(new Date());
        int result = petInfoMapper.updateByPrimaryKeySelective(petInfo);
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1007", "更新宠物信息失败");
        }
    }

    @Override
    public Response deletePetInfo(PetInfo petInfo) {
        if (petInfo == null){
            return Response.error("1001", "宠物信息不能为空");
        }
        if (StringUtils.hasLength(petInfo.getId())){
            return Response.error("1004", "宠物ID不能为空");
        }
        int result = petInfoMapper.deleteByPrimaryKey(petInfo.getId());
        if (result > 0){
            return Response.success(petInfo);
        } else {
            return Response.error("1008", "删除宠物信息失败");
        }
    }

    @Override
    public Response getPetInfoList(PetInfo petInfo) {
        if (petInfo == null){
            return Response.error("1001", "宠物信息不能为空");
        }
        if (!StringUtils.hasLength(petInfo.getOwnerId()) || !StringUtils.hasLength(petInfo.getId())){
            return Response.error("1004", "宠物ID或所有人不能为空");
        }
        PetInfoExample example = new PetInfoExample();
        example.setOrderByClause("id desc");
        if (StringUtils.hasLength(petInfo.getId())){
            example.createCriteria().andIdEqualTo(petInfo.getId());
        }
        if (StringUtils.hasLength(petInfo.getOwnerId())){
            example.createCriteria().andOwnerIdEqualTo(petInfo.getOwnerId());
        }
        if (StringUtils.hasLength(petInfo.getName())){
            example.createCriteria().andNameLike("%" + petInfo.getName() + "%");
        }
        return Response.success(petInfoMapper.selectByExample(example));
    }
}
