package com.example.catdemo.controller;

import com.example.catdemo.entity.Subject;
import com.example.catdemo.entity.Task;
import com.example.catdemo.service.SubjectService;
import com.example.catdemo.service.TaskService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 科目字典表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:01
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 创建学科
     *
     * @param subject 学科实体类
     * @return 创建后的学科
     */
    @PostMapping("/addSubject")
    public Response addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    /**
     * 删除学科
     *
     * @param subject 学科实体类，包含 学科id
     * @return 删除结果
     */
    @PostMapping("/deleteSubject")
    public Response deleteSubject(@RequestBody Subject subject) {
        return subjectService.deleteSubject(subject.getId());
    }

    /**
     * 更新学科
     *
     * @param subject 学科实体类
     * @return 更新后的学科
     */
    @PostMapping("/updateSubject")
    public Response updateSubject(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    /**
     * 获取学科
     *
     * @param subject 学科实体类
     * @return 学科实体类
     */
    @PostMapping("/getSubject")
    public Response getSubject(@RequestBody Subject subject) {
        return subjectService.getSubject(subject.getId());
    }

    /**
     * 获取基础学科
     *
     * @return 基础学科列表
     */
    @PostMapping("/getBaseSubject")
    public Response getBaseSubject() {
        return subjectService.getBaseSubject();
    }

    /**
     * 获取自定义学科
     *
     * @return 自定义学科列表
     */
    @PostMapping("/getCustomSubject")
    public Response getCustomSubject() {
        return subjectService.getCustomSubject();
    }

    /**
     * 根据家长id获取学科
     *
     * @param subject 学科实体类，包含家长id
     * @return 学科列表
     */
    @PostMapping("/getSubjectByFamilyId")
    public Response getSubjectByFamilyId(@RequestBody Subject subject) {
        if (subject.getFamilyId() != null) {
            return subjectService.getSubjectByFamilyId(subject.getFamilyId());
        } else {
            return Response.error("家庭成员id不能为空");
        }
    }

}
