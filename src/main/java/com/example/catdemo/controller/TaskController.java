package com.example.catdemo.controller;

import com.example.catdemo.entity.Task;
import com.example.catdemo.service.TaskService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * 前端控制器
 *
 * @author zhanhuibin
 * @since 2024-12-05 19:37
 */
@Api(tags = "前端控制器")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 创建任务
     *
     * @param task 任务对象
     * @return 创建后的任务
     */
    @PostMapping("/addTask")
    public Response addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * 更新任务
     *
     * @param task 任务对象
     * @return 更新后的任务
     */
    @PostMapping("/updateTask")
    public Response updateTask(@RequestBody Task task) {

        return taskService.updateTask(task);
    }

    /**
     * 根据状态获取任务
     *
     * @param requestInfo 任务
     * @return 任务列表
     */
    @PostMapping("/queryTaskByCondition")
    public Response getTasksByStatus(@RequestBody RequestInfo requestInfo) throws ParseException {
        return taskService.getTasksByCondition(requestInfo);
    }

    @PostMapping("/verifyTask")
    public Response  verifyTask(@RequestBody Task task) {
        return taskService.verifyTask(task);
    }
}

