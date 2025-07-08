package com.example.catdemo.service;

import com.example.catdemo.entity.Billinfo;
import com.example.catdemo.entity.UserBill;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账单表 服务类
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-11-17
 */
@Service
public interface BillinfoService {

    // 根据 ID 查询账单信息
    Response getBillinfoById(String id);

    // 查询所有账单信息
    Response getAllBillinfo(Billinfo billinfo);

    // 添加账单信息
    Response addBillinfo(Billinfo billinfo);

    // 更新账单信息
    Response updateBillinfo(Billinfo billinfo);

    // 删除账单信息
    Response deleteBillinfo(String billId);

    // 根据日期删除账单信息
    Response deleteBillinfoByDate(String date);

    // 根据日期查询账单信息
    Response getBillinfoByDate(String date);

    // 额外的方法：根据用户 ID 查询账单信息
    Response getBillinfosByUserId(RequestInfo billinfo);

    // 额外的方法：根据账单类型查询账单信息
    Response getBillinfoByType(String billType);

    Response getBillinfosByUserIdGroup(UserBill userBill);
}
