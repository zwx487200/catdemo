package com.example.catdemo.service.impl;

import com.example.catdemo.entity.Todo;
import com.example.catdemo.mapper.TodosMapper;
import com.example.catdemo.service.TodosService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 待办事项核心表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-03-24 17:16
 */
@Service
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodosMapper todosMapper;

    /**
     * @param todo
     * @return
     */
    @Override
    public Response addTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        int result = todosMapper.insertSelective(todo);
        if (result == 1) {
            return Response.success(todo);
        } else {
            return Response.error("添加失败");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Response deleteTodo(String id) {
        return null;
    }

    /**
     * @param todo
     * @return
     */
    @Override
    public Response updateTodo(Todo todo) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Response getTodo(String id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Response getTodos() {
        return null;
    }
}
