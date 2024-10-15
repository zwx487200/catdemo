package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.TaskMapper;
import com.example.catdemo.service.PointsChangeLogService;
import com.example.catdemo.service.RewardPenaltyService;
import com.example.catdemo.service.TaskService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.catdemo.utils.Response.success;

/**
 * 服务实现类
 *
 * @author zhanhuibin
 * @since 2024-12-05 19:37
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private PointsChangeLogService pointsChangeLogService;

    @Autowired
    private RewardPenaltyService rewardPenaltyService;

    /**
     * 创建任务
     * @param task 任务对象
     * @return 创建后的任务对象
     */
    @Override
    public Response createTask(Task task) {
        if(task == null){
            return Response.error("创建任务失败，任务对象为空");
        }
        if (task.getExecutorId() != null ) {
            task.setTaskStatus("02");
        }
        int result = taskMapper.insertSelective(task);
        if (result == 0) {
            return Response.error("创建任务失败");
        }
        return success(task);
    }

    /**
     * 更新任务
     * @param task 任务对象
     * @return 更新后的任务对象
     */
    @Override
    public Response updateTask(Task task) {
        taskMapper.updateByPrimaryKeySelective(task);
        return Response.success(task);
    }

    /**
     * 根据任务ID获取任务
     * @param taskId 任务ID
     * @return 任务对象
     */
    @Override
    public Task getTaskById(String taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

//    /**
//     * 获取所有任务
//     * @return 任务列表
//     */
//    @Override
//    public List<Task> getAllTasks() {
//        return taskMapper.selectByExample();
//    }

    /**
     * 删除任务
     * @param taskId 任务ID
     */
    @Override
    public void deleteTask(String taskId) {
        taskMapper.deleteByPrimaryKey(taskId);
    }

    /**
     * 根据状态获取任务
     * @param requestInfo 任务
     * @return 任务列表
     */
    @Override
    public Response getTasksByCondition(RequestInfo requestInfo) throws ParseException {
        // task 转换为 taskExample 对象
        Task task = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<Task>() { });
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        if (null != task) {
            if (StringUtils.isNotBlank(task.getTaskType())) {
                criteria.andTaskTypeEqualTo(task.getTaskType());
            }
            if (StringUtils.isNotBlank(task.getTaskStatus())){
                criteria.andTaskStatusEqualTo(task.getTaskStatus());
            }
            if (StringUtils.isNotBlank(task.getTaskContent())){
                criteria.andTaskContentLike("'%" + task.getTaskContent() + "%'");
            }
            if (StringUtils.isNotBlank(task.getInitiatorId())){
                criteria.andInitiatorIdEqualTo(task.getInitiatorId());
            }
            if (StringUtils.isNotBlank(task.getExecutorId())) {
                criteria.andExecutorIdEqualTo(task.getExecutorId());
            }
        }
        if (requestInfo.getStartDate()!= null && requestInfo.getEndDate()!= null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            criteria.andStartTimeLessThan(sdf.parse(sdf.format(requestInfo.getEndDate())));
            criteria.andEndTimeGreaterThan(sdf.parse(sdf.format(requestInfo.getStartDate())));
            //criteria.andCreatedAtBetween(sdf.parse(sdf.format(requestInfo.getStartDate())), sdf.parse(sdf.format(requestInfo.getEndDate())));
        }
        if (requestInfo.getQueryDate() != null){
            criteria.andStartTimeLessThanOrEqualTo(requestInfo.getQueryDate());
            criteria.andEndTimeGreaterThanOrEqualTo(requestInfo.getQueryDate());
        }
        if (requestInfo.getFamilyMemberIds() != null){
            criteria.andExecutorIdIn(requestInfo.getFamilyMemberIds());
        }
        if (requestInfo.getSort() != null){
            if (requestInfo.getSort().equals("asc")) {
                taskExample.setOrderByClause("created_at asc");
            } else {
                taskExample.setOrderByClause("created_at desc");
            }
        }


        // 根据 taskExample 对象查询任务
        PageHelper.startPage(requestInfo.getPageNum(), requestInfo.getPageSize());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
       return success(tasks,pageInfo.getTotal());
    }

    @Override
    public Response verifyTask(Task task) {
        if (task == null) {
            return Response.error("任务对象为空");
        }
        if (task.getExecutorId() == null) {
            return Response.error("任务执行人不能为空");
        }
        if (task.getTaskType() == null) {
            return Response.error("任务类型不能为空");
        }
        // 如果是奖励类型为01 ，表示是积分奖励
        if ("01".equals(task.getRewardType()) ){
            PointsChangeLog pointsChangeLog = new PointsChangeLog();
            pointsChangeLog.setUserId(task.getExecutorId());
            pointsChangeLog.setOperatorId(task.getInitiatorId());
            if (task.getHasPenalty() != null && "01".equals(task.getHasPenalty()) ){
                pointsChangeLog.setChangeType("02");
                pointsChangeLog.setChangeAmount(BigDecimal.valueOf(Long.parseLong(task.getPenalty())));
            } else {
                pointsChangeLog.setChangeType("01");
                pointsChangeLog.setChangeAmount(BigDecimal.valueOf(Long.parseLong(task.getReward())));
            }
            Response response = pointsChangeLogService.addPointsChangeLog(pointsChangeLog);
            if (response != null && Response.isSuccess(response)) {
                // 修改任务状态
                Task updateTask = new Task();
                updateTask.setTaskId(task.getTaskId());
                updateTask.setTaskStatus("04");
                int result = taskMapper.updateByPrimaryKeySelective(updateTask);
                if (result == 0) {
                    return Response.error("任务完成，奖励发放失败");
                } else {
                    return Response.success("任务完成，奖励已发放");
                }
            }
            return Response.success("任务完成，奖励已发放");
        } else{
            RewardPenalty rewardPenalty = new RewardPenalty();
            rewardPenalty.setUserId(task.getExecutorId());
            if (task.getHasPenalty() != null && "01".equals(task.getHasPenalty()) ){
                rewardPenalty.setRewardPenaltyType("02");
                rewardPenalty.setContent(task.getPenalty());
            } else {
                rewardPenalty.setRewardPenaltyType("01");
                rewardPenalty.setContent(task.getReward());
            }
            rewardPenalty.setStatus("01");
            Response response =  rewardPenaltyService.addRewardPenalty(rewardPenalty);
            if (response != null && Response.isSuccess(response)) {
                // 修改任务状态
                Task updateTask = new Task();
                updateTask.setTaskId(task.getTaskId());
                updateTask.setTaskStatus("04");
                int result = taskMapper.updateByPrimaryKeySelective(updateTask);
                if (result == 0) {
                    return Response.error("任务完成，奖励发放失败");
                } else {
                    return Response.success("任务完成，奖励已发放");
                }
            }
            return Response.success("任务完成，奖励已发放");
        }
    }
}
