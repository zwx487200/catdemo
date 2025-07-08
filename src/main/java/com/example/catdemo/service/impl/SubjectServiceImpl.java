package com.example.catdemo.service.impl;

import com.example.catdemo.entity.SubjectExample;
import com.example.catdemo.service.SubjectService;
import com.example.catdemo.entity.Subject;
import com.example.catdemo.mapper.SubjectMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 科目字典表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:01
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Response addSubject(Subject subject) {
        if (subject.getFamilyId()!= null) {
            subject.setIsCustom(1);
        } else {
            subject.setIsCustom(0);
        }
        subject.setId(UUID.randomUUID().toString());
        subjectMapper.insert(subject);
        return Response.success(subject);
    }


    @Override
    public Response deleteSubject(String id) {
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        if(subject.getIsCustom() == 0){
            return Response.error("不能删除系统默认科目");
        }
        subjectMapper.deleteByPrimaryKey(id);
        return Response.success(id);
    }

    @Override
    public Response updateSubject(Subject subject) {
        Subject oldSubject = subjectMapper.selectByPrimaryKey(subject.getId());
        if(oldSubject.getIsCustom() == 0){
            return Response.error("不能修改系统默认科目");
        }
        subject.setFamilyId(null);
        subjectMapper.updateById(subject);
        return Response.success(subject);
    }

    @Override
    public Response getSubject(String id) {
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        return Response.success(subject);
    }

    @Override
    public Response getBaseSubject() {
        SubjectExample example = new SubjectExample();
        example.createCriteria().andIsCustomEqualTo(0);
        List<Subject> subjects = subjectMapper.selectByExample(example);
        return Response.success(subjects);
    }

    @Override
    public Response getCustomSubject() {
        return null;
    }

    @Override
    public Response getSubjectByFamilyId(String familyId) {
        SubjectExample example = new SubjectExample();
        example.createCriteria().andFamilyIdEqualTo(familyId);
        List<Subject> subjects = subjectMapper.selectByExample(example);
        return Response.success(subjects);
    }
}
