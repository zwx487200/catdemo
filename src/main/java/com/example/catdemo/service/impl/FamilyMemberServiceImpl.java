package com.example.catdemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.FamilyMemberMapper;
import com.example.catdemo.mapper.FeatureMapper;
import com.example.catdemo.mapper.UserMapper;
import com.example.catdemo.mapper.UserSubscriptionMapper;
import com.example.catdemo.service.FamilyMemberService;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.Response;
import com.example.catdemo.utils.UniqueRandomStringGenerator;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-25 19:22
 */
@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    final static String IS_SYNC_CREATE_USER = "1";

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    private PocketbankServiceImpl pocketbankService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FeatureMapper featureMapper;

    @Autowired
    UserSubscriptionMapper userSubscriptionMapper;
    @Autowired
    private PointsChangeLogService pointsChangeLogService;

    /**
     * @param familyMember
     * @return
     */
    @Override
    public Response createFamilyMember(FamilyMember familyMember) {
        if (StringUtils.isBlank(familyMember.getFamilyGroupsId())){
            return Response.error("家庭组不能为空");
        }
        if (StringUtils.isBlank(familyMember.getName())){
            return Response.error("姓名不能为空");
        }
        if (IS_SYNC_CREATE_USER.equals(familyMember.getIsSyncCreateUser())){
            familyMember.setUserId(UUID.randomUUID().toString());
        }

            familyMember.setMemberId(UUID.randomUUID().toString());
        int result = familyMemberMapper.insertSelective(familyMember);
        if (result > 0) {
            User user = new User();
            //TODO 创建虚拟账户
            if (IS_SYNC_CREATE_USER.equals(familyMember.getIsSyncCreateUser())){
                user.setUserId(familyMember.getUserId());
                String userName = familyMember.getName();
                //校验用户名是否存在
                while (0 < userMapper.getCountbyUser(userName)){
                    userName = familyMember.getName() + UniqueRandomStringGenerator.generateRandomString(3);
                }
                user.setUsername(userName);
                String password = UniqueRandomStringGenerator.generateRandomString(8);
                familyMember.setUserName(userName);
                familyMember.setPassWord(password);
                user.setPassword(PasswordUtils.hashPassword(password));
                user.setStatus("VIRTUAL");
                user.setCreateTime(new Date(System.currentTimeMillis()));
                int addUserResult = userMapper.insertSelective(user);
                if (addUserResult > 0){
                    // 给虚拟账号分配简单的功能 , 如记账 、任务、我的这三个功能
                    FeatureExample featureExample = new FeatureExample();
                    featureExample.createCriteria().andTypeEqualTo("01");
                    List<Feature> features = featureMapper.selectByExample(featureExample);
                    if (CollectionUtils.isNotEmpty(features)){
                        for (Feature feature : features) {
                            if(feature.getIsAvailableForFamily() == 1 && feature.getAllowedFamilyRoles().contains(familyMember.getRole())){
                                addFeature(feature, user);
                            }
                        }
                    }
                }
            }
            // 零用钱银行开户
            Pocketbank pocketbank = new Pocketbank();
            pocketbank.setUserId(familyMember.getMemberId());
            pocketbank.setBalance(new BigDecimal("0.00"));
            pocketbank.setCurrentBalance(new BigDecimal("0.00"));
            pocketbank.setStatus("01");
            pocketbank.setInterestRate(new BigDecimal("0.00"));
            pocketbankService.addPocketbank(pocketbank);

            // 积分账户开户
            PointsChangeLog pointsChangeLog = new PointsChangeLog();
            pointsChangeLog.setUserId(familyMember.getMemberId());
            pointsChangeLog.setChangeAmount(new BigDecimal("0.00"));
            pointsChangeLog.setChangeType("01");
            pointsChangeLog.setChangeDesc("创建账户");
            pointsChangeLogService.addPointsChangeLog(pointsChangeLog);

            return Response.success(familyMember);
        }   else {
            return Response.error("创建失败");
        }
    }

    private void addFeature(Feature feature, User user) {
        UserSubscription userSubscription = new UserSubscription();
        userSubscription.setId(UUID.randomUUID().toString());
        userSubscription.setFeatureId(feature.getFeatureId());
        userSubscription.setUserId(user.getUserId());
        userSubscription.setSort(feature.getSort());
        userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
        userSubscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + 100L * 365 * 24 * 60 * 60 * 1000));
        userSubscription.setAutoRenew(0);
        userSubscription.setIsTrial(0);
        userSubscription.setStatus("1");
        userSubscriptionMapper.insertSelective(userSubscription);
    }

    /**
     * @param familyMember
     * @return
     */
    @Override
    public Response updateFamilyMember(FamilyMember familyMember) {
        int result = familyMemberMapper.updateByPrimaryKeySelective(familyMember);
        if (result > 0) {
            return Response.success("更新成功");
        } else {
            return Response.error("更新失败");
        }
    }

    /**
     * @param familyMemberId
     * @return
     */
    @Override
    public Response deleteFamilyMember(String familyMemberId) {
        int result = familyMemberMapper.deleteByPrimaryKey(familyMemberId);
        if (result > 0) {
            return Response.success("删除成功");
        } else {
            return Response.error("删除失败");
        }
    }

    /**
     * @return
     */
    @Override
    public Response getFamilyMembers() {
        return null;
    }

    /**
     * @param familyMember
     * @return
     */
    @Override
    public Response getFamilyMembers(FamilyMember familyMember) {


        FamilyMemberExample example = new FamilyMemberExample();
        FamilyMemberExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(familyMember.getMemberId())) {
            criteria.andMemberIdEqualTo(familyMember.getMemberId());
        }
        if (StringUtils.isNotBlank(familyMember.getFamilyGroupsId())) {
            criteria.andFamilyGroupsIdEqualTo(familyMember.getFamilyGroupsId());
        }
        if (StringUtils.isNotBlank(familyMember.getUserId())) {
            criteria.andUseridEqualTo(familyMember.getUserId());
        }
        if (StringUtils.isNotBlank(familyMember.getRelationship())) {
            criteria.andRelationshipEqualTo(familyMember.getRelationship());
        }
        List<FamilyMember> familyMembers = familyMemberMapper.selectByExample(example);
        return Response.success(familyMembers);
    }

    /**
     * @param familyMemberId
     * @return
     */
    @Override
    public Response getFamilyMember(String familyMemberId) {
        FamilyMember familyMember = familyMemberMapper.selectByPrimaryKey(familyMemberId);
        return Response.success(familyMember);
    }

    /**
     * @param familyMember
     * @return
     */
    @Override
    public Response getFamilyMember(FamilyMember familyMember) {
        return null;
    }
}
