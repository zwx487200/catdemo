package com.example.catdemo.service.impl;

import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.RecipeIngredientsMapper;
import com.example.catdemo.mapper.RecipesMapper;
import com.example.catdemo.mapper.WantToCookRecipeIngredientsMapper;
import com.example.catdemo.service.WantToCookService;
import com.example.catdemo.mapper.WantToCookMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 我想吃表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-09 11:48
 */
@Service
public class WantToCookServiceImpl extends ServiceImpl<WantToCookMapper, WantToCook> implements WantToCookService {


    @Autowired private WantToCookMapper wantToCookMapper;

    @Autowired private RecipeIngredientsMapper recipeIngredientsMapper;

    @Autowired private WantToCookRecipeIngredientsServiceImpl wantToCookRecipeIngredientsService;
    @Autowired
    private WantToCookRecipeIngredientsMapper wantToCookRecipeIngredientsMapper;
    @Autowired
    private RecipesMapper recipesMapper;

    @Override
    public Response addWantToCook(WantToCook wantToCook) {
        // 查询下是否已经有我想吃了
        WantToCookExample wantToCookExample = new WantToCookExample();
        wantToCookExample.createCriteria().andFamilyIdEqualTo(wantToCook.getFamilyId()).andRecipeIdEqualTo(wantToCook.getRecipeId());
        List<WantToCook> wantToCookList = wantToCookMapper.selectByExample(wantToCookExample);
        if (!CollectionUtils.isEmpty(wantToCookList)) {
            return Response.noDateSuccess();
        }
        wantToCook.setCreateTime(new Date());
        wantToCook.setStatus(0);
        wantToCook.setId(UUID.randomUUID().toString());
        // 如果没有计划烹饪时间，则设置过期时间为创建时间加7天
        if (wantToCook.getPlannedCookingTime() == null) {
            long createTimeMillis = wantToCook.getCreateTime().getTime();
            long expiryTimeMillis = createTimeMillis + 7 * 24 * 60 * 60 * 1000L;
            wantToCook.setExpiryTime(new Date(expiryTimeMillis));
        }
        if (wantToCookMapper.insertSelective(wantToCook)>0) {
            RecipeIngredientsExample recipeIngredients = new RecipeIngredientsExample();
            recipeIngredients.createCriteria().andRecipeIdEqualTo(wantToCook.getRecipeId());
            List<RecipeIngredients> recipeIngredientsList = recipeIngredientsMapper.selectByExample(recipeIngredients);
            if (!CollectionUtils.isEmpty(recipeIngredientsList)) {
                for (RecipeIngredients recipeIngredient : recipeIngredientsList) {
                    WantToCookRecipeIngredients wantToCookRecipeIngredients = new WantToCookRecipeIngredients();
                    wantToCookRecipeIngredients.setId(UUID.randomUUID().toString());
                    wantToCookRecipeIngredients.setWantToCookId(wantToCook.getId());
                    wantToCookRecipeIngredients.setRecipeIngredientId(recipeIngredient.getIngredientId());
                    wantToCookRecipeIngredients.setStatus(0);
                    wantToCookRecipeIngredients.setCreateTime(new Date());
                    wantToCookRecipeIngredients.setUpdateTime(new Date());
                    wantToCookRecipeIngredientsService.addWantToCookRecipeIngredients(wantToCookRecipeIngredients);
                }
            }
            return Response.success(wantToCook);
        } else {
            return Response.error("1003", "添加我想吃失败");
        }
    }

    @Override
    public Response deleteWantToCook(Integer id) {
        return null;
    }

    @Override
    public Response updateWantToCook(WantToCook wantToCook) {
        return null;
    }

    @Override
    public Response getWantToCook(String id) {
        return null;
    }

    @Override
    public Response getWantToCookList(RequestInfo requestInfo) {
        WantToCookExample wantToCookExample = new WantToCookExample();
        WantToCookExample.Criteria criteria = wantToCookExample.createCriteria();
        if (StringUtils.hasLength(requestInfo.getFamilyId())) {
            criteria.andFamilyIdEqualTo(requestInfo.getFamilyId());
        }
        if (!CollectionUtils.isEmpty(requestInfo.getFamilyMemberIds())){
            criteria.andUserIdIn(requestInfo.getFamilyMemberIds());
        }
        List<WantToCook>  wantToCookList = wantToCookMapper .selectByExample(wantToCookExample);
        if (!CollectionUtils.isEmpty(wantToCookList)){
            for (WantToCook wantToCook : wantToCookList) {
                Recipes recipe = recipesMapper.selectByPrimaryKey(wantToCook.getRecipeId());
                wantToCook.setRecipeName(recipe.getFoodName());
                WantToCookRecipeIngredientsExample wantToCookRecipeIngredientsExample = new WantToCookRecipeIngredientsExample();
                wantToCookRecipeIngredientsExample.createCriteria().andWantToCookIdEqualTo(wantToCook.getId());
                List<WantToCookRecipeIngredients> wantToCookRecipeIngredientsList = wantToCookRecipeIngredientsMapper.selectByExample(wantToCookRecipeIngredientsExample);
                if (!CollectionUtils.isEmpty(wantToCookRecipeIngredientsList)) {
                    for (WantToCookRecipeIngredients wantToCookRecipeIngredients : wantToCookRecipeIngredientsList) {
                        RecipeIngredients recipeIngredients = recipeIngredientsMapper.selectByPrimaryKey(wantToCookRecipeIngredients.getRecipeIngredientId());
                        wantToCookRecipeIngredients.setRecipeIngredients(recipeIngredients);
                    }
                }
                wantToCook.setWantToCookRecipeIngredients(wantToCookRecipeIngredientsList);
            }
        }
        return Response.success(wantToCookList,wantToCookList.size());
    }

    @Override
    public Response updateIngredientsStatus(WantToCook wantToCook) {
        try {
            if (wantToCook.getWantToCookRecipeIngredients() != null) {
                for (WantToCookRecipeIngredients wantToCookRecipeIngredients : wantToCook.getWantToCookRecipeIngredients()) {
                    wantToCookRecipeIngredientsMapper.updateByPrimaryKeySelective(wantToCookRecipeIngredients);
                }
            }
        } catch (Exception e) {
            return Response.error("1003", "更新食材状态失败");
        }
        return Response.noDateSuccess();


    }
}
