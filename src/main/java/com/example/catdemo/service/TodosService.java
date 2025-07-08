package com.example.catdemo.service;


import com.example.catdemo.entity.Todo;
import com.example.catdemo.utils.Response;

/**
 * 待办事项核心表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-03-24 17:16
 */
public interface TodosService {
    Response addTodo(Todo todo);

    Response deleteTodo(String id);

    Response updateTodo(Todo todo);

    Response getTodo(String id);

    Response getTodos();

}
