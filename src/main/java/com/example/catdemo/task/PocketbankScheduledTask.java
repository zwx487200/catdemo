package com.example.catdemo.task;

import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.entity.Transfers;
import com.example.catdemo.entity.TransfersExample;
import com.example.catdemo.mapper.TransfersMapper;
import com.example.catdemo.service.PocketbankService;
import com.example.catdemo.service.impl.PocketbankServiceImpl;
import com.example.catdemo.service.impl.TransfersServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jennyzhuzhu
 */
@Component
public class PocketbankScheduledTask {

    @Autowired
    private PocketbankServiceImpl pocketbankServiceImpl;

    @Autowired
    private TransfersServiceImpl transfersServiceImpl;

    @Autowired
    private TransfersMapper transfersMapper;

    // 每天0点执行
    @Scheduled(cron = "0 0 0 * * ?")
    public void updatePocketbankBalances() {
        // 查询所有状态为 "01" 且 fixedBalance > 0 的 Pocketbank 记录
        List<Pocketbank> pocketbanks = pocketbankServiceImpl.getPocketbanksWithFixedBalance();

        for (Pocketbank pocketbank : pocketbanks) {
            if ("01".equals(pocketbank.getStatus()) && pocketbank.getFixedBalance().compareTo(BigDecimal.valueOf(0)) > 0) {
                BigDecimal interestRate = pocketbank.getInterestRate();
                pocketbank.setFixedBalance(pocketbank.getFixedBalance().multiply((interestRate.add(BigDecimal.valueOf(1)))));
                pocketbank.setBalance(pocketbank.getCurrentBalance().add(pocketbank.getFixedBalance()));
                pocketbankServiceImpl.updatePocketbank(pocketbank);
            }
        }
    }

    // 每天1点执行
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledTransfer() {
        TransfersExample example = new TransfersExample();
        TransfersExample.Criteria criteria = example.createCriteria();
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        criteria.andTransferTypeIn(list);
        List<Transfers> transfers = transfersMapper.selectByExample(example);
        for (Transfers transfer : transfers) {


        }
    }

}

