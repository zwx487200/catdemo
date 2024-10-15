package com.example.catdemo.controller;

import com.example.catdemo.entity.UserBill;
import com.example.catdemo.service.BillinfoService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jennyzhuzhu
 * @date: 2024-11-18 下午7:25
 */
@RestController
@RequestMapping("/userbill")
public class UserBillController {

    @Autowired
    @Qualifier("billinfoServiceImpl")
    private BillinfoService billService;


    @PostMapping("/queryUserBill")
    public Response queryUserBills(@RequestBody RequestInfo requestInfo) {
        return billService.getBillinfosByUserId(requestInfo);
    }

    @PostMapping("/queryUserBillGroup")
    public Response queryUserBillGroupBy(@RequestBody UserBill userBill) {
        return billService.getBillinfosByUserIdGroup(userBill);
    }
}
