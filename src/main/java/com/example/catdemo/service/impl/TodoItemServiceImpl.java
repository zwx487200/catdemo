package com.example.catdemo.service.impl;

import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.TodoRepeatInstanceMapper;
import com.example.catdemo.service.TodoItemService;
import com.example.catdemo.mapper.TodoItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.service.TodoRepeatInstanceService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class TodoItemServiceImpl extends ServiceImpl<TodoItemMapper, TodoItem> implements TodoItemService {

    @Autowired
    TodoItemMapper todoItemMapper;

    @Autowired
    TodoRepeatInstanceMapper todoRepeatInstanceMapper;

    @Override
    public Response addTodoItem(TodoItem todoItem) {
        if(StringUtils.isNotBlank(todoItem.getId())){
            return updateTodoItem(todoItem);
        }
        todoItem.setId(UUID.randomUUID().toString());
        int result = todoItemMapper.insertSelective(todoItem);
        if (result == 1) {
            return Response.success(todoItem);
        } else {
            return Response.error("1006", "添加任务失败");
        }
    }

    @Override
    public Response updateTodoItem(TodoItem todoItem) {
        int result = todoItemMapper.updateByPrimaryKeySelective(todoItem);
        if (result == 1) {
            return Response.success(todoItem);
        } else {
            return Response.error("1007", "更新任务失败");
        }
    }

    @Override
    public Response deleteTodoItem(String todoItemId) {
        int result = todoItemMapper.deleteByPrimaryKey(todoItemId);
        if (result == 1) {
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除任务失败");
        }
    }

    @Override
    public Response getTodoItems(RequestInfo requestInfo) {
        TodoItemExample example = new TodoItemExample();
        example.createCriteria().andFamilyIdEqualTo(requestInfo.getFamilyId())
                .andFamilyMemberIdIn(requestInfo.getFamilyMemberIds());
        List<TodoItem> list = todoItemMapper.selectByExampleWithBLOBs(example);
        
        // 查询这个待办的完成情况
        for (TodoItem todoItem : list) {
            // 1. 根据repeatRule计算所有待办日期
            List<TodoRepeatInstance> calculatedInstances = calculateTodoInstances(todoItem, requestInfo.getStartDate(), requestInfo.getEndDate());
            
            // 2. 查询数据库中已存在的完成记录
            TodoRepeatInstanceExample todoRepeatInstanceExample = new TodoRepeatInstanceExample();
            todoRepeatInstanceExample.createCriteria()
                    .andTodoIdEqualTo(todoItem.getId());
            List<TodoRepeatInstance> existingInstances = todoRepeatInstanceMapper.selectByExample(todoRepeatInstanceExample);
            
            // 3. 合并计算出的日期和数据库中的完成状态
            List<TodoRepeatInstance> mergedInstances = mergeInstances(calculatedInstances, existingInstances);
            
            todoItem.setRepeatInstances(mergedInstances);
        }
        return Response.success(list, list.size());
    }

    @Override
    public Response batchAddTodoItems(List<TodoItem> todoItems) {
        for (TodoItem todoItem : todoItems){
            todoItem.setId(UUID.randomUUID().toString());
            int result = todoItemMapper.insertSelective(todoItem);
            if (result != 1) {
                return Response.error("1006", "添加任务失败");
            }
        }
        return Response.success(todoItems);
    }

    @Override
    public Response getTodoItemById(String id) {
        TodoItem todoItem = todoItemMapper.selectByPrimaryKey(id);
        if (todoItem != null) {
            // 计算待办的日子
            // 查询数据库里面的待办完成情况
            // 替换计算出来的待办的isdone
            List<TodoRepeatInstance> calculatedInstances = calculateTodoInstances(todoItem, todoItem.getStartDate(), todoItem.getEndDate());
            // 2. 查询数据库中已存在的完成记录
            TodoRepeatInstanceExample todoRepeatInstanceExample = new TodoRepeatInstanceExample();
            todoRepeatInstanceExample.createCriteria()
                    .andTodoIdEqualTo(todoItem.getId());
            List<TodoRepeatInstance> existingInstances = todoRepeatInstanceMapper.selectByExample(todoRepeatInstanceExample);

            // 3. 合并计算出的日期和数据库中的完成状态
            List<TodoRepeatInstance> mergedInstances = mergeInstances(calculatedInstances, existingInstances);

            todoItem.setRepeatInstances(mergedInstances);
            return Response.success(todoItem);
        } else {
            return Response.error("1010", "任务不存在");
        }
    }

    /**
     * 根据repeatRule计算待办日期
     */
    private List<TodoRepeatInstance> calculateTodoInstances(TodoItem todoItem, Date startDate, Date endDate) {
        List<TodoRepeatInstance> instances = new ArrayList<>();
        String repeatRule = todoItem.getRepeatRule();
        
        if (repeatRule == null || repeatRule.isEmpty()) {
            return instances;
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(todoItem.getStartDate());
        
        // 确保从开始日期开始计算
        while (cal.getTime().before(startDate)) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        // 解析repeatRule
        if (repeatRule.startsWith("weekly:")) {
            // weekly:[1,3,5] 格式
            String daysStr = repeatRule.substring(7); // 去掉前缀，得到 [1,3,5]
            daysStr = daysStr.substring(1, daysStr.length() - 1); // 去掉两边的中括号
            String[] dayArray = daysStr.split(",");
            List<Integer> weekDays = new ArrayList<>();
            for (String day : dayArray) {
                if (!day.trim().isEmpty()) {
                    weekDays.add(Integer.parseInt(day.trim()));
                }
            }
            
            // 计算每周指定日期的待办
            while (!cal.getTime().after(endDate) && !cal.getTime().after(todoItem.getEndDate())) {
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                // Calendar中周日是1，周一是2，所以需要转换
                int adjustedDayOfWeek = dayOfWeek == Calendar.SUNDAY ? 7 : dayOfWeek - 1;
                
                if (weekDays.contains(adjustedDayOfWeek)) {
                    TodoRepeatInstance instance = new TodoRepeatInstance();
                    instance.setTodoId(todoItem.getId());
                    instance.setInstanceDate(cal.getTime());
                    instance.setIsDone(0); // 默认未完成
                    instances.add(instance);
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            
        } else if (repeatRule.startsWith("daily:")) {
            // daily:[] 格式，每天都有
            while (!cal.getTime().after(endDate) && !cal.getTime().after(todoItem.getEndDate())) {
                TodoRepeatInstance instance = new TodoRepeatInstance();
                instance.setTodoId(todoItem.getId());
                instance.setInstanceDate(cal.getTime());
                instance.setIsDone(0); // 默认未完成
                instances.add(instance);
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            
        } else if (repeatRule.startsWith("monthly:")) {
            // monthly:[1,10,15,20,25] 格式
            String daysStr = repeatRule.substring(8); // 去掉前缀，得到 [1,10,15,20,25]
            daysStr = daysStr.substring(1, daysStr.length() - 1); // 去掉两边的中括号
            String[] dayArray = daysStr.split(",");
            List<Integer> monthDays = new ArrayList<>();
            for (String day : dayArray) {
                if (!day.trim().isEmpty()) {
                    monthDays.add(Integer.parseInt(day.trim()));
                }
            }
            
            // 计算每月指定日期的待办
            while (!cal.getTime().after(endDate) && !cal.getTime().after(todoItem.getEndDate())) {
                int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                
                if (monthDays.contains(dayOfMonth)) {
                    TodoRepeatInstance instance = new TodoRepeatInstance();
                    instance.setTodoId(todoItem.getId());
                    instance.setInstanceDate(cal.getTime());
                    instance.setIsDone(0); // 默认未完成
                    instances.add(instance);
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        }  else if (repeatRule.startsWith("noRepeat:")) {
            // noRepeat:[] 格式，不重复
            if (!todoItem.getStartDate().after(endDate) && !todoItem.getStartDate().after(todoItem.getEndDate())) {
                TodoRepeatInstance instance = new TodoRepeatInstance();
                instance.setTodoId(todoItem.getId());
                instance.setInstanceDate(todoItem.getStartDate());
                instance.setIsDone(0); // 默认未完成
                instances.add(instance);
            }
        } 
        
        return instances;
    }

    /**
     * 合并计算出的实例和数据库中的完成状态
     */
    private List<TodoRepeatInstance> mergeInstances(List<TodoRepeatInstance> calculatedInstances, List<TodoRepeatInstance> existingInstances) {
        // 创建日期到完成状态和ID的映射
        Map<Date, Integer> dateToDoneMap = new HashMap<>();
        Map<Date, String> dateToIdMap = new HashMap<>();
        for (TodoRepeatInstance existing : existingInstances) {
            // 清除时间部分，只比较日期
            Calendar cal = Calendar.getInstance();
            cal.setTime(existing.getInstanceDate());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date normalizedDate = cal.getTime();
            dateToDoneMap.put(normalizedDate, existing.getIsDone());
            dateToIdMap.put(normalizedDate, existing.getId());
        }
        
        // 更新计算出的实例的完成状态和ID
        for (TodoRepeatInstance calculated : calculatedInstances) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(calculated.getInstanceDate());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date normalizedDate = cal.getTime();
            
            if (dateToDoneMap.containsKey(normalizedDate)) {
                calculated.setIsDone(dateToDoneMap.get(normalizedDate));
                calculated.setId(dateToIdMap.get(normalizedDate));
            }
        }
        
        return calculatedInstances;
    }
}
