package com.example.catdemo.service;

import com.example.catdemo.entity.DayEvent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 日程表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface DayEventService extends IService<DayEvent> {

    Response addDayEvent(DayEvent dayEvent);

    Response updateDayEvent(DayEvent dayEvent);

    Response deleteDayEvent(String dayEventId);

    Response getDayEvents(RequestInfo requestInfo);

    Response batchAddDayEvents(List<DayEvent> dayEvents);

    Response getDayEventById(String id);

}
