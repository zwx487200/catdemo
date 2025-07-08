package com.example.catdemo.controller;

import com.example.catdemo.entity.TodoRepeatInstance;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.service.TodoRepeatInstanceService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@RestController
@RequestMapping("/todoRepeatInstance")
public class TodoRepeatInstanceController {
    @Autowired
    TodoRepeatInstanceService todoRepeatInstanceService;

    @RequestMapping("/addTodoRepeatInstance")
    public Response addTodoRepeatInstance(@Validated(addGroup.class) @RequestBody TodoRepeatInstance todoRepeatInstance) {
        return todoRepeatInstanceService.addTodoRepeatInstance(todoRepeatInstance);
    }

    @RequestMapping("/updateTodoRepeatInstance")
    public Response updateTodoRepeatInstance(@Validated @RequestBody TodoRepeatInstance todoRepeatInstance) {
        return todoRepeatInstanceService.updateTodoRepeatInstance(todoRepeatInstance);
    }

    @RequestMapping("/deleteTodoRepeatInstance")
    public Response deleteTodoRepeatInstance(@Validated @RequestBody TodoRepeatInstance todoRepeatInstance) {
        return todoRepeatInstanceService.deleteTodoRepeatInstance(todoRepeatInstance.getId());
    }

    @RequestMapping("/getTodoRepeatInstances")
    public Response getTodoRepeatInstances(@Validated @RequestBody TodoRepeatInstance todoRepeatInstance) {
        return todoRepeatInstanceService.getTodoRepeatInstances(todoRepeatInstance);
    }
}
