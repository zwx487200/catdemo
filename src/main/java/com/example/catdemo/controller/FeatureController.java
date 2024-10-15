package com.example.catdemo.controller;

import com.example.catdemo.entity.Feature;
import com.example.catdemo.service.FeatureService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-01-08 11:38
 */
@RestController
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;


    @ApiOperation(value = "添加功能")
    @PostMapping("/addFeature")
    public Response addFeature(@RequestBody Feature feature) {
        return featureService.createFeature(feature);
    }


    @ApiOperation(value = "删除功能")
    @DeleteMapping("/{id}")
    public Response deleteFeature(@PathVariable String id) {
        return  featureService.deleteFeature(id);
    }


    @ApiOperation(value = "更新功能")
    @PutMapping("/updateFeature")
    public Response updateFeature(@RequestBody Feature feature) {
        return featureService.updateFeature(feature);
    }


    @ApiOperation(value = "根据ID功能")
    @GetMapping("/{id}")
    public Response getFeatureById(@PathVariable String id) {
        return featureService.getFeatureById(id);
    }




    @ApiOperation(value = "查询所有功能")
    @PostMapping("/getFeaturesByCondition")
    public Response getFeaturesByCondition(@RequestBody Feature feature) {
        return featureService.getFeature(feature);
    }


}
