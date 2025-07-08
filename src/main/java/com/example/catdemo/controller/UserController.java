package com.example.catdemo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.example.catdemo.check.UserCheck;
import com.example.catdemo.entity.ResetUser;
import com.example.catdemo.entity.User;
import com.example.catdemo.service.UserService;
import com.example.catdemo.utils.PasswordUtils;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author jennyzhuzhu
 * @since 2024-09-03
 */
@RestController
@RequestMapping("/user")
@Repository
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserCheck userCheck;

    @PostMapping("/register")
    public Response register(@RequestBody  User user) {
        Response response = userCheck.checkUssr(user);
        if (null != response){
            return response;
        }

        return userService.createUser(user);
    }

    // 新增批量添加用户的方法
    @PostMapping("/batchAddUser")
    public Response batchAddUser(@RequestBody List<User> users) {
        for (User user : users) {
            if (user.getPassword() != null){
                user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
            }
            user.setUserId(UUID.randomUUID().toString());
        }
        return userService.batchCreateUsers(users);
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
        Response oldUserResponse = userService.getUserDetails(user);
        if (null == oldUserResponse || !password.equals(((User)oldUserResponse.getData()).getPassword())){
            return Response.error("300","原始密码不正确");
        }
        // 新密码加密
        user.setPassword(PasswordUtils.hashPassword(user.getNewPassword()));
        return userService.updateUserPassword(user);
    }

    @PostMapping("/resetFamilyMemberPassword")
    public Response resetFamilyMemberPassword(@RequestBody ResetUser resetUser) {
        return userService.updateFamliyMemberPassword(resetUser);
    }

    @PostMapping("/queryUserInfo")
    public Response queryUserInfo(@RequestBody User user) {
            return userService.getUserDetails(user);
    }

    @PostMapping("/logIn")
    public Response logIn(@RequestBody User user) {
       // TODO 电话号码一键登入
       if (StringUtils.isNotBlank(user.getPhone())){
           return userService.loginByPhone(user);
       }
       return userService.login(user ,"userName");
    }

    @PostMapping("/logOut")
    public Response logOut(@RequestBody User user) {
        return userService.logOut(user);
    }

    //updateUserInfo
    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(@RequestBody User user) {
        return userService.updateUserDetails(user);
    }

    // 创建虚拟账户
    @PostMapping("/createVirtualAccount")
    public Response createVirtualAccount(@RequestBody User user) {
        return userService.createVirtualAccount(user);
    }

}
