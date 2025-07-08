package com.example.catdemo.service.impl;

import com.example.catdemo.entity.BirthdayExample;
import com.example.catdemo.service.BirthdayService;
import com.example.catdemo.entity.Birthday;
import com.example.catdemo.mapper.BirthdayMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * 生日表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class BirthdayServiceImpl extends ServiceImpl<BirthdayMapper, Birthday> implements BirthdayService {

    @Override
    public Response addBirthday(Birthday birthday) {
        if(StringUtils.isNotBlank(birthday.getId())){
            return updateBirthday(birthday);
        }
        birthday.setId(UUID.randomUUID().toString());
        int result = baseMapper.insertSelective(birthday);
        if (result == 1) {
            return Response.success(birthday);
        } else {
            return Response.error("1006", "添加生日失败");
        }
    }

    @Override
    public Response updateBirthday(Birthday birthday) {
        int result = baseMapper.updateByPrimaryKeySelective(birthday);
        if (result == 1) {
            return Response.success(birthday);
        } else {
            return Response.error("1007", "更新生日失败");
        }
    }

    @Override
    public Response deleteBirthday(String birthdayId) {
        int result = baseMapper.deleteByPrimaryKey(birthdayId);
        if (result == 1) {
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除生日失败");
        }
    }

    @Override
    public Response getBirthdays(RequestInfo requestInfo) {
        BirthdayExample example = new BirthdayExample();
        example.createCriteria().andFamilyIdEqualTo(requestInfo.getFamilyId())
                .andFamilyMemberIdIn(requestInfo.getFamilyMemberIds());
        List<Birthday> list =  baseMapper.selectByExample(example);
        Date startDate = requestInfo.getStartDate();
        Date endDate = requestInfo.getEndDate();
        List<Birthday> result = new ArrayList<>();
        for (Birthday birthday : list) {
            // 只取月日
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(birthday.getDate());
            int month = birthCal.get(Calendar.MONTH) + 1;
            int day = birthCal.get(Calendar.DAY_OF_MONTH);

            // 今年的生日
            Calendar thisYearBirth = Calendar.getInstance();
            thisYearBirth.setTime(startDate);
            thisYearBirth.set(Calendar.MONTH, month - 1);
            thisYearBirth.set(Calendar.DAY_OF_MONTH, day);


            // 今年的生日提醒日
            int remindDays = birthday.getRemindDays() != null ? birthday.getRemindDays() : 0;
            Calendar remindCal = (Calendar) thisYearBirth.clone();
            remindCal.add(Calendar.DAY_OF_MONTH, -remindDays);

            // 判断提醒日是否在区间内
            if (!remindCal.getTime().before(startDate) && !remindCal.getTime().after(endDate)) {
                Birthday remindBirthday = copyBirthdayWithDate(birthday, remindCal.getTime());
                result.add(remindBirthday);
            }
            // 判断生日当天是否在区间内
            if (!thisYearBirth.getTime().before(startDate) && !thisYearBirth.getTime().after(endDate)) {
                Birthday dayBirthday = copyBirthdayWithDate(birthday, thisYearBirth.getTime());
                result.add(dayBirthday);
            }
        }
        return Response.success(result,result.size());
    }

    @Override
    public Response batchAddBirthdays(List<Birthday> birthdays) {
        for (Birthday birthday : birthdays) {
            birthday.setId(UUID.randomUUID().toString());
            int result = baseMapper.insertSelective(birthday);
            if (result != 1) {
                return Response.error("1009", "批量添加生日失败");
            }
        }
        return Response.success(birthdays);
    }

    @Override
    public Response getBirthdayById(String id) {
        Birthday birthday = baseMapper.selectByPrimaryKey( id);
        if (birthday != null){
            return Response.success(birthday);
        } else  {
            return Response.error("1014", "生日不存在");
        }
    }

    // 复制Birthday对象并设置提醒日期
    private Birthday copyBirthdayWithDate(Birthday source, Date remindDate) {
        Birthday copy = new Birthday();
        BeanUtils.copyProperties(source, copy);
        if (remindDate != null && source.getDate() != null) {
            Calendar remindCal = Calendar.getInstance();
            remindCal.setTime(remindDate);
            Calendar sourceCal = Calendar.getInstance();
            sourceCal.setTime(source.getDate());
            // 只比较月和日，避免闰年/平年问题
            if (remindCal.get(Calendar.MONTH) == sourceCal.get(Calendar.MONTH)
                    && remindCal.get(Calendar.DAY_OF_MONTH) == sourceCal.get(Calendar.DAY_OF_MONTH)) {
                copy.setDescription("今天是" + source.getName() + "生日");
            } else {
                copy.setDescription(source.getName() + "生日快到了");
            }
        }
        copy.setDate(remindDate);
        return copy;
    }
}
