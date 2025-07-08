package com.example.catdemo.service;

import com.example.catdemo.entity.TodoItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface   TodoItemService extends IService<TodoItem> {

    Response addTodoItem(TodoItem todoItem);

    Response updateTodoItem(TodoItem todoItem);

    Response deleteTodoItem(String todoItemId);

    Response getTodoItems(RequestInfo requestInfo);

    Response batchAddTodoItems(List<TodoItem> todoItems);

    Response getTodoItemById(String id);
}
