package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Countdown;
import com.example.catdemo.entity.CountdownExample;
import com.example.catdemo.service.CountdownService;
import com.example.catdemo.entity.Countdown;
import com.example.catdemo.mapper.CountdownMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.DateUtils;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * 倒数日 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class CountdownServiceImpl extends ServiceImpl<CountdownMapper, Countdown> implements CountdownService {

    @Autowired CountdownMapper countdownMapper;

    @Override
    public Countdown getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public Response addCountdown(Countdown countdown) {
        if (StringUtils.isNotBlank(countdown.getId())){
            return updateCountdown(countdown);
        }
        countdown.setId(UUID.randomUUID().toString());
        int result = countdownMapper.insertSelective(countdown);
        if (result == 1) {
            return Response.success(countdown);
        } else {
            return Response.error("1006", "添加倒数日失败");
        }
    }

    @Override
    public Response updateCountdown(Countdown countdown) {
        int result = countdownMapper.updateByPrimaryKeySelective(countdown);
        if (result > 0) {
            return Response.success(countdown);
        } else {
            return Response.error("1011", "更新倒数日失败");
        }
    }

    @Override
    public Response deleteCountdown(String countdownId) {
        int result = countdownMapper.deleteByPrimaryKey(countdownId);
        if (result > 0) {
            return Response.success("删除倒数日成功");
        } else {
            return Response.error("1012", "删除倒数日失败");
        }
    }

    @Override
    public Response getCountdowns(RequestInfo requestInfo) {
        CountdownExample example = new CountdownExample();
        example.createCriteria().andFamilyIdEqualTo(requestInfo.getFamilyId())
                .andFamilyMemberIdIn(requestInfo.getFamilyMemberIds());
        List<Countdown> list =  countdownMapper.selectByExample(example);
        Date startDate = requestInfo.getStartDate();
        Date endDate = requestInfo.getEndDate();
        List<Countdown> result = new ArrayList<>();
        for (Countdown countdown : list) {
            Date targetDate = countdown.getTargetDate();
            int remindDays = countdown.getRemindDays() != null ? countdown.getRemindDays() : 0;
            Calendar remindCal = Calendar.getInstance();
            remindCal.setTime(targetDate);
            remindCal.add(Calendar.DAY_OF_MONTH, -remindDays);
            Date remindDate = remindCal.getTime();
            
            // 只要提醒日到目标日的区间与查询范围有交集就生成提醒
            if (!isDateAfter(remindDate, endDate) && !isDateBefore(targetDate, startDate)) {
                Calendar loopCal = (Calendar) remindCal.clone();
                // 遍历从提醒日到目标日的每一天
                while (!isDateAfter(loopCal.getTime(), targetDate)) {
                    Date current = loopCal.getTime();
                    if (isDateInRange(current, startDate, endDate)) {
                        Countdown dayCountdown = copyBirthdayWithDate(countdown, current);
                        result.add(dayCountdown);
                    }
                    loopCal.add(Calendar.DAY_OF_MONTH, 1);
                }
            }
        }
        return Response.success(result,result.size());
    }

    @Override
    public Response batchAddCountdowns(List<Countdown> countdowns) {
        for (Countdown countdown : countdowns) {
            Response response = addCountdown(countdown);
            if (!Response.isSuccess(response))
            {
                return Response.error("1013", "批量添加倒数日失败");
            }
        }
        return Response.success(countdowns);
    }

    @Override
    public Response getCountdownById(String id) {
        Countdown countdown = baseMapper.selectByPrimaryKey( id);
        if (countdown != null){
            return Response.success(countdown);
        } else  {
            return Response.error("1014", "倒数日不存在");
        }
    }

    // 判断日期是否在指定范围内（只比较日期部分，忽略时间部分）
    private boolean isDateInRange(Date date, Date startDate, Date endDate) {
        if (date == null || startDate == null || endDate == null) {
            return false;
        }
        
        // 将日期转换为Calendar，然后清除时间部分，只保留日期
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        dateCal.set(Calendar.HOUR_OF_DAY, 0);
        dateCal.set(Calendar.MINUTE, 0);
        dateCal.set(Calendar.SECOND, 0);
        dateCal.set(Calendar.MILLISECOND, 0);
        
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        startCal.set(Calendar.HOUR_OF_DAY, 0);
        startCal.set(Calendar.MINUTE, 0);
        startCal.set(Calendar.SECOND, 0);
        startCal.set(Calendar.MILLISECOND, 0);
        
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        endCal.set(Calendar.HOUR_OF_DAY, 0);
        endCal.set(Calendar.MINUTE, 0);
        endCal.set(Calendar.SECOND, 0);
        endCal.set(Calendar.MILLISECOND, 0);
        
        // 比较日期
        return !dateCal.getTime().before(startCal.getTime()) && !dateCal.getTime().after(endCal.getTime());
    }

    // 判断日期1是否在日期2之后（只比较日期部分）
    private boolean isDateAfter(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        
        return cal1.getTime().after(cal2.getTime());
    }

    // 判断日期1是否在日期2之前（只比较日期部分）
    private boolean isDateBefore(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        
        return cal1.getTime().before(cal2.getTime());
    }

    // 复制Birthday对象并设置提醒日期
    private Countdown copyBirthdayWithDate(Countdown source, Date remindDate) {
        Countdown copy = new Countdown();
        BeanUtils.copyProperties(source, copy);
        if (remindDate != null && source.getTargetDate() != null) {
            Calendar remindCal = Calendar.getInstance();
            remindCal.setTime(remindDate);
            Calendar sourceCal = Calendar.getInstance();
            sourceCal.setTime(source.getTargetDate());
            // 判断是否是当天
            if (remindCal.get(Calendar.YEAR) == sourceCal.get(Calendar.YEAR)
                    && remindCal.get(Calendar.MONTH) == sourceCal.get(Calendar.MONTH)
                    && remindCal.get(Calendar.DAY_OF_MONTH) == sourceCal.get(Calendar.DAY_OF_MONTH)) {
                copy.setDescription(source.getTitle() + "到了");
            } else {
                // 计算剩余天数
                long diff = sourceCal.getTimeInMillis() - remindCal.getTimeInMillis();
                long days = diff / (1000 * 60 * 60 * 24);
                copy.setDescription("离" + source.getTitle() + "还有" + days + "天");
            }
        }
        copy.setTargetDate(remindDate);
        return copy;
    }
}
