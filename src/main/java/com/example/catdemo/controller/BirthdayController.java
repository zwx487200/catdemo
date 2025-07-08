package com.example.catdemo.controller;

import com.example.catdemo.entity.Birthday;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import com.example.catdemo.service.BirthdayService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生日表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@RestController
@RequestMapping("/birthday")
public class BirthdayController {

    @Autowired
    BirthdayService birthdayService;

    @RequestMapping("/addBirthday")
    public Response addBirthday(@Validated(addGroup.class) @RequestBody Birthday birthday){
        return birthdayService.addBirthday(birthday);
    }

    @RequestMapping("/updateBirthday")
    public Response updateBirthday(@Validated(updateGroup.class) @RequestBody Birthday birthday) {
      return birthdayService.updateBirthday(birthday);
    }

    @RequestMapping("/deleteBirthday")
    public Response deleteBirthday(@Validated(deleteGroup.class) @RequestBody Birthday birthday) {
        return birthdayService.deleteBirthday(birthday.getId());
    }

    @RequestMapping("/getBirthdays")
    public Response getBirthdays(@RequestBody RequestInfo requestInfo) {
        return birthdayService.getBirthdays(requestInfo);
    }

    @RequestMapping("/getBirthdayById")
    public Response getBirthdayByUserId(@Validated(queryGroup.class) @RequestBody Birthday birthday) {
        return birthdayService.getBirthdayById(birthday.getId());
    }



    




}
