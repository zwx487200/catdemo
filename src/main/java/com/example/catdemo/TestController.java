package com.example.catdemo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

//    @RequestMapping("register")
//    public Map<String,String> register(@RequestParam String username, @RequestParam String password) {
//        //判断用户是否已有账号 如果有返回用户已经注册，如果没有注册
//
//    }



    @RequestMapping("/login")
    public Map<String,String> login(String userName, String password){
        Map<String,String> map=new HashMap<>();
        try{
            String token = Jwts.builder().setSubject(userName) //主题，可以放用户的详细信息
                    .setIssuedAt(new Date()) //token创建时间
                    .setExpiration(new Date(System.currentTimeMillis() + 60000)) //token过期时间
                    .setId("userId") //用户ID
                    //.setClaims(hashMap) //配置角色信息
                    .signWith(SignatureAlgorithm.HS256, "WuHan") //加密方式和加密密码
                    .compact();
            redisTemplate.opsForValue().set(userName,token);
            //设置过期时间1天过期
            redisTemplate.expire("name",1, TimeUnit.MINUTES);
            //  System.out.println("token:"+token);
            map.put("code","1");
            map.put("msg","success");
            map.put("token",token);
            map.put("user",userName);
        }catch (Exception e){
            map.put("code","0");
            map.put("msg","fail");
            e.printStackTrace();
        }
        return map;
    }
}
