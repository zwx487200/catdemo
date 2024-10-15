package com.example.catdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.catdemo.entity.FamilyMemberExample;
import com.example.catdemo.entity.Feature;
import com.example.catdemo.entity.FeatureExample;
import com.example.catdemo.mapper.FeatureMapper;
import com.example.catdemo.service.FeatureService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 功能表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-01-08 11:38
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureMapper featureMapper;

    /**
     * @param feature
     * @return
     */
    @Override
    public Response createFeature(Feature feature) {
        feature.setFeatureId(UUID.randomUUID().toString());
        int result = featureMapper.insertSelective(feature);
        if (result == 1) {
            return Response.success(feature);
        } else {
            return Response.error("创建失败");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Response deleteFeature(String id) {
        int result = featureMapper.deleteByPrimaryKey(id);
        if (result == 1) {
            return Response.noDateSuccess();
        } else {
            return Response.error("删除失败");
        }
    }

    /**
     * @param feature
     * @return
     */
    @Override
    public Response updateFeature(Feature feature) {
        int result = featureMapper.updateByPrimaryKeySelective(feature);
        if (result == 1) {
            return Response.success(feature);
        } else {
            return Response.error("更新失败");
        }
    }

    /**
     * @param feature
     * @return
     */
    @Override
    public Response getFeature(Feature feature) {
        FeatureExample featureExample = new FeatureExample();
        FeatureExample.Criteria criteria = featureExample.createCriteria();
        if (feature.getFeatureId() != null) {
            criteria.andFeatureIdEqualTo(feature.getFeatureId());
        }
        if (feature.getFeatureTitleZh() != null){
            criteria.andFeatureTitleZhEqualTo(feature.getFeatureTitleZh());
        }
        if (feature.getFeatureTitleEn() != null){
            criteria.andFeatureTitleEnEqualTo(feature.getFeatureTitleEn());
        }
        List<Feature> featureList = featureMapper.selectByExample(featureExample);
        return Response.success(featureList);
    }

    /**
     * @return
     */
    @Override
    public Response getAllFeatures() {
        List<Feature> featureList = featureMapper.selectByExample(null);
        return Response.success(featureList);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Response getFeatureById(String id) {
        FeatureExample featureExample = new FeatureExample();
        featureExample.createCriteria().andFeatureIdEqualTo(id);
        List<Feature> featureList = featureMapper.selectByExample(featureExample);
        return Response.success(featureList);
    }

    /**
     * @param features
     * @return
     */
    @Override
    public Response batchCreateFeatures(List<Feature> features) {
        return null;
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public Response batchDeleteFeatures(List<Long> ids) {
        return null;
    }

    /**
     * @param features
     * @return
     */
    @Override
    public Response batchUpdateFeatures(List<Feature> features) {
        return null;
    }
}



