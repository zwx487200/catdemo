package com.example.catdemo.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.*;
import com.example.catdemo.service.UserService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.Response;
import com.example.catdemo.utils.UniqueRandomStringGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.example.catdemo.utils.UniqueRandomStringGenerator.generateRandomString;

/**
 * @author jennyzhuzhu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMembershipMapper userMembershipMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    FamilyMemberMapper familyMembeMapper;

    @Autowired
    FeatureMapper featureMapper;

    @Autowired
    UserSubscriptionMapper userSubscriptionMapper;

    @Autowired
    private FamilyMemberMapper familyMemberMapper;


    /**
     * 获取用户信息
     *
     * @param user - User object containing user details to be queried
     * @return Response object containing user details and status code
     */
    @Override
    public Response getUserDetails(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (StringUtils.isNotBlank(user.getUsername())){
            criteria.andUsernameEqualTo(user.getUsername());
        }
        if (StringUtils.isNotBlank(user.getPhone())){
            criteria.andPhoneEqualTo(user.getPhone());
        }
        if (StringUtils.isNotBlank(user.getEmail())){
            criteria.andEmailEqualTo(user.getEmail());
        }
        if (StringUtils.isNotBlank(user.getPassword())){
            criteria.andPasswordEqualTo(user.getPassword());
        }
        if (StringUtils.isNotBlank(user.getStatus())) {
            criteria.andStatusEqualTo(user.getStatus());
        }
        if (StringUtils.isNotBlank(user.getBelongTo())){
            criteria.andBelongtoEqualTo(user.getBelongTo());
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (null != users && !users.isEmpty()) {
            return Response.success(users);
        }
        return Response.error("500","用户不存在");
    }

    /**
     * 更新用户信息
     *
     * @param user - User object containing user details to be updated
     * @return Response object containing updated user details and status code
     */
    @Override
    public Response updateUserDetails(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        User newUser = userMapper.selectByPrimaryKey(user.getUserId());
        if (null != newUser) {
            return Response.success(newUser);
        }
        return Response.error("500","更新用户信息失败");
    }

    /**
     * 更新用户密码
     *
     * @param user - User object containing userId to be deleted
     * @return Response object containing status code and message
     */
    @Override
    public Response updateUserPassword(User user) {
        Response response ;
        if (null == user) {
            return Response.error("500","参数为空");
        }
        //更新密码
        userMapper.updateByPrimaryKeySelective(user);
        //查询用户
        User userinfo = userMapper.selectByPrimaryKey(user.getUserId());
        if (null!= userinfo) {
            response = Response.success(userinfo);
        } else {
            response = Response.error("500","更新密码失败");
        }
        return response;
    }

    /**
     * DELETE /user/{userId}
     * @param user - User object containing userId to be deleted
     * @return Response object containing status code and message
     */
    @Override
    public String deleteUser(User user) {
        return "";
    }

    /**
     * Create a new user
     * @param user - User object containing user details
     * @return Response object containing user details and status code
     */
    @Override
    public Response createUser(User user) {
       Response response ;
       // 根据用户电话号码查询是否存在用户，如果存在，则返回手机号码已被绑定，请更换手机号码或重新注册，如果不存在，则新增用户
        if (null != userMapper.getUserByPhone(user.getPhone())) {
           return Response.error("500","手机号码已被绑定，请更换手机号码或重新注册");
        }
        if (0 < userMapper.getCountbyUser(user.getUsername())) {
           return Response.error("500","用户已存在");
        } else {
           user.setStatus("NEW");
           user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
           if (StringUtils.isBlank(user.getUserId())) {
               user.setUserId(UUID.randomUUID().toString());
           }
           user.setCreateTime(new Date(System.currentTimeMillis()));
           userMapper.insertSelective(user);
           User userinfo = userMapper.selectByPrimaryKey(user.getUserId());
           if (null != userinfo) {
               // 注册成功后，默认往家庭成员表中插入一条数据，表示自己是家庭的管理员
//               FamilyMember familyMember = new FamilyMember();
//               familyMember.setMemberId(UUID.randomUUID().toString());
//               familyMember.setPhone(user.getPhone());
//               familyMember.setUserId(user.getUserId());
//               familyMember.setFamilyGroupsId(familyMember.getMemberId());
//               familyMember.setName(user.getUsername());
//               familyMember.setRelationship("本人");
//               familyMember.setIsSyncCreateUser("0");
//               familyMembeMapper.insert(familyMember);
//
//               // 注册成功后，给用户添加默认功能权限
//               // 查询系统默认功能
               FeatureExample featureExample = new FeatureExample();
               featureExample.createCriteria().andTypeEqualTo("01");
               List<Feature> features = featureMapper.selectByExample(featureExample);
               if (!CollectionUtils.isEmpty(features)) {
                   for (Feature feature : features) {
                       UserSubscription userSubscription = new UserSubscription();
                       userSubscription.setId(UUID.randomUUID().toString());
                       userSubscription.setFeatureId(feature.getFeatureId());
                       userSubscription.setUserId(user.getUserId());
                       userSubscription.setSort(feature.getSort());
                       userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
                       userSubscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + 100L *365 * 24 * 60 * 60 * 1000));
                       userSubscription.setAutoRenew(0);
                       userSubscription.setIsTrial(0);
                       userSubscription.setStatus("1");
                       userSubscriptionMapper.insertSelective(userSubscription);
                   }
               }
               response = Response.success(userinfo);
           } else {
               response = Response.error("500","用户新增失败");
           }
        }
        return  response;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response createVirtualAccount(User user) {
        if (null == user){
            return Response.error("500","参数为空");
        }
        if (StringUtils.isEmpty(user.getUserId())){
            user.setUserId(UUID.randomUUID().toString());
        }
        if (user.getUsername() == null ) {
            user.setUsername(UniqueRandomStringGenerator.generateRandomString(8));
        }
        //校验用户名是否存在
        while (0 < userMapper.getCountbyUser(user.getUsername())){
            user.setUsername(user.getUsername() + UniqueRandomStringGenerator.generateRandomString(3));
        }
        user.setPassword(UniqueRandomStringGenerator.generateRandomString(8));
        user.setStatus("VIRTUAL");
        user.setCreateTime(new Date(System.currentTimeMillis()));
        int addUserResult = userMapper.insertSelective(user);
        if (addUserResult > 0){
            // 给虚拟账号分配简单的功能 , 如记账 、任务、我的这三个功能
            FeatureExample featureExample = new FeatureExample();
            featureExample.createCriteria().andTypeEqualTo("01");
            List<Feature> features = featureMapper.selectByExample(featureExample);
            if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(features)){
                for (Feature feature : features) {
                    if ("账单".equals(feature.getFeatureTitleZh()) || "任务".equals(feature.getFeatureTitleZh())
                            || "我的".equals(feature.getFeatureTitleZh())) {
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
                }
            }
        }
        if (StringUtils.isNotBlank(user.getFamilyMemberId())){
            // 如果有家庭成员ID，则更新家庭成员表
            FamilyMember familyMember = familyMembeMapper.selectByPrimaryKey(user.getFamilyMemberId());
            if (null != familyMember) {
                familyMember.setUserId(user.getUserId());
                familyMembeMapper.updateByPrimaryKeySelective(familyMember);
            }
        }
        return null;
    }

    /**
     * 获取验证码
     *
     * @param captcha - Captcha object containing captcha details to be queried
     * @return Response object containing captcha details and status code
     */
    @Override
    public String validateCaptcha(String captcha) {
        return "";
    }

    /**
     * 登出
     *
     * @param user - User object containing userId to be deleted
     * @return Response object containing status code and message
     */
    @Override
    public Response logOut(User user) {
        user.setStatus("LOGOUT");
        userMapper.updateByPrimaryKeySelective(user);
        User userInfo = userMapper.selectByPrimaryKey(user.getUserId());
        if (null!= userInfo && "LOGOUT".equals(userInfo.getStatus())) {
            StpUtil.logout();
            return Response.noDateSuccess();
        } else {
            return Response.error("500","登出失败");
        }
    }

    @Override
    public Response loginByPhone(User user) {
        if (null!=user){
            // 根据电话号码，查询是否存在用户，如果存在用户，就直接登入，如果没有用户，就新建用户，用户名为User+phone ，密码默认为8位随机数
            User userinfo = userMapper.getUserByPhone(user.getPhone());
            if (null != userinfo) {
                // 直接登入
                return this.login(userinfo,"phone");
            }
            else {
                // 新建用户
                String username = user.getPhone();
                String password = generateRandomString(8);
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPassword(PasswordUtils.hashPassword(password));
                newUser.setPhone(user.getPhone());
                newUser.setCreateTime(new Date(System.currentTimeMillis()));
                newUser.setStatus("NEW");
                newUser.setUserId(UUID.randomUUID().toString());
                userMapper.insertSelective(newUser);
                User newUserInfo = userMapper.selectByPrimaryKey(user.getUserId());
                if (null != newUserInfo) {
                    // 注册成功后，默认往家庭成员表中插入一条数据，表示自己是家庭的管理员
//                    FamilyMember familyMember = new FamilyMember();
//                    familyMember.setMemberId(UUID.randomUUID().toString());
//                    familyMember.setPhone(user.getPhone());
//                    familyMember.setFamilyGroupsId(user.getUserId());
//                    familyMember.setName(user.getUsername());
//                    familyMember.setRelationship("本人");
//                    familyMember.setIsSyncCreateUser("0");
//                    familyMembeMapper.insert(familyMember);

                    // 注册成功后，给用户添加默认功能权限
                    FeatureExample featureExample = new FeatureExample();
                    featureExample.createCriteria().andTypeEqualTo("01");
                    List<Feature> features = featureMapper.selectByExample(featureExample);
                    if (!CollectionUtils.isEmpty(features)) {
                        for (Feature feature : features) {
                            UserSubscription userSubscription = new UserSubscription();
                            userSubscription.setId(UUID.randomUUID().toString());
                            userSubscription.setFeatureId(feature.getFeatureId());
                            userSubscription.setUserId(user.getUserId());
                            userSubscription.setSort(feature.getSort());
                            userSubscription.setSubscriptionStart(new Date(System.currentTimeMillis()));
                            userSubscription.setSubscriptionEnd(new Date(System.currentTimeMillis() + 100L *365 * 24 * 60 * 60 * 1000));
                            userSubscription.setAutoRenew(0);
                            userSubscription.setIsTrial(0);
                            userSubscription.setStatus("1");
                            userSubscriptionMapper.insertSelective(userSubscription);
                        }
                    }

                    //修改用户状态为登录，返回token
                    newUser.setStatus("LOGIN");
                    userMapper.updateByPrimaryKeySelective(newUser);
                    String token = Jwts.builder().setSubject(newUser.getUsername())
                            .setIssuedAt(new java.util.Date())
                            .setExpiration(new java.util.Date(System.currentTimeMillis() + 60000))
                            .setId("userId")
                            //.setClaims(hashMap)
                            .signWith(SignatureAlgorithm.HS256, "FREEMAN")
                            .compact();
                    redisTemplate.opsForValue().set(newUser.getUsername(),token);
                    //设置过期时间1天过期
                    redisTemplate.expire("name",1, TimeUnit.MINUTES);
                    LogInUser loginuser = new LogInUser();
                    BeanUtils.copyProperties(newUser,loginuser);
                    return Response.success(loginuser,token);
                }
            }
        }
        return Response.error("500","登陆失败");
    }

    @Override
    public Response batchCreateUsers(List<User> users) {
        // TODO Auto-generated method stub
//        userMapper.batchInsert(users);
        return Response.noDateSuccess();
    }

    /**
     * @param resetUser
     * @return
     */
    @Override
    public Response updateFamliyMemberPassword(ResetUser resetUser) {
        if (null == resetUser) {
            return Response.error("500", "参数为空");
        }
        FamilyMember familyMemberHousetOwner = resetUser.getFamilyMemberHouseOwner();
        if (null == familyMemberHousetOwner) {
            return Response.error("500", "户主信息为空");
        }
        User userOfHouseOwer = userMapper.selectByPrimaryKey(familyMemberHousetOwner.getUserId());
        if (null == userOfHouseOwer) {
            return Response.error("500", "用户不存在");
        }
        FamilyMember familyMemberForUpdate = resetUser.getFamilyMemberForUpdate();
        if (null == familyMemberForUpdate) {
            return Response.error("500", "修改成员信息为空");
        }
        if (resetUser.getNewPassword() == null || resetUser.getNewPassword().isEmpty()) {
            return Response.error("500", "新密码不能为空");
        }
        // 如果入参的原始密码为空，则校验手机号和验证码必填
        if (StringUtils.isEmpty(resetUser.getOldPassword())) {
            if (StringUtils.isEmpty(resetUser.getPhone()) || StringUtils.isEmpty(resetUser.getCaptcha())) {
                return Response.error("500", "手机号码和验证码必填");
            }
        }

        // 判断待修改的用户是不是户主的家庭成员
        FamilyMemberExample example = new FamilyMemberExample();
        FamilyMemberExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(familyMemberHousetOwner.getFamilyGroupsId())) {
            criteria.andFamilyGroupsIdEqualTo(familyMemberHousetOwner.getFamilyGroupsId());
        }
        List<FamilyMember> familyMembers = familyMemberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(familyMembers)) {
            return Response.error("500", "查询家庭成员失败");
        } else {
            boolean isFamilyMember = false;
            for (FamilyMember familyMember : familyMembers) {
                if (familyMember.getMemberId().equals(familyMemberForUpdate.getMemberId())) {
                    isFamilyMember = true;
                    break;
                }
            }
            if (!isFamilyMember) {
                return Response.error("500", "待修改的成员不在家庭成员列表中");
            }

        }
        // 根据户主的信息里面的userId,查询户主的用户信息
        User userHousetOwner = userMapper.selectByPrimaryKey(familyMemberHousetOwner.getUserId());
        if (null == userHousetOwner) {
            return Response.error("500", "户主用户不存在");
        }
        // 如果入参的老密码为空
        if (StringUtils.isEmpty(resetUser.getOldPassword())) {
            // 判断户主的手机号码是否和入参里面的手机号一致
            if (!userHousetOwner.getPhone().equals(resetUser.getPhone())) {
                return Response.error("500", "手机号码不一致");
            }
            // 判断验证码是否过期
            String captcha = resetUser.getCaptcha();
            String captchaKey = resetUser.getPhone().replace("\"", "") + "_ResetPasswordCaptcha";
            String captchaInRedis = (String) redisTemplate.opsForValue().get(captchaKey);
            if (!captcha.equals(captchaInRedis)) {
                return Response.error("500", "验证码错误或已过期");
            }
        } else {
            if (!userHousetOwner.getPassword().equals(PasswordUtils.hashPassword(resetUser.getOldPassword()))) {
                return Response.error("500", "原密码错误");
            }
        }
        // 修改用户密码
        User userForUpdate = new User();
        userForUpdate.setUserId(resetUser.getFamilyMemberForUpdate().getUserId());
        userForUpdate.setPassword(PasswordUtils.hashPassword(resetUser.getNewPassword()));
        int count = userMapper.updateByPrimaryKeySelective(userForUpdate);
        if (count > 0) {
            return Response.noDateSuccess();
        } else {
            return Response.error("500", "修改密码失败");
        }
    }



    @Override
    public Response login(User user , String type) {
        User userinfo = userMapper.getUserDetailsByUsername(user.getUsername());
        if (null == userinfo) {
            return Response.error("500","用户不存在");
        }
        if ("userName".equals(type) &&!userinfo.getPassword().equals(PasswordUtils.hashPassword(user.getPassword()))) {
            return Response.error("500","密码错误");
        }
        if ("LOCK".equals(userinfo.getStatus())) {
            return Response.error("500","您的账号已被锁定，请联系管理员");
        }
        userinfo.setStatus("LOGIN");
        userMapper.updateByPrimaryKeySelective(userinfo);
        StpUtil.login(userinfo.getUserId());
        return Response.success(userinfo);
    }
}
