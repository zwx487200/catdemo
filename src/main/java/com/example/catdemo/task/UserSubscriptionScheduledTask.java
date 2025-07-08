package com.example.catdemo.task;

import com.example.catdemo.entity.UserSubscription;
import com.example.catdemo.entity.UserSubscriptionExample;
import com.example.catdemo.mapper.UserSubscriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author jennyzhuzhu
 */
@Component
public class UserSubscriptionScheduledTask {

    @Autowired
    private UserSubscriptionMapper userSubscriptionMapper;
    @Scheduled(cron = "0 0 0 * * ?") // 每天0点执行
    public void checkAndExpireSubscriptions() {
        UserSubscriptionExample example = new UserSubscriptionExample();
        UserSubscriptionExample.Criteria criteria = example.createCriteria();
        criteria.andIsTrialEqualTo(1);
        userSubscriptionMapper.selectByExample(example);

        for (UserSubscription subscription : userSubscriptionMapper.selectByExample(example)) {
            LocalDate end = subscription.getSubscriptionEnd().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            if (end.isBefore(LocalDate.now())) {
                subscription.setStatus("0");
                userSubscriptionMapper.updateByPrimaryKey(subscription);
            }
        }
    }
}
