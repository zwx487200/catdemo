package com.example.catdemo.check;

import com.example.catdemo.entity.ResetUser;
import com.example.catdemo.entity.User;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@Service
public class UserCheck {
    @Autowired
    RedisTemplate redisTemplate;

    public static boolean checkName(String name) {
        return name.matches("[A-Za-z]{2,15}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public Response checkUssr(User user) {
        if (null == user){
            return Response.error("300", "用户信息为空");
        } else {
            String  captcha = user.getCaptcha();
            if (StringUtils.isEmpty(user.getUsername())) {
                return Response.error("300", "用户名不能为空");
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return Response.error("300", "密码不能为空");
            }
            String regex = "^[^；:<>]{1,19}$";
            if (!user.getUsername().matches(regex)) {
                return Response.error("300", "用户名不合法");
            }
            if (!user.getPassword().matches(regex)) {
                return Response.error("300", "密码不合法");
            }
            if (captcha.isEmpty()) {
                return Response.error("300", "验证码不能为空");
            }
            String key = user.getPhone() + "_captcha";
            String value = Objects.requireNonNull(redisTemplate.opsForValue().get(key)).toString();
            if (value == null) {
                return Response.error("300", "验证码已失效");
            }
            if (!value.equals(captcha)) {
                return Response.error("300", "验证码不正确");
            }
        }
        return null;
    }

    public Response checkRegisterUssr(User user) {
        if (null == user){
            return Response.error("300", "用户信息为空");
        } else {
            if (StringUtils.isEmpty(user.getUsername())) {
                return Response.error("300", "用户名不能为空");
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return Response.error("300", "密码不能为空");
            }
            String regex = "^[^；:<>]{1,19}$";
            if (!user.getUsername().matches(regex)) {
                return Response.error("300", "用户名不合法");
            }
            if (!user.getPassword().matches(regex)) {
                return Response.error("300", "密码不合法");
            }
        }
        return null;
    }


    public Response checkResetUser(ResetUser user) {
        Response response = null;
        if (null == user){
            return Response.error("300","入参为空");
        } {
            if (StringUtils.isEmpty(user.getUsername())) {
                return Response.error("300","用户名不能为空");
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return Response.error("300","原始密码不能为空");
            }
            if (StringUtils.isEmpty(user.getNewPassword())) {
                return Response.error("300","新密码不能为空");
            }
            if (StringUtils.isEmpty(user.getConfirmPassword())){
                return Response.error("300","确认密码不能为空");
            }
            if (!user.getNewPassword().equals(user.getConfirmPassword())) {
                return Response.error("300","两次输入的新密码不一致");
            }
        }
        return response;
    }

}
