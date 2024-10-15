package com.example.catdemo.service;

import com.example.catdemo.entity.ResetUser;
import com.example.catdemo.entity.User;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author jennyzhuzhu
 */
@Service
public interface UserService {

    Response getUserDetails(User user);

    Response updateUserDetails(User user);

    Response updateUserPassword(User user);

    String deleteUser(User user);

    Response createUser(User user);

    Response createVirtualAccount(User user);

    String validateCaptcha(String captcha);

    Response login(User user, String tpye);

    Response logOut(User user);

    Response loginByPhone(User user);

    Response batchCreateUsers(List<User> users);

    Response updateFamliyMemberPassword(ResetUser resetUser);
}
