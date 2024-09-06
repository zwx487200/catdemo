package com.example.catdemo.service;

import com.example.catdemo.entity.User;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;


@Service
public interface IUserService {

    Response getUserDetails(String userId);

    Response updateUserDetails(User user);

    Response updateUserPassword(User user);

    String deleteUser(User user);

    Response createUser(User user);

    String validateCaptcha(String captcha);

    Response login(User user);

    Response logOut(User user);

}
