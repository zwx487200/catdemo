package com.example.catdemo.service.impl;

import com.example.catdemo.entity.TodoRepeatInstanceExample;
import com.example.catdemo.service.TodoRepeatInstanceService;
import com.example.catdemo.entity.TodoRepeatInstance;
import com.example.catdemo.mapper.TodoRepeatInstanceMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 *  服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@Service
public class TodoRepeatInstanceServiceImpl extends ServiceImpl<TodoRepeatInstanceMapper, TodoRepeatInstance> implements TodoRepeatInstanceService {

    @Autowired
    private TodoRepeatInstanceMapper todoRepeatInstanceMapper;

    @Override
    public Response addTodoRepeatInstance(TodoRepeatInstance todoRepeatInstance) {
        if (StringUtils.isNotBlank(todoRepeatInstance.getId())) {
            return updateTodoRepeatInstance(todoRepeatInstance);
        }
        todoRepeatInstance.setId(UUID.randomUUID().toString());
        int result = todoRepeatInstanceMapper.insertSelective(todoRepeatInstance);
        if (result == 1) {
            return Response.success(todoRepeatInstance);
        } else {
            return Response.error("1006", "添加任务失败");
        }
    }

    @Override
    public Response updateTodoRepeatInstance(TodoRepeatInstance todoRepeatInstance) {
        if (StringUtils.isBlank(todoRepeatInstance.getId())) {
            return addTodoRepeatInstance(todoRepeatInstance);
        }
        int result = todoRepeatInstanceMapper.updateByPrimaryKeySelective(todoRepeatInstance);
        if (result == 1) {
            return Response.success(todoRepeatInstance);
        } else {
            return Response.error("1007", "更新任务失败");
        }
    }

    @Override
    public Response deleteTodoRepeatInstance(String todoRepeatInstanceId) {
        int result = todoRepeatInstanceMapper.deleteByPrimaryKey(todoRepeatInstanceId);
        if (result == 1) {
            return Response.success("删除成功");
        } else {
            return Response.error("1008", "删除任务失败");
        }
    }

    @Override
    public Response getTodoRepeatInstances(TodoRepeatInstance todoRepeatInstance) {
        TodoRepeatInstanceExample example = new TodoRepeatInstanceExample();
        TodoRepeatInstanceExample.Criteria criteria = example.createCriteria();
        criteria.andTodoIdEqualTo(todoRepeatInstance.getTodoId());
        List<TodoRepeatInstance> todoRepeatInstances = todoRepeatInstanceMapper.selectByExample(example);
        return Response.success(todoRepeatInstances, todoRepeatInstances.size());
    }
}
