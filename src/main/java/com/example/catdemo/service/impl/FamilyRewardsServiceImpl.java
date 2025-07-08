package com.example.catdemo.service.impl;

import com.example.catdemo.entity.FamilyRewards;
import com.example.catdemo.entity.FamilyRewardsExample;
import com.example.catdemo.mapper.FamilyRewardsMapper;
import com.example.catdemo.service.FamilyRewardsService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2025-04-21 14:29
 */
@Service
public class FamilyRewardsServiceImpl implements FamilyRewardsService {


    @Autowired
    private FamilyRewardsMapper familyRewardsMapper;

    @Override
    public Response addFamilyRewards(FamilyRewards familyRewards) {
        int result = familyRewardsMapper.insertSelective(familyRewards);
        if (result == 1) {
            return Response.success("添加成功");
        } else {
            return Response.error("添加失败");
        }
    }



    @Override
    public Response deleteFamilyRewards(String id) {
        int result = familyRewardsMapper.deleteByPrimaryKey(id);
        if (result == 1) {
            return Response.success(id);
        } else {
            return Response.error(id);
        }
    }

    @Override
    public Response updateFamilyRewards(FamilyRewards familyRewards) {
        int result = familyRewardsMapper.updateByPrimaryKeySelective(familyRewards);
        if (result == 1) {
            return Response.success("更新成功");
        } else {
            return Response.error("更新失败");
        }
    }


    @Override
    public Response getFamilyRewards(FamilyRewards familyRewards) {
        FamilyRewardsExample example = new FamilyRewardsExample();
        FamilyRewardsExample.Criteria criteria = example.createCriteria();
        if (familyRewards.getFamilyId() != null) {
            criteria.andFamilyIdEqualTo(familyRewards.getFamilyId());
        }
        return Response.success(familyRewardsMapper.selectByExample(example));
    }
}
