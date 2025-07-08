package com.example.catdemo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.example.catdemo.entity.AnniversaryExample;
import com.example.catdemo.entity.Anniversary;
import com.example.catdemo.service.AnniversaryService;
import com.example.catdemo.entity.Anniversary;
import com.example.catdemo.mapper.AnniversaryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 纪念日表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class AnniversaryServiceImpl extends ServiceImpl<AnniversaryMapper, Anniversary> implements AnniversaryService {


    @Autowired
    AnniversaryMapper anniversaryMapper;
    @Override
    public Response addAnniversary(Anniversary anniversary) {
        if(StringUtils.isNotBlank(anniversary.getId())){
            return  updateAnniversary(anniversary);
        }
        anniversary.setId(UUID.randomUUID().toString());
        int insert = anniversaryMapper.insertSelective(anniversary);
        if (insert == 1){
            return Response.success(anniversary);
        } else {
            return Response.error("1006", "添加纪念日失败");
        }
    }

    @Override
    public Response updateAnniversary(Anniversary anniversary) {
        int update = anniversaryMapper.updateByPrimaryKeySelective(anniversary);
        if (update == 1){
            return Response.success(anniversary);
        } else {
            return Response.error("1007", "更新纪念日失败");
        }
    }

    @Override
    public Response deleteAnniversary(String anniversaryId) {
        int delete = anniversaryMapper.deleteByPrimaryKey(anniversaryId);
        if (delete == 1){
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除纪念日失败");
        }
    }

    @Override
    public Response getAnniversaries(RequestInfo requestInfo) {
        AnniversaryExample example = new AnniversaryExample();
        example.createCriteria()
                .andFamilyIdEqualTo(requestInfo.getFamilyId())
                .andFamilyMemberIdIn(requestInfo.getFamilyMemberIds());
        List<Anniversary> list =  anniversaryMapper.selectByExample(example);

        Date startDate = requestInfo.getStartDate();
        Date endDate = requestInfo.getEndDate();
        List<Anniversary> result = new ArrayList<>();
        for (Anniversary anniversary : list) {
            // 只取月日
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(anniversary.getDate());
            int month = birthCal.get(Calendar.MONTH) + 1;
            int day = birthCal.get(Calendar.DAY_OF_MONTH);

            // 今年的生日
            Calendar thisYearBirth = Calendar.getInstance();
            thisYearBirth.setTime(startDate);
            thisYearBirth.set(Calendar.MONTH, month - 1);
            thisYearBirth.set(Calendar.DAY_OF_MONTH, day);


            // 今年的生日提醒日
            int remindDays = anniversary.getRemindDays() != null ? anniversary.getRemindDays() : 0;
            Calendar remindCal = (Calendar) thisYearBirth.clone();
            remindCal.add(Calendar.DAY_OF_MONTH, -remindDays);

            // 判断提醒日是否在区间内
            if (!remindCal.getTime().before(startDate) && !remindCal.getTime().after(endDate)) {
                Anniversary remindBirthday = copyBirthdayWithDate(anniversary, remindCal.getTime());
                result.add(remindBirthday);
            }
            // 判断生日当天是否在区间内
            if (!thisYearBirth.getTime().before(startDate) && !thisYearBirth.getTime().after(endDate)) {
                Anniversary dayBirthday = copyBirthdayWithDate(anniversary, thisYearBirth.getTime());
                result.add(dayBirthday);
            }
        }
        return Response.success(result,result.size());
    }

    @Override
    public Response batchAddAnniversaries(List<Anniversary> anniversaries) {
        for (Anniversary anniversary : anniversaries) {
            anniversary.setId(UUID.randomUUID().toString());
            int insert = anniversaryMapper.insertSelective(anniversary);
            if (insert != 1){
                return Response.error("1009", "批量添加纪念日失败");
            }
        }
        return Response.success(anniversaries);
    }

    @Override
    public Response getAnniversaryById(String id) {
        Anniversary anniversary = anniversaryMapper.selectByPrimaryKey(id);
        if (anniversary == null){
            return Response.error("1010", "纪念日不存在");
        }
        return Response.success(anniversary);
    }

    // 复制Birthday对象并设置提醒日期
    private Anniversary copyBirthdayWithDate(Anniversary source, Date remindDate) {
        Anniversary copy = new Anniversary();
        BeanUtils.copyProperties(source, copy);
        if (remindDate != null && source.getDate() != null) {
            Calendar remindCal = Calendar.getInstance();
            remindCal.setTime(remindDate);
            Calendar sourceCal = Calendar.getInstance();
            sourceCal.setTime(source.getDate());
            // 只比较月和日，避免闰年/平年问题
            if (remindCal.get(Calendar.MONTH) == sourceCal.get(Calendar.MONTH)
                    && remindCal.get(Calendar.DAY_OF_MONTH) == sourceCal.get(Calendar.DAY_OF_MONTH)) {
                copy.setDescription("今天是" + source.getTitle());
            } else {
                copy.setDescription(source.getTitle() + "快到了");
            }
        }
        copy.setDate(remindDate);
        return copy;
    }
}
