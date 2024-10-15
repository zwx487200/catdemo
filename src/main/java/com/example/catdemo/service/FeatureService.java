package com.example.catdemo.service;


import com.example.catdemo.entity.Feature;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

import java.util.List;

/**
 * 功能表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-01-08 11:38
 */
public interface FeatureService {
    Response createFeature(Feature feature);

    Response deleteFeature(String id);

    Response updateFeature(Feature feature);

    Response getFeature(Feature feature);

    Response getAllFeatures();

    Response getFeatureById(String id);

    Response batchCreateFeatures(List<Feature> features);

    Response batchDeleteFeatures(List<Long> ids);

    Response batchUpdateFeatures(List<Feature> features);
}
