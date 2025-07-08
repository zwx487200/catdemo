package com.example.catdemo.service.impl;

import com.example.catdemo.entity.FamilyRedemptions;
import com.example.catdemo.mapper.FamilyRedemptionsMapper;
import com.example.catdemo.service.FamilyRedemptionsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2025-04-21 20:22
 */
@Service
public class FamilyRedemptionsServiceImpl implements FamilyRedemptionsService {

    @Autowired
    private FamilyRedemptionsMapper familyRedemptionsMapper;

    @Override
    public Response addFamilyRedemption(FamilyRedemptions familyRedemptions) {
        int result = familyRedemptionsMapper.insertSelective(familyRedemptions);
        if (result == 1) {
            return Response.success("新增成功");
        } else {
            return Response.error("新增失败");
        }
    }

    @Override
    public Response deleteFamilyRedemption(String familyRedemptionId) {
        return null;
    }

    @Override
    public Response getFamilyRedemptions(String familyRedemptionId) {
        return null;
    }

    @Override
    public Response getAllFamilyRedemptions() {
        return null;
    }

    @Override
    public Response updateFamilyRedemption(FamilyRedemptions familyRedemptions) {
        return null;
    }
}
