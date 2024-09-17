package com.example.catdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhanhuibin
 * @since 2024-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Repository
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String userId;
    String username;
    String password;
    String email;
    String phone;
    String role;
    String lastLoginTime;
    String lastLoginIp;
    String status;
    Date createTime;
    String updateTime;
    String captcha;

}
