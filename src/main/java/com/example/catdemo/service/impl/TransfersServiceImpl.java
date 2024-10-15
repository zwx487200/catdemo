package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.TransfersMapper;
import com.example.catdemo.service.BillinfoService;
import com.example.catdemo.service.PocketbankService;
import com.example.catdemo.service.TransfersService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-10 10:44
 */
@Service
public class TransfersServiceImpl implements TransfersService {

    @Autowired
    private TransfersMapper transfersMapper;

    @Autowired
    private PocketbankService pocketbankService;

    @Autowired
    private BillinfoService billinfoService;


    /**
     * @param transfer 转账信息
     * @return Response
     */
    @Override
    public Response createTransfer(Transfers transfer) {

        // 查询转出账户余额
        Response outAccountIdPocketBankResponse = pocketbankService.getPocketbankByUserId(transfer.getOutAccountId());
        Pocketbank outAccountIdPocketBank = (Pocketbank) outAccountIdPocketBankResponse.getData();
        // 如果用户不存在零用钱银行 ，则返回用户不存在
        if (outAccountIdPocketBank == null) {
            return Response.error("转账户不存在零用钱银行账户，请先注册零用钱银行，再进行转账，您可以到账单页面添加收入，并选择同步到零用钱银行。");
        }

        /**
         * TODO转账要做同步操作，即转出户和转入户的余额要同时减少，同时增加，并且记录账单
         * 1. 转出户扣除转账金额
         * 2. 转入户增加转账金额
         * 3. 记录账单
         */

        /**
         * TODO: 校验转账信息合法性
         * 1. 转出账户余额是否足够
         * 2. 如果转账类型为定时转账，则校验转账时间是否合法
         * 3. 如果转账类型为定期转账，则校验转账周期是否合法，如果是按日，则设置转账时间为每日的 00:00:00，
         * 如果是按周，则设置转账时间为每周的星期一的 00:00:00，如果是按月，则设置转账时间为每月的 1 号的 00:00:00
         * 4. 如果转账类型为实时转账，则校验转账金额是否合法 判断转账金额是否大于余额，如果大于余额，则返回余额不足的错误信息
         * 5. 转账记录入库
         */

        switch (transfer.getTransferType())
            {
                case "01":
                    // TODO: 校验转账时间是否合法

                    break;
                case "02":
                    // TODO: 校验转账周期是否合法
                    switch (transfer.getPeriodicTransferTime()){
                        case "01":
                            LocalDateTime tomorrow = LocalDateTime.now().plusDays(1).withHour(0).withMinute(5).withSecond(0);
                            transfer.setScheduledTransferTime(Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant()));
                            break;
                        case "02":
                            LocalDateTime nextMonday = LocalDateTime.now().with(DayOfWeek.MONDAY).plusWeeks(1).withHour(0).withMinute(5).withSecond(0).withNano(0);
                            transfer.setScheduledTransferTime(Date.from(nextMonday.atZone(ZoneId.systemDefault()).toInstant()));
                            break;
                        case "03":
                            LocalDateTime nextMonthFirst = LocalDateTime.now().plusMonths(1).withDayOfMonth(1).withHour(0).withMinute(5).withSecond(0).withNano(0);
                            transfer.setScheduledTransferTime(Date.from(nextMonthFirst.atZone(ZoneId.systemDefault()).toInstant()));
                            break;
                        default:
                            break;
                    }
                    break;
                case "03":
                    // 判断转账金额是否大于余额
                    Response response = transfer(transfer, outAccountIdPocketBank);
                    if (response != null){
                        return response;
                    }
                    break;
                default:
                    break;
            }
        int result = transfersMapper.insertSelective(transfer);
        if (result == 1) {
            return Response.success("转账成功");
        }
        return Response.error("转账失败");

    }

    public @Nullable @Transactional Response transfer(Transfers transfer, Pocketbank outAccountIdPocketBank) {
        if (transfer.getTransferAmount().compareTo(outAccountIdPocketBank.getCurrentBalance()) > 0) {
            return Response.error("余额不足");
        }
        // 转出户扣除转账金额
        outAccountIdPocketBank.setCurrentBalance(outAccountIdPocketBank.getCurrentBalance().subtract(transfer.getTransferAmount()));
        outAccountIdPocketBank.setBalance(outAccountIdPocketBank.getBalance().subtract(transfer.getTransferAmount()));
        pocketbankService.updatePocketbank(outAccountIdPocketBank);
        // 转入户增加转账金额
        Response inAccountIdpocketbankresponse = pocketbankService.getPocketbankByUserId(transfer.getInAccountId());
        if ("-1" .equals(inAccountIdpocketbankresponse.getCode()) ){
            //如果转账户不存在，则创建账户
            Pocketbank pocketbank = new Pocketbank();
            pocketbank.setPocketBankId(UUID.randomUUID().toString());
            pocketbank.setUserId(transfer.getInAccountId());
            pocketbank.setBalance(transfer.getTransferAmount());
            pocketbank.setCurrentBalance(transfer.getTransferAmount());
            pocketbank.setStatus("01");
            pocketbankService.addPocketbank(pocketbank);
        } else  if ("0" .equals(inAccountIdpocketbankresponse.getCode())){
            Pocketbank inAccountIdpocketbank = (Pocketbank) inAccountIdpocketbankresponse.getData();
            inAccountIdpocketbank.setCurrentBalance(inAccountIdpocketbank.getCurrentBalance().add(transfer.getTransferAmount()));
            inAccountIdpocketbank.setBalance(inAccountIdpocketbank.getBalance().add(transfer.getTransferAmount()));
            pocketbankService.updatePocketbank(inAccountIdpocketbank);
        }


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 记录账单
        Billinfo outBillinfo = new Billinfo();
        outBillinfo.setAmount(transfer.getTransferAmount());
        outBillinfo.setBillTime(simpleDateFormat.format(new Date()));
        outBillinfo.setUserId(transfer.getOutAccountId());
        outBillinfo.setRemark("零用钱下发");

        // TODO: 账单类型和账单来源需要从数据库中获取
        outBillinfo.setBillType("4f35409a-8694-4a4e-aee4-2d8a800aa5fz");
        outBillinfo.setBillSource("4f35409a-8694-4a4e-aee4-2d8a800aa0f3");
        billinfoService.addBillinfo(outBillinfo);

        Billinfo inBillinfo = new Billinfo();
        inBillinfo.setAmount(transfer.getTransferAmount());
        outBillinfo.setBillTime(simpleDateFormat.format(new Date()));
        inBillinfo.setUserId(transfer.getInAccountId());
        inBillinfo.setRemark("下发零用钱");
        inBillinfo.setBillType("99");
        inBillinfo.setBillSource("4f35409a-8694-4a4e-aee4-2d8a800aa1f9");
        billinfoService.addBillinfo(inBillinfo);


        transfersMapper.insertSelective(transfer);
        return Response.success("转账成功");
    }

    /**
     * @param transferId 转账记录 ID
     * @return Response
     */
    @Override
    public Response deleteTransfer(String transferId) {
        int result = transfersMapper.deleteByPrimaryKey(transferId);
        if (result == 1) {
            return Response.success("删除成功");
        }
        return Response.error("删除失败");
    }

    /**
     * @param transfer 转账信息
     * @return Response
     */
    @Override
    public Response updateTransfer(Transfers transfer) {
        int result = transfersMapper.updateByPrimaryKeySelective(transfer);
        if (result == 1) {
            return Response.success(transfer);
        }
        return Response.error("更新失败");
    }

    /**
     * @param transferId 转账记录 ID
     * @return Response
     */
    @Override
    public Response getTransferById(String transferId) {
        Transfers transfer = transfersMapper.selectByPrimaryKey(transferId);
        if (transfer != null) {
            return Response.success(transfer);
        }
        return Response.error("查询失败");
    }

    /**
     * @param requestInfo 转账信息
     * @return Response
     */
    @Override
    public Response getAllTransfers(RequestInfo requestInfo) {
        Transfers transfer = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<Transfers>() { });
        TransfersExample example = new TransfersExample();
        TransfersExample.Criteria criteria = example.createCriteria();
        if (transfer.getOutAccountId() != null) {
            criteria.andOutAccountIdEqualTo(transfer.getOutAccountId());
        }
        if (transfer.getInAccountId() != null) {
            criteria.andInAccountIdEqualTo(transfer.getInAccountId());
        }
        if (transfer.getTransferType() != null) {
            criteria.andTransferTypeEqualTo(transfer.getTransferType());
        }
        PageHelper.startPage(requestInfo.getPageNum(), requestInfo.getPageSize());
        List<Transfers> transfers = transfersMapper.selectByExample(example);
        PageInfo<Transfers> pageInfo = new PageInfo<>(transfers);
        return Response.success(transfers,pageInfo.getTotal());
    }

    /**
     * @param transfers 转账信息列表
     * @return Response
     */
    @Override
    public Response batchCreateTransfers(List<Transfers> transfers) {
//        int result = transfersMapper.batchInsert(transfers);
//        if (result == transfers.size()) {
//            return Response.success("批量创建成功");
//        }
        return Response.error("批量创建失败");
    }

    /**
     * @param transferIds 转账记录 ID 列表
     * @return Response
     */
    @Override
    public Response batchDeleteTransfers(List<String> transferIds) {
        return Response.error("批量创建失败");
    }
}
