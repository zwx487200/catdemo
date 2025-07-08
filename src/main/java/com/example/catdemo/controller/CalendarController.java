package com.example.catdemo.controller;

import com.example.catdemo.entity.CalendarItem;
import com.example.catdemo.service.CalendarService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController  {

    @Autowired
    CalendarService calendarService;

    // 查询所有事件的汇总接口
    @RequestMapping("/getAllEvents")
    public Response getAllEvents(@RequestBody  RequestInfo requestInfo){
        return calendarService.getAllEvents(requestInfo);
    }

    @RequestMapping("/batchAddEvents")
    public Response batchAddEvents(@RequestBody  RequestInfo requestInfo){
        return calendarService.batchAddEvents(requestInfo);
    }

}
