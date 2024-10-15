package com.example.catdemo.service.impl;

import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.MembershipBenefitMapper;
import com.example.catdemo.mapper.MembershipLevelMapper;
import com.example.catdemo.mapper.MembershipPriceMapper;
import com.example.catdemo.service.MembershipLevelService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

/**
 * 会员等级表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-01-12 16:03
 */
@Service
public class MembershipLevelServiceImpl implements MembershipLevelService {

    @Autowired
    private MembershipLevelMapper membershipLevelMapper;

    @Autowired
    private MembershipPriceMapper membershipPriceMapper;

    @Autowired
    private MembershipBenefitMapper membershipBenefitMapper;

    /**
     * @return
     */
    @Override
    public Response getAllMembershipLevels() {
        List<MembershipLevel> membershipLevels = membershipLevelMapper.selectByExample(null);
        if (!CollectionUtils.isEmpty(membershipLevels)) {
            for (MembershipLevel membershipLevel : membershipLevels) {
                MembershipPriceExample membershipPriceExample = new MembershipPriceExample();
                membershipPriceExample.createCriteria().andLevelIdEqualTo(membershipLevel.getLevelId());
                List<MembershipPrice> membershipPriceList = membershipPriceMapper.selectByExample(membershipPriceExample);
                if (!CollectionUtils.isEmpty(membershipPriceList)) {
                    membershipLevel.setMembershipPrices(membershipPriceList);
                }
                MembershipBenefitExample membershipBenefitExample = new MembershipBenefitExample();
                membershipBenefitExample.createCriteria().andLevelIdEqualTo(membershipLevel.getLevelId());
                List<MembershipBenefit> membershipBenefitList = membershipBenefitMapper.selectByExample(membershipBenefitExample);
                if (!CollectionUtils.isEmpty(membershipBenefitList)) {
                    membershipLevel.setMembershipBenefitList(membershipBenefitList);
                }
            }
        }
        return Response.success(membershipLevels);
    }

    /**
     * @param membershipLevel
     * @return
     */
    @Override
    public Response addMembershipLevel(MembershipLevel membershipLevel) {
        membershipLevel.setLevelId(UUID.randomUUID().toString());
        int result = membershipLevelMapper.insertSelective(membershipLevel);
        if (result == 1) {
            List<MembershipPrice> membershipPriceList = membershipLevel.getMembershipPrices();
            if (!CollectionUtils.isEmpty(membershipPriceList)) {
                for (MembershipPrice membershipPrice : membershipPriceList) {
                    membershipPrice.setPriceId(UUID.randomUUID().toString());
                    membershipPrice.setLevelId(membershipLevel.getLevelId());
                    membershipPriceMapper.insertSelective(membershipPrice);
                }
            }
            List<MembershipBenefit> membershipBenefitList = membershipLevel.getMembershipBenefitList();
            if (!CollectionUtils.isEmpty(membershipBenefitList)) {
                for (MembershipBenefit membershipBenefit : membershipBenefitList) {
                    membershipBenefit.setBenefitId(UUID.randomUUID().toString());
                    membershipBenefit.setLevelId(membershipLevel.getLevelId());
                    membershipBenefitMapper.insertSelective(membershipBenefit);
                }
            }
            return Response.success(result);
        }
        return Response.error("添加会员等级失败");
    }
}