package com.example.catdemo.controller;

import com.example.catdemo.entity.ScoreRecord;
import com.example.catdemo.service.ScoreRecordService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学习成绩记录表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-05-07 11:02
 */
@RestController
@RequestMapping("/scoreRecord")
public class ScoreRecordController {

    @Autowired
    private ScoreRecordService scoreRecordService;

    @PostMapping("/addScoreRecord")
    public Response addScoreRecord(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.addScoreRecord(scoreRecord);
    }

    @PostMapping("/deleteScoreRecord")
    public Response deleteScoreRecord(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.deleteScoreRecord(scoreRecord);
    }

    @PostMapping("/updateScoreRecord")
    public Response updateScoreRecord(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.updateScoreRecord(scoreRecord);
    }

    @PostMapping("/getScoreRecordById")
    public Response getScoreRecordById(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.getScoreRecordById(scoreRecord);
    }

    @PostMapping("/getScoreRecordBySubjectId")
    public Response getScoreRecordBySubjectId(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.getScoreRecordBySubjectId(scoreRecord);
    }

    @PostMapping("/getScoreRecordList")
    public Response getScoreRecordList(@RequestBody ScoreRecord scoreRecord) {
        return scoreRecordService.getScoreRecordList(scoreRecord);
    }
}
