package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.Billinfo;
import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.entity.UserBill;
import com.example.catdemo.mapper.BillinfoMapper;
import com.example.catdemo.service.BillinfoService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 账单表 服务实现类
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-11-17
 */
@Service
public class BillinfoServiceImpl implements BillinfoService {


    @Autowired
    private BillinfoMapper billinfoMapper;

    @Autowired
    private PocketbankServiceImpl pocketbankService;


    @Override
    public Response getBillinfoById(String id) {
        return null;
    }


    @Override
    public Response getAllBillinfo(Billinfo billinfo) {
        return null;
    }


    @Override
    public Response addBillinfo(Billinfo billinfo) {
        billinfo.setBillId(UUID.randomUUID().toString());
        int result = billinfoMapper.insertBillinfo(billinfo);
        if (result == 1){
            // 判断是否要同步到零用钱
            if( "1".equals(billinfo.getIsSyncWithPocketMoney())  ){
                // 判断用户是否有对应的零用钱账户
                Response response = pocketbankService.getPocketbankByUserId(billinfo.getUserId());
                if (Response.isSuccess(response) && response.getData()!= null){
                    // 添加到零用钱账户
                    Pocketbank pocketbank = (Pocketbank) response.getData();
                    if ("99".equals(billinfo.getBillType())){
                        pocketbank.setBalance(pocketbank.getBalance().add(billinfo.getAmount()));
                        pocketbank.setCurrentBalance(pocketbank.getCurrentBalance().add(billinfo.getAmount()));
                    } else {
                        pocketbank.setBalance(pocketbank.getBalance().subtract(billinfo.getAmount()));
                        pocketbank.setCurrentBalance(pocketbank.getCurrentBalance().subtract(billinfo.getAmount()));
                    }
                    pocketbankService.updatePocketbank(pocketbank);
                } else {
                    if ("99".equals(billinfo.getBillType())){
                        // 创建零用钱账户
                        Pocketbank pocketbank = new Pocketbank();
                        pocketbank.setUserId(billinfo.getUserId());
                        pocketbank.setBalance(billinfo.getAmount());
                        pocketbank.setCurrentBalance(billinfo.getAmount());
                        pocketbank.setStatus("01");
                        pocketbank.setInterestRate(new BigDecimal("0.00"));
                        pocketbankService.addPocketbank(pocketbank);
                    }
                }
            }
            return Response.success(billinfo);
        } else {
            return Response.error("添加账单失败");
        }
    }


    @Override
    public Response updateBillinfo(Billinfo billinfo) {
        if ( billinfoMapper.updateBillinfoById(billinfo)>0){
            return Response.noDateSuccess();
        } else {
            return Response.error("更新账单失败");
        }

    }


    @Override
    public Response deleteBillinfo(String billId) {
        int result = billinfoMapper.deleteBillinfoById(billId);
        if (result == 1){
            return Response.noDateSuccess();
        } else {
            return Response.error("删除账单失败");
        }
    }


    @Override
    public Response deleteBillinfoByDate(String date) {
        return null;
    }

    @Override
    public Response getBillinfoByDate(String date) {
        return null;
    }


    @Override
    public Response getBillinfosByUserId(RequestInfo requestInfo) {
        UserBill userBill = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<UserBill>() { });
        if (userBill.getUserId() != null || !CollectionUtils.isEmpty(userBill.getUserList())){
            userBill.setStartDate(requestInfo.getStartDate());
            userBill.setEndDate(requestInfo.getEndDate());
            PageHelper.startPage(requestInfo.getPageNum(), requestInfo.getPageSize());
            List<UserBill> userbills = billinfoMapper.selectBillinfosByUserId(userBill);
            PageInfo<UserBill> pageInfo = new PageInfo<>(userbills);
            return Response.success(userbills,pageInfo.getTotal());
        } else {
            return Response.error("用户id不能为空或用户列表不能为空");
        }
    }


    @Override
    public Response getBillinfoByType(String billType) {
        return null;
    }


    @Override
    public Response getBillinfosByUserIdGroup(UserBill userBill) {


        return Response.noDateSuccess();

//        List<UserBill> userbills = billinfoMapper.selectBillinfosByUserId(userBill);
//        if (!userbills.isEmpty()){
//            // 将userbills根据billType分组求和amount
//            Map<String, Double> billTyperesult = userbills.stream()
//                    .collect(Collectors.groupingBy(
//                            UserBill::getBillType,
//                            Collectors.summingDouble(bill -> bill.getAmount().doubleValue())
//                    ));
//            Map<String, Double> billSourceresult = userbills.stream()
//                    .collect(Collectors.groupingBy(
//                            UserBill::getBillSource,
//                            Collectors.summingDouble(bill -> bill.getAmount().doubleValue())
//                    ));
//            Map<String, Map<String, Double>> result = new HashMap<>();
//            result.put("billType", billTyperesult);
//            result.put("billSource", billSourceresult);
//            return Response.success(result);
//        } else {
//            return Response.noDateSuccess();
//        }
    }
}
