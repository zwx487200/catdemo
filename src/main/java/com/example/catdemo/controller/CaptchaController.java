package com.example.catdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author jennyzhuzhu
 * @since 2024-09-03
 */
@RestController
@RequestMapping("/captcha")
@Repository
public class CaptchaController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/generate")
    public String generateCaptcha(@RequestBody String username) {
        Random rand = new Random();
        String captcha = 100000 + rand.nextInt(900000) + "";
        String key = username + "_captcha";
        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, captcha, 1, TimeUnit.MINUTES);
        return captcha;
    }
}
