package com.example.catdemo.controller;

import com.example.catdemo.entity.TodoItem;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.service.TodoItemService;
import com.example.catdemo.utils.RequestInfo;
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
@RequestMapping("/todoItem")
public class TodoItemController {

    @Autowired
    TodoItemService todoItemService;

    @RequestMapping("/addTodoItem")
    public Response addTodoItem(@Validated(addGroup.class) @RequestBody TodoItem todoItem){
        return todoItemService.addTodoItem(todoItem);
    }

    @RequestMapping("/updateTodoItem")
    public Response updateTodoItem(@Validated @RequestBody TodoItem todoItem){
        return todoItemService.updateTodoItem(todoItem);
    }

    @RequestMapping("/deleteTodoItem")
    public Response deleteTodoItem(@Validated @RequestBody TodoItem todoItem){
        return todoItemService.deleteTodoItem(todoItem.getId());
    }

    @RequestMapping("/getTodoItems")
    public Response getTodoItems(@RequestBody RequestInfo requestInfo){
        return todoItemService.getTodoItems(requestInfo);
    }

    @RequestMapping("/getTodoItemById")
    public Response getTodoItemById(@Validated(queryGroup.class) @RequestBody TodoItem todoItem){
        return todoItemService.getTodoItemById(todoItem.getId());
    }

}
