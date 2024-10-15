package com.example.catdemo.controller;


import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jennyzhuzhu
 * @since 2024-09-03
 */
@RestController
@RequestMapping("/captcha")
@Repository
@CrossOrigin
public class CaptchaController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/generate")
    public Response generateCaptcha(@RequestBody String string) {
        Random rand = new Random();
        String captcha = 100000 + rand.nextInt(900000) + "";
        String key = string.replace("\"","") + "_captcha";
        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, captcha, 1, TimeUnit.MINUTES);
        return Response.success(captcha);
    }

    @PostMapping("/getResetPasswordCaptcha")
    public Response getResetPasswordCaptcha(@RequestBody String phone) {
        Random rand = new Random();
        String captcha = 100000 + rand.nextInt(900000) + "";
        String key = phone.replace("\"","") + "_ResetPasswordCaptcha";
        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, captcha, 1, TimeUnit.MINUTES);
        return Response.success(captcha);
    }
}
