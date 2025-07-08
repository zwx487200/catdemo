package com.example.catdemo.controller;

import com.example.catdemo.entity.DayEvent;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import com.example.catdemo.service.DayEventService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日程表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@RestController
@RequestMapping("/day-event")
public class DayEventController {

    @Autowired
    private DayEventService dayEventService;

    @RequestMapping("/addDayEvent")
    public Response addDayEvent(@Validated(addGroup.class) @RequestBody DayEvent dayEvent) {
        return dayEventService.addDayEvent(dayEvent);
    }

    @RequestMapping("/updateDayEvent")
    public Response updateDayEvent(@Validated(updateGroup.class) @RequestBody DayEvent dayEvent) {
        return dayEventService.updateDayEvent(dayEvent);
    }

    @RequestMapping("/deleteDayEvent")
    public Response deleteDayEvent(@Validated(deleteGroup.class) @RequestBody DayEvent dayEvent) {
        return dayEventService.deleteDayEvent(dayEvent.getId());
    }

    @RequestMapping("/getDayEvents")
    public Response getDayEvents( @RequestBody RequestInfo requestInfo) {
        return dayEventService.getDayEvents(requestInfo);
    }

    @RequestMapping("/getDayEventById")
    public Response getDayEventById(@Validated(queryGroup.class) @RequestBody DayEvent dayEvent) {
        return dayEventService.getDayEventById(dayEvent.getUserId());
    }


}
