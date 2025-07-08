package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.catdemo.entity.*;
import com.example.catdemo.service.*;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    AnniversaryService anniversaryService;

    @Autowired
     BirthdayService birthdayService;

    @Autowired
    CountdownService countdownService;

    @Autowired
    DayEventService dayEventService;

    @Autowired
    TodoItemService todoItemService;




    @Override
    public Response getAllEvents(RequestInfo requestInfo) {

        Response anniversariesResponse =  anniversaryService.getAnniversaries(requestInfo);
        Response birthdaysResponse =birthdayService.getBirthdays(requestInfo);
        Response countdownsResponse = countdownService.getCountdowns(requestInfo);
        Response dayEventsResponse = dayEventService.getDayEvents(requestInfo);
        Response todoItemsResponse = todoItemService.getTodoItems(requestInfo);

        List<CalendarItem> list = new ArrayList<>();
        if (Response.isSuccess(anniversariesResponse)){
            List<Anniversary> anniversaries = (List<Anniversary>) anniversariesResponse.getData();
            for (Anniversary anniversary : anniversaries){
                list.add(anniversarieToCalendarItem( anniversary));
            }
        }
        if (Response.isSuccess(birthdaysResponse)){
            List<Birthday> birthdays = (List<Birthday>) birthdaysResponse.getData();
            for (Birthday birthday : birthdays){
                list.add(birthdayToCalendarItem( birthday));
            }
        }
        if (Response.isSuccess(countdownsResponse)){
            List<Countdown> countdowns = (List<Countdown>) countdownsResponse.getData();
            for (Countdown countdown : countdowns){
                list.add(countdownToCalendarItem(countdown));
            }
        }
        if (Response.isSuccess(dayEventsResponse)){
            List<DayEvent> events = (List<DayEvent>) dayEventsResponse.getData();
            for (DayEvent event : events){
                list.add(dayEventToCalendarItem(event));
            }
        }
        if (Response.isSuccess(todoItemsResponse)){
            List<TodoItem> todoItems = (List<TodoItem>) todoItemsResponse.getData();
            for (TodoItem todoItem : todoItems) {
              list.addAll(todoItemToCalendarItem(todoItem));
            }
            System.out.println("todoItemsResponse================================: " + list.toString());
            
        }
        return Response.success(list, list.size());
    }

    @Override
    public Response batchAddEvents(RequestInfo requestInfo) {


        List<Anniversary> anniversaries = new ArrayList<>();
        List<Birthday> birthdays = new ArrayList<>();
        List<Countdown> countdowns = new ArrayList<>();
        List<DayEvent> dayEvents = new ArrayList<>();
        List<TodoItem> todoItems = new ArrayList<>();

        List<CalendarItem> calendarItems = JSON.parseArray(JSON.toJSONString(requestInfo.getData()), CalendarItem.class);
        if (CollectionUtils.isEmpty(calendarItems)){
            return Response.success("新增成功");
        } else {
            for (CalendarItem calendarItem : calendarItems) {
                if ("anniversary".equals(calendarItem.getType())){
                    Anniversary anniversary = calendarItemToAnniversary(calendarItem);
                    anniversaries.add(anniversary);
                } else if ("birthday".equals(calendarItem.getType())){
                    Birthday birthday = calendarItemToBirthday(calendarItem);
                    birthdays.add(birthday);
                } else if ("countdown".equals(calendarItem.getType())){
                    Countdown countdown = calendarItemToCountdown(calendarItem);
                    countdowns.add(countdown);
                } else if ("dayEvent".equals(calendarItem.getType())){
                    DayEvent dayEvent = calendarItemToDayEvent(calendarItem);
                    dayEvents.add(dayEvent);
                } else if ("todoItem".equals(calendarItem.getType())){
                    TodoItem todoItem = calendarItemToTodoItem(calendarItem);
                    todoItems.add(todoItem);
                } else{
                    continue;
                }
            }
        }
        if (CollectionUtils.isNotEmpty(anniversaries)){
            Response response = anniversaryService.batchAddAnniversaries(anniversaries);
            if (!Response.isSuccess(response)){
                return response;
            }
        }
        if (CollectionUtils.isNotEmpty(birthdays)){
            Response response = birthdayService.batchAddBirthdays(birthdays);
            if (!Response.isSuccess(response)){
                return response;
            }
        }
        if (CollectionUtils.isNotEmpty(countdowns)){
            Response response = countdownService.batchAddCountdowns(countdowns);
            if (!Response.isSuccess(response)){
                return response;
            }
        }
        if (CollectionUtils.isNotEmpty(dayEvents)){
            Response response = dayEventService.batchAddDayEvents(dayEvents);
            if (!Response.isSuccess(response)){
                return response;
            }
        }
        if (CollectionUtils.isNotEmpty(todoItems)){
            Response response = todoItemService.batchAddTodoItems(todoItems);
            if (!Response.isSuccess(response)){
                return response;
            }
        }
        return Response.success("新增成功");
    }

    private CalendarItem anniversarieToCalendarItem(Anniversary anniversary){
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(anniversary.getId());
        calendarItem.setTitle(anniversary.getTitle());
        calendarItem.setDescription(anniversary.getDescription());
        calendarItem.setDate(anniversary.getDate());
        calendarItem.setType("anniversary");
        calendarItem.setFamilyId(anniversary.getFamilyId());
        calendarItem.setFamilyMemberId(anniversary.getFamilyMemberId());
        calendarItem.setUserId(anniversary.getUserId());
        calendarItem.setRemindDays(anniversary.getRemindDays());
        return calendarItem;
    }
    private CalendarItem birthdayToCalendarItem(Birthday birthday){
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(birthday.getId());
        calendarItem.setDate(birthday.getDate());
        calendarItem.setType("birthday");
        calendarItem.setFamilyId(birthday.getFamilyId());
        calendarItem.setFamilyMemberId(birthday.getFamilyMemberId());
        calendarItem.setUserId(birthday.getUserId());
        calendarItem.setTitle(birthday.getName());
        calendarItem.setDescription(birthday.getDescription());
        calendarItem.setRemindDays(birthday.getRemindDays());
        return calendarItem;
    }
    private CalendarItem countdownToCalendarItem(Countdown countdown){
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(countdown.getId());
        calendarItem.setType("countdown");
        calendarItem.setTitle(countdown.getTitle());
        calendarItem.setDescription(countdown.getDescription());
        calendarItem.setDate(countdown.getTargetDate());
        calendarItem.setFamilyId(countdown.getFamilyId());
        calendarItem.setFamilyMemberId(countdown.getFamilyMemberId());
        calendarItem.setUserId(countdown.getUserId());
        calendarItem.setRemindDays(countdown.getRemindDays());
        return calendarItem;
    }
    private CalendarItem dayEventToCalendarItem(DayEvent dayEvent){
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(dayEvent.getId());
        calendarItem.setTitle(dayEvent.getTitle());
        calendarItem.setDescription(dayEvent.getDescription());
        calendarItem.setDate(dayEvent.getDate());
        calendarItem.setFamilyId(dayEvent.getFamilyId());
        calendarItem.setFamilyMemberId(dayEvent.getFamilyMemberId());
        calendarItem.setUserId(dayEvent.getUserId());
        calendarItem.setImportance(dayEvent.getImportance());
        calendarItem.setIsDone(dayEvent.getIsDone());
        calendarItem.setType("dayEvent");
        calendarItem.setStartDate(dayEvent.getStartTime());
        calendarItem.setEndDate(dayEvent.getEndTime());

        return calendarItem;
    }

    private List<CalendarItem> todoItemToCalendarItem(TodoItem todoItem) {
      List<CalendarItem> calendarItems = new ArrayList<>();
      for (TodoRepeatInstance repeatInstance : todoItem.getRepeatInstances()) {
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setType("todoItem");
        calendarItem.setId(repeatInstance.getId());
        calendarItem.setTodoItemId(todoItem.getId());
        calendarItem.setTitle(todoItem.getTitle());
        calendarItem.setDescription(todoItem.getDescription());
        calendarItem.setDate(repeatInstance.getInstanceDate());
        calendarItem.setFamilyId(todoItem.getFamilyId());
        calendarItem.setFamilyMemberId(todoItem.getFamilyMemberId());
        calendarItem.setUserId(todoItem.getUserId());
        calendarItem.setIsDone(repeatInstance.getIsDone());
        calendarItems.add(calendarItem);
      }
      return calendarItems;
    }
    
    private TodoItem calendarItemToTodoItem(CalendarItem calendarItem) {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(calendarItem.getId());
        todoItem.setTitle(calendarItem.getTitle());
        todoItem.setDescription(calendarItem.getDescription());
        todoItem.setFamilyId(calendarItem.getFamilyId());
        todoItem.setFamilyMemberId(calendarItem.getFamilyMemberId());
        todoItem.setUserId(calendarItem.getUserId());
        todoItem.setStartDate(calendarItem.getStartDate());
        todoItem.setEndDate(calendarItem.getEndDate());
        return todoItem;
    }

    // 反向转换方法
    private Anniversary calendarItemToAnniversary(CalendarItem calendarItem){
        Anniversary anniversary = new Anniversary();
        anniversary.setId(calendarItem.getId());
        anniversary.setTitle(calendarItem.getTitle());
        anniversary.setDescription(calendarItem.getDescription());
        anniversary.setDate(calendarItem.getDate());
        anniversary.setFamilyId(calendarItem.getFamilyId());
        anniversary.setFamilyMemberId(calendarItem.getFamilyMemberId());
        anniversary.setUserId(calendarItem.getUserId());
        return anniversary;
    }

    private Birthday calendarItemToBirthday(CalendarItem calendarItem){
        Birthday birthday = new Birthday();
        birthday.setId(calendarItem.getId());
        birthday.setDate(calendarItem.getDate());
        birthday.setFamilyId(calendarItem.getFamilyId());
        birthday.setFamilyMemberId(calendarItem.getFamilyMemberId());
        birthday.setUserId(calendarItem.getUserId());
        birthday.setName(calendarItem.getTitle());
        birthday.setDescription(calendarItem.getDescription());
        return birthday;
    }

    private Countdown calendarItemToCountdown(CalendarItem calendarItem){
        Countdown countdown = new Countdown();
        countdown.setId(calendarItem.getId());
        countdown.setTitle(calendarItem.getTitle());
        countdown.setDescription(calendarItem.getDescription());
        countdown.setTargetDate(calendarItem.getDate());
        countdown.setFamilyId(calendarItem.getFamilyId());
        countdown.setFamilyMemberId(calendarItem.getFamilyMemberId());
        countdown.setUserId(calendarItem.getUserId());
        return countdown;
    }

    private DayEvent calendarItemToDayEvent(CalendarItem calendarItem){
        DayEvent dayEvent = new DayEvent();
        dayEvent.setId(calendarItem.getId());
        dayEvent.setTitle(calendarItem.getTitle());
        dayEvent.setDescription(calendarItem.getDescription());
        dayEvent.setDate(calendarItem.getDate());
        dayEvent.setFamilyId(calendarItem.getFamilyId());
        dayEvent.setFamilyMemberId(calendarItem.getFamilyMemberId());
        dayEvent.setUserId(calendarItem.getUserId());
        dayEvent.setImportance(calendarItem.getImportance());
        dayEvent.setIsDone(calendarItem.getIsDone());
        dayEvent.setStartTime(calendarItem.getStartDate());
        dayEvent.setEndTime(calendarItem.getEndDate());
        return dayEvent;
    }



}
