package com.example.catdemo.service.impl;

import com.example.catdemo.entity.User;
import com.example.catdemo.mapper.UserMapper;
import com.example.catdemo.service.IUserService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.UUID;

/**
 * @author jennyzhuzhu
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;
    /**
     * @param userId
     * @return
     */
    @Override
    public Response getUserDetails(String userId) {
        User user = userMapper.getUserDetails(userId);
        return Response.success(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response updateUserDetails(User user) {
        return null;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response updateUserPassword(User user) {
        Response response ;
        if (null == user) {
            return Response.error("500","参数为空");
        }
        //更新密码
        userMapper.updatePassword(user.getUsername(), user.getPassword());
        //查询用户
        User userinfo = userMapper.getUserDetails(user.getUserId());
        if (null!= userinfo) {
            response = Response.success(userinfo);
        } else {
            response = Response.error("500","更新密码失败");
        }
        return response;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public String deleteUser(User user) {
        return "";
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response createUser(User user) {
       Response response ;
       if (0 < userMapper.getCountbyUser(user.getUsername())) {
           return Response.error("500","用户已存在");
       } else {
           user.setStatus("NEW");
           user.setUserId(UUID.randomUUID().toString());
           user.setCreateTime(new Date(System.currentTimeMillis()));
           userMapper.addUser(user);
           User userinfo = userMapper.getUserDetails(user.getUserId());
           if (null != user) {
               response = Response.success(userinfo);
           } else {
               response = Response.error("500","用户新增失败");
           }
       }
        return  response;
    }

    /**
     * @param captcha
     * @return
     */
    @Override
    public String validateCaptcha(String captcha) {
        return "";
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response logOut(User user) {
        user.setStatus("LOGOUT");
        userMapper.updateUser(user);
        User userInfo = userMapper.getUserDetails(user.getUserId());
        if (null!= userInfo && "LOGOUT".equals(userInfo.getStatus())) {
            return Response.noDateSuccess();
        } else {
            return Response.error("500","登出失败");
        }
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Response login(User user) {
        // TODO Auto-generated method stub
        User userinfo = userMapper.getUserDetailsByUsername(user.getUsername());
        if (null == userinfo) {
            return Response.error("500","用户不存在");
        }
        if (!userinfo.getPassword().equals(PasswordUtils.hashPassword(user.getPassword()))) {
            return Response.error("500","密码错误");
        }
        if ("LOCK".equals(userinfo.getStatus())) {
            return Response.error("500","您的账号已被锁定，请联系管理员");
        }
        if ("LOGIN".equals(userinfo.getStatus())) {
            return Response.error("500","您的账号已登入，请勿重复登入");
        }
        // TODO 登录成功后返回token
        // TODO 请自行实现token生成和返回

        userinfo.setStatus("LOGIN");
        userMapper.updateUser(userinfo);
        return Response.success(userinfo);
    }
}
