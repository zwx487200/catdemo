package com.example.catdemo.service;

import com.example.catdemo.entity.TodoRepeatInstance;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *  服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
public interface TodoRepeatInstanceService extends IService<TodoRepeatInstance> {

  Response addTodoRepeatInstance(TodoRepeatInstance todoRepeatInstance);

  Response updateTodoRepeatInstance(TodoRepeatInstance todoRepeatInstance);

  Response deleteTodoRepeatInstance(String todoRepeatInstanceId);

  Response getTodoRepeatInstances(TodoRepeatInstance todoRepeatInstance);

}
