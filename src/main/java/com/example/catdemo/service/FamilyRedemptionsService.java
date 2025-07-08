package com.example.catdemo.service;


import com.example.catdemo.entity.FamilyRedemptions;
import com.example.catdemo.utils.Response;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2025-04-21 20:22
 */
public interface FamilyRedemptionsService {

    Response addFamilyRedemption(FamilyRedemptions familyRedemptions);
    Response deleteFamilyRedemption(String familyRedemptionId);
    Response getFamilyRedemptions(String familyRedemptionId);
    Response getAllFamilyRedemptions();
    Response updateFamilyRedemption(FamilyRedemptions familyRedemptions);

}
