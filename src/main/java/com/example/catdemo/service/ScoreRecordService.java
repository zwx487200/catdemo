package com.example.catdemo.service;

import com.example.catdemo.entity.ScoreRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.entity.Subject;
import com.example.catdemo.utils.Response;

/**
 * 学习成绩记录表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:02
 */
public interface ScoreRecordService extends IService<ScoreRecord> {

    Response addScoreRecord(ScoreRecord scoreRecord);

    Response deleteScoreRecord(ScoreRecord scoreRecord);
    Response updateScoreRecord(ScoreRecord scoreRecord);
    Response getScoreRecordById(ScoreRecord scoreRecord);
    Response getScoreRecordBySubjectId(ScoreRecord scoreRecord);
    Response getScoreRecordList(ScoreRecord scoreRecord);



}
