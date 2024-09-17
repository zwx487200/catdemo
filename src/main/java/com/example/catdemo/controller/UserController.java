package com.example.catdemo.controller;

import com.example.catdemo.check.UserCheck;
import com.example.catdemo.entity.ResetUser;
import com.example.catdemo.entity.User;
import com.example.catdemo.service.IUserService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.RedisUtils;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Repository
@CrossOrigin
public class UserController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    IUserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserCheck userCheck;

    @PostMapping("/register")
    public Response register(@RequestBody  User user) {
        Response response = userCheck.checkUssr(user);
        if (null != response){
            return response;
        }
        //password加密
        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
        //redis 存储
        return userService.createUser(user);
    }

    @PostMapping("/resetPassword")
    public Response resetPassword(@RequestBody ResetUser user) {
        Response response = userCheck.checkResetUser(user);
        if (null!= response){
            return response;
        }
        // 判断原始密码是否正确
        String password = PasswordUtils.hashPassword(user.getPassword());
        User oldUser = new User();
        oldUser.setUserId(user.getUserId());
        oldUser.setPassword(password);
        Response oldUserResponse = userService.getUserDetails(user.getUserId());
        if (null == oldUserResponse || !password.equals(((User)oldUserResponse.getData()).getPassword())){
            return Response.error("300","原始密码不正确");
        }
        // 新密码加密
        user.setPassword(PasswordUtils.hashPassword(user.getNewPassword()));
        return userService.updateUserPassword(user);
    }

    @PostMapping("/queryUserInfo")
    public Response queryUserInfo(@RequestBody User user) {
            return userService.getUserDetails(user.getUserId());
    }

    @PostMapping("/logIn")
    public Response logIn(@RequestBody User user) {
       // TODO 电话号码一键登入
       return userService.login(user);
    }

    

    @PostMapping("/logOut")
    public Response logOut(@RequestBody User user) {
        return userService.logOut(user);
    }
}
