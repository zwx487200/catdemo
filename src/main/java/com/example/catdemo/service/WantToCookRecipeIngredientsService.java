package com.example.catdemo.service;

import com.example.catdemo.entity.WantToCookRecipeIngredients;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;

/**
 * 想吃食谱食材关联表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
public interface WantToCookRecipeIngredientsService extends IService<WantToCookRecipeIngredients> {

    Response addWantToCookRecipeIngredients(WantToCookRecipeIngredients wantToCookRecipeIngredients);

    Response deleteWantToCookRecipeIngredients(String id);

    Response updateWantToCookRecipeIngredients(WantToCookRecipeIngredients wantToCookRecipeIngredients);

    Response getWantToCookRecipeIngredients(String id);

    Response getWantToCookRecipeIngredientsList(RequestInfo requestInfo);

}
