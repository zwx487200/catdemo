package com.example.catdemo.service;

import com.example.catdemo.entity.Birthday;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 生日表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface BirthdayService extends IService<Birthday> {

    Response addBirthday(Birthday birthday);

    Response updateBirthday(Birthday birthday);

    Response deleteBirthday(String birthdayId);

    Response getBirthdays(RequestInfo requestInfo);

    Response batchAddBirthdays(List<Birthday> birthdays);

    Response getBirthdayById(String id);

}
