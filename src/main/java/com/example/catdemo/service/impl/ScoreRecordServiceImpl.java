package com.example.catdemo.service.impl;

import com.example.catdemo.entity.ScoreRecordExample;
import com.example.catdemo.entity.Subject;
import com.example.catdemo.service.ScoreRecordService;
import com.example.catdemo.entity.ScoreRecord;
import com.example.catdemo.mapper.ScoreRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 学习成绩记录表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:02
 */
@Service
public class ScoreRecordServiceImpl extends ServiceImpl<ScoreRecordMapper, ScoreRecord> implements ScoreRecordService {

    @Autowired
    private ScoreRecordMapper scoreRecordMapper;

    @Override
    public Response addScoreRecord(ScoreRecord scoreRecord) {
        scoreRecord.setId(UUID.randomUUID().toString());
        scoreRecord.setCreateTime(new Date());
        scoreRecord.setUpdateTime(new Date());
        int result = scoreRecordMapper.insert(scoreRecord);
        if (result > 0) {
            return Response.success(scoreRecord);
        }
        return Response.error("Add score record failed");
    }

    @Override
    public Response deleteScoreRecord(ScoreRecord scoreRecord) {
        int result = scoreRecordMapper.deleteByPrimaryKey(scoreRecord.getId());
        if (result > 0) {
            return Response.success(scoreRecord);
        }
        return Response.error("Delete score record failed");
    }


    @Override
    public Response updateScoreRecord(ScoreRecord scoreRecord) {
        scoreRecordMapper.updateByPrimaryKeySelective(scoreRecord);
        return Response.success(scoreRecord);
    }

    @Override
    public Response getScoreRecordById(ScoreRecord scoreRecord) {
        ScoreRecord record = scoreRecordMapper.selectByPrimaryKey(scoreRecord.getId());
        if (record != null) {
            return Response.success(record);
        }
        return Response.error("Get score record by id failed");
    }

    @Override
    public Response getScoreRecordBySubjectId(ScoreRecord scoreRecord) {
        ScoreRecordExample example = new ScoreRecordExample();
        example.setDistinct(true);
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(scoreRecord.getSubjectId());
        example.setOrderByClause("create_time desc");
        return Response.success(scoreRecordMapper.selectByExample(example));
    }

    @Override
    public Response getScoreRecordList(ScoreRecord scoreRecord) {
        if(StringUtils.isBlank(scoreRecord.getFamilyMemberId())){
            return Response.error("家庭成员id不能为空");
        }
        ScoreRecordExample example = new ScoreRecordExample();
        example.setDistinct(true);
        ScoreRecordExample.Criteria criteria = example.createCriteria();
        if (scoreRecord.getFamilyMemberId() != null) {
            criteria.andFamilyMemberIdEqualTo(scoreRecord.getFamilyMemberId());
        }
        if (scoreRecord.getSubjectId() != null) {
            criteria.andSubjectIdEqualTo(scoreRecord.getSubjectId());
        }
        if (scoreRecord.getExamType() != null) {
            criteria.andExamTypeEqualTo(scoreRecord.getExamType());
        }
        if (scoreRecord.getExamDate() != null) {
            criteria.andExamDateEqualTo(scoreRecord.getExamDate());
        }
        if (scoreRecord.getScoreScale() != null) {
            criteria.andScoreScaleEqualTo(scoreRecord.getScoreScale());
        }
        example.setOrderByClause("exam_date desc");
        return Response.success(scoreRecordMapper.selectByExample(example));
    }
}

