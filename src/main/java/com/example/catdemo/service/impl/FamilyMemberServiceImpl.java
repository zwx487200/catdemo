package com.example.catdemo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.FamilyMemberMapper;
import com.example.catdemo.mapper.FeatureMapper;
import com.example.catdemo.mapper.UserMapper;
import com.example.catdemo.mapper.UserSubscriptionMapper;
import com.example.catdemo.service.BirthdayService;
import com.example.catdemo.service.FamilyMemberService;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.Response;
import com.example.catdemo.utils.UniqueRandomStringGenerator;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * 家庭成员服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-25 19:22
 */
@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private static final String IS_SYNC_CREATE_USER = "1";
    private static final String DEFAULT_STATUS = "01";
    private static final String VIRTUAL_STATUS = "VIRTUAL";
    private static final String SUCCESS_MESSAGE = "操作成功";
    private static final String FAIL_MESSAGE = "操作失败";
    private static final BigDecimal ZERO_AMOUNT = new BigDecimal("0.00");
    private static final long ONE_HUNDRED_YEARS_MILLIS = 100L * 365 * 24 * 60 * 60 * 1000;

    @Autowired
    private FamilyMemberMapper familyMemberMapper;

    @Autowired
    private PocketbankServiceImpl pocketbankService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FeatureMapper featureMapper;

    @Autowired
    private UserSubscriptionMapper userSubscriptionMapper;

    @Autowired
    private PointsChangeLogService pointsChangeLogService;

    @Autowired
    private BirthdayService birthdayService;


    /**
     * 创建家庭成员
     *
     * @param familyMember 家庭成员信息
     * @return Response 创建结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response createFamilyMember(FamilyMember familyMember) {
        try {
            // 生成唯一ID
            String memberId = UUID.randomUUID().toString();
            familyMember.setMemberId(memberId);
            if (StringUtils.isBlank(familyMember.getUserId())){
                familyMember.setUserId(UUID.randomUUID().toString());
            }
            // 保存家庭成员信息
            if (familyMemberMapper.insertSelective(familyMember) <= 0) {
                return Response.error(FAIL_MESSAGE);
            }

            // 创建零用钱账户
            createPocketbankAccount(memberId);

            // 创建积分账户
            createPointsAccount(memberId);

            // 创建用户生日
            if(familyMember.getBirthDate()!=null){
                Birthday birthday = new Birthday();
                birthday.setName(familyMember.getName());
                birthday.setDate(familyMember.getBirthDate());
                birthday.setDescription(familyMember.getName() +"生日");
                birthday.setUserId(memberId);
                birthday.setFamilyMemberId(memberId);
                birthday.setRemindDays(0);
                birthday.setFamilyId(familyMember.getFamilyGroupsId());
                birthdayService.addBirthday(birthday);
            }

            // 同步创建用户账号
            if (IS_SYNC_CREATE_USER.equals(familyMember.getIsSyncCreateUser())) {
                createUserAccount(familyMember);
            }

            return Response.success(familyMember);
        } catch (Exception e) {
            throw new RuntimeException("创建家庭成员失败: " + e.getMessage(), e);
        }
    }

    /**
     * 创建零用钱账户
     */
    private void createPocketbankAccount(String memberId) {
        Pocketbank pocketbank = new Pocketbank();
        pocketbank.setUserId(memberId);
        pocketbank.setBalance(ZERO_AMOUNT);
        pocketbank.setCurrentBalance(ZERO_AMOUNT);
        pocketbank.setStatus(DEFAULT_STATUS);
        pocketbank.setInterestRate(ZERO_AMOUNT);

        Response response = pocketbankService.addPocketbank(pocketbank);
        if (!Response.isSuccess(response)) {
            throw new RuntimeException("零用钱账户创建失败");
        }
    }

    /**
     * 创建积分账户
     */
    private void createPointsAccount(String memberId) {
        PointsChangeLog pointsChangeLog = new PointsChangeLog();
        pointsChangeLog.setUserId(memberId);
        pointsChangeLog.setChangeAmount(ZERO_AMOUNT);
        pointsChangeLog.setChangeType(DEFAULT_STATUS);
        pointsChangeLog.setChangeDesc("创建账户");

        Response response = pointsChangeLogService.addPointsChangeLog(pointsChangeLog);
        if (!Response.isSuccess(response)) {
            throw new RuntimeException("积分账户创建失败");
        }
    }

    /**
     * 创建用户账号
     */
    private void createUserAccount(FamilyMember familyMember) {
        User user = new User();
        String memberId = familyMember.getUserId();
        if (memberId == null) {
            memberId = UUID.randomUUID().toString();
            familyMember.setUserId(memberId);
        }

        user.setUserId(memberId);
        String userName = generateUniqueUsername(familyMember.getName());
        user.setUsername(userName);
        
        String password = UniqueRandomStringGenerator.generateRandomString(8);
        familyMember.setUserName(userName);
        familyMember.setPassWord(password);
        
        user.setPassword(PasswordUtils.hashPassword(password));
        user.setStatus(VIRTUAL_STATUS);
        user.setCreateTime(new Date(System.currentTimeMillis()));

        if (userMapper.insertSelective(user) <= 0) {
            throw new RuntimeException("用户同步创建失败");
        }

        assignFeaturesToUser(user, familyMember.getRole());
    }

    /**
     * 生成唯一用户名
     */
    private String generateUniqueUsername(String baseName) {
        String userName = baseName;
        while (userMapper.getCountbyUser(userName) > 0) {
            userName = baseName + UniqueRandomStringGenerator.generateRandomString(3);
        }
        return userName;
    }

    /**
     * 为用户分配功能权限
     */
    private void assignFeaturesToUser(User user, String role) {
        FeatureExample featureExample = new FeatureExample();
        featureExample.createCriteria().andTypeEqualTo(DEFAULT_STATUS).andStatusEqualTo("1");
        List<Feature> features = featureMapper.selectByExample(featureExample);

        if (CollectionUtils.isNotEmpty(features)) {
            features.stream()
                .filter(feature -> feature.getIsAvailableForFamily() == 1 
                    && feature.getAllowedFamilyRoles().contains(role))
                .forEach(feature -> addFeature(feature, user));
        }
    }

    /**
     * 添加功能订阅
     */
    private void addFeature(Feature feature, User user) {
        UserSubscription subscription = new UserSubscription();
        subscription.setId(UUID.randomUUID().toString());
        subscription.setFeatureId(feature.getFeatureId());
        subscription.setUserId(user.getUserId());
        subscription.setSort(feature.getSort());
        subscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
        subscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + ONE_HUNDRED_YEARS_MILLIS));
        subscription.setAutoRenew(0);
        subscription.setIsTrial(0);
        subscription.setStatus("1");
        userSubscriptionMapper.insertSelective(subscription);
    }

    /**
     * 更新家庭成员信息
     */
    @Override
    public Response updateFamilyMember(FamilyMember familyMember) {
        return familyMemberMapper.updateByPrimaryKeySelective(familyMember) > 0 
            ? Response.success(SUCCESS_MESSAGE) 
            : Response.error(FAIL_MESSAGE);
    }

    /**
     * 删除家庭成员
     */
    @Override
    public Response deleteFamilyMember(String familyMemberId) {
        return familyMemberMapper.deleteByPrimaryKey(familyMemberId) > 0 
            ? Response.success(SUCCESS_MESSAGE) 
            : Response.error(FAIL_MESSAGE);
    }

    /**
     * 获取所有家庭成员
     */
    @Override
    public Response getFamilyMembers() {
        return Response.success(familyMemberMapper.selectByExample(new FamilyMemberExample()));
    }

    /**
     * 根据条件查询家庭成员
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

        return Response.success(familyMemberMapper.selectByExample(example));
    }

    /**
     * 根据ID获取家庭成员
     */
    @Override
    public Response getFamilyMember(String familyMemberId) {
        return Response.success(familyMemberMapper.selectByPrimaryKey(familyMemberId));
    }

    /**
     * 根据条件获取家庭成员
     */
    @Override
    public Response getFamilyMember(FamilyMember familyMember) {
        return getFamilyMembers(familyMember);
    }
}
