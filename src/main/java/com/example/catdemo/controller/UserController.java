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


    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询 Token 信息  ---- http://localhost:8080/acc/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8080/acc/logout
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }




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

//    @PostMapping("/wxLogin")
//    public Response wxLogin(@RequestParam String code) {
//        return wxLoginService.wxLogin(code);
//    }
//
//    @PostMapping("/updateWxUserInfo")
//    public Response updateWxUserInfo(@RequestBody WxUserInfo wxUserInfo) {
//        return wxLoginService.updateWxUserInfo(wxUserInfo);
//    }

}
