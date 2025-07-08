package com.example.catdemo.service.impl;

import com.example.catdemo.service.WantToCookRecipeIngredientsService;
import com.example.catdemo.entity.WantToCookRecipeIngredients;
import com.example.catdemo.mapper.WantToCookRecipeIngredientsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 想吃食谱食材关联表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
@Service
public class WantToCookRecipeIngredientsServiceImpl extends ServiceImpl<WantToCookRecipeIngredientsMapper, WantToCookRecipeIngredients> implements WantToCookRecipeIngredientsService {

    @Autowired private WantToCookRecipeIngredientsMapper wantToCookRecipeIngredientsMapper;


    @Override
    public Response addWantToCookRecipeIngredients(WantToCookRecipeIngredients wantToCookRecipeIngredients) {
        if (wantToCookRecipeIngredientsMapper.insertSelective(wantToCookRecipeIngredients)>0) {
            return Response.success(wantToCookRecipeIngredients);
        } else {
            return Response.error("1003", "添加想吃食谱食材关联表失败");
        }
    }

    @Override
    public Response deleteWantToCookRecipeIngredients(String id) {
        return null;
    }

    @Override
    public Response updateWantToCookRecipeIngredients(WantToCookRecipeIngredients wantToCookRecipeIngredients) {
        if (this.updateById(wantToCookRecipeIngredients)) {
            return Response.success(wantToCookRecipeIngredients);
        } else {
            return Response.error("1003", "更新想吃食谱食材关联表失败");
        }
    }

    @Override
    public Response getWantToCookRecipeIngredients(String id) {
        return null;
    }

    @Override
    public Response getWantToCookRecipeIngredientsList(RequestInfo requestInfo) {
        return null;
    }
}
