package com.example.catdemo.controller;


import com.example.catdemo.entity.Billinfo;
import com.example.catdemo.service.BillinfoService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 账单表 前端控制器
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-11-17
 */
@RestController
@RequestMapping("/billinfo")
public class BillinfoController {

    @Autowired
    private BillinfoService billinfoService;

    // 新增账单
    @RequestMapping("/addBillinfo")
    public Response addBillinfo(@RequestBody Billinfo billinfo) {
        return billinfoService.addBillinfo(billinfo);
    }
    // 删除账单
    @RequestMapping("/deleteBillinfo")
    public Response deleteBillinfo(@RequestBody Billinfo billinfo) {
        return billinfoService.deleteBillinfo(billinfo.getBillId());
    }
    // 查询账单
    @RequestMapping("/queryBillinfo")
    public Response queryBillinfo(String billinfoId) {
        return billinfoService.getBillinfoById(billinfoId);
    }
    // 根据条件查询账单
    @RequestMapping("/queryBillinfoByCondition")
    public Response getAllBillinfo(@RequestBody Billinfo billinfo) {
        return billinfoService.getAllBillinfo(billinfo);
    }

    // 修改账单
    @RequestMapping("/updateBillinfo")
    public Response updateBillinfo(@RequestBody Billinfo billinfo) {
        return billinfoService.updateBillinfo(billinfo);
    }


}
