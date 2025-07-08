package com.example.catdemo.service;

import com.example.catdemo.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.Response;

/**
 * 科目字典表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:01
 */
public interface SubjectService extends IService<Subject> {

    Response addSubject(Subject subject);

    Response deleteSubject(String id);

    Response updateSubject(Subject subject);

    Response getSubject(String id);

    Response getBaseSubject();

    Response getCustomSubject();

    Response getSubjectByFamilyId(String familyId);

}
