package com.example.catdemo.service.impl;

import com.example.catdemo.entity.DayEventExample;
import com.example.catdemo.service.DayEventService;
import com.example.catdemo.entity.DayEvent;
import com.example.catdemo.mapper.DayEventMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 日程表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class DayEventServiceImpl extends ServiceImpl<DayEventMapper, DayEvent> implements DayEventService {

    @Autowired
    private DayEventMapper dayEventMapper;
    @Override
    public Response addDayEvent(DayEvent dayEvent) {
        if(StringUtils.isNotBlank(dayEvent.getId())){
            return updateDayEvent(dayEvent);
        }
        dayEvent.setId(UUID.randomUUID().toString());
        int result = dayEventMapper.insertSelective(dayEvent);
        if (result == 1) {
            return Response.success(dayEvent);
        } else {
            return Response.error("1006", "添加日程失败");
        }
    }

    @Override
    public Response updateDayEvent(DayEvent dayEvent) {
        int result = dayEventMapper.updateByPrimaryKeySelective(dayEvent);
        if (result == 1) {
            return Response.success(dayEvent);
        } else {
            return Response.error("1007", "更新日程失败");
        }
    }

    @Override
    public Response deleteDayEvent(String dayEventId) {
        int result = dayEventMapper.deleteByPrimaryKey(dayEventId);
        if (result == 1) {
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除日程失败");
        }
    }

    @Override
    public Response getDayEvents(RequestInfo requestInfo) {
        DayEventExample example = new DayEventExample();
        example.createCriteria().andFamilyIdEqualTo(requestInfo.getFamilyId())
                .andFamilyMemberIdIn(requestInfo.getFamilyMemberIds())
                .andDateBetween(requestInfo.getStartDate(), requestInfo.getEndDate());
        List<DayEvent> list =  dayEventMapper.selectByExampleWithBLOBs(example);
        return Response.success(list, list.size());
    }

    @Override
    public Response batchAddDayEvents(List<DayEvent> dayEvents) {
        for (DayEvent dayEvent : dayEvents) {
            dayEvent.setId(UUID.randomUUID().toString());
            int insert = dayEventMapper.insertSelective(dayEvent);
            if (insert != 1){
                return Response.error("1009", "批量添加日程失败");
            }
        }
        return Response.success(dayEvents);
    }

    @Override
    public Response getDayEventById(String id) {
        DayEvent dayEvent = dayEventMapper.selectByPrimaryKey( id);
        if (dayEvent != null){
            return Response.success(dayEvent);
        } else  {
            return Response.error("1010", "日程不存在");
        }
    }
}
