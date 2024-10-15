package com.example.catdemo.service;

import com.example.catdemo.entity.Task;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.text.ParseException;
import java.util.List;

/**
 * 服务类接口
 *
 * @author zhanhuibin
 * @since 2024-12-05 19:37
 */
public interface TaskService {

    /**
     * 创建任务
     * @param task 任务对象
     * @return 创建后的任务对象
     */
    Response createTask(Task task);

    /**
     * 更新任务
     * @param task 任务对象
     * @return 更新后的任务对象
     */
    Response updateTask(Task task);

    /**
     * 根据任务ID获取任务
     * @param taskId 任务ID
     * @return 任务对象
     */
    Task getTaskById(String taskId);

//    /**
//     * 获取所有任务
//     * @return 任务列表
//     */
//    List<Task> getAllTasks();

    /**
     * 删除任务
     * @param taskId 任务ID
     */
    void deleteTask(String taskId);

    /**
     * 根据状态获取任务
     * @param equestInfo 任务
     * @return 任务列表
     */
    Response getTasksByCondition(RequestInfo equestInfo) throws ParseException;

    Response verifyTask(Task task);

}
