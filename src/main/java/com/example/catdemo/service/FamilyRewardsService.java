package com.example.catdemo.service;


import com.example.catdemo.entity.FamilyRewards;
import com.example.catdemo.utils.Response;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2025-04-21 14:29
 */
public interface FamilyRewardsService {

    Response addFamilyRewards(FamilyRewards familyRewards);
    Response deleteFamilyRewards(String id);
    Response updateFamilyRewards(FamilyRewards familyRewards);
    Response getFamilyRewards(FamilyRewards familyRewards);

}
