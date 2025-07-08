package com.example.catdemo.controller;

import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 验证码控制器
 * 提供验证码生成和验证相关功能
 *
 * @author jennyzhuzhu
 * @since 2024-09-03
 */
@RestController
@RequestMapping("/captcha")
@CrossOrigin
public class CaptchaController {

    private static final String CAPTCHA_SUFFIX = "_captcha";
    private static final String RESET_PASSWORD_CAPTCHA_SUFFIX = "_ResetPasswordCaptcha";
    private static final int CAPTCHA_LENGTH = 6;
    private static final int CAPTCHA_MIN = 100000;
    private static final int CAPTCHA_MAX = 999999;
    private static final long CAPTCHA_EXPIRE_MINUTES = 1;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 生成普通验证码
     *
     * @param identifier 用户标识（如手机号、邮箱等）
     * @return 验证码
     */
    @GetMapping("/generate")
    public Response generateCaptcha(@RequestParam String identifier) {
        try {
            String captcha = generateRandomCaptcha();
            String key = formatKey(identifier, CAPTCHA_SUFFIX);
            saveCaptchaToRedis(key, captcha);
            return Response.success(captcha);
        } catch (Exception e) {
            return Response.error("验证码生成失败：" + e.getMessage());
        }
    }

    /**
     * 生成重置密码验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    @GetMapping("/getResetPasswordCaptcha")
    public Response getResetPasswordCaptcha(@RequestParam String phone) {
        try {
            String captcha = generateRandomCaptcha();
            String key = formatKey(phone, RESET_PASSWORD_CAPTCHA_SUFFIX);
            saveCaptchaToRedis(key, captcha);
            return Response.success(captcha);
        } catch (Exception e) {
            return Response.error("重置密码验证码生成失败：" + e.getMessage());
        }
    }

    /**
     * 生成随机验证码
     *
     * @return 6位数字验证码
     */
    private String generateRandomCaptcha() {
        Random random = new Random();
        return String.format("%06d", CAPTCHA_MIN + random.nextInt(CAPTCHA_MAX - CAPTCHA_MIN + 1));
    }

    /**
     * 格式化Redis键
     *
     * @param identifier 标识符
     * @param suffix 后缀
     * @return 格式化后的键
     */
    private String formatKey(String identifier, String suffix) {
        return identifier.replace("\"", "").trim() + suffix;
    }

    /**
     * 保存验证码到Redis
     *
     * @param key Redis键
     * @param captcha 验证码
     */
    private void saveCaptchaToRedis(String key, String captcha) {
        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, captcha, CAPTCHA_EXPIRE_MINUTES, TimeUnit.MINUTES);
    }
}
