package com.example.catdemo.service;

import com.example.catdemo.entity.Recipes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.transaction.annotation.Transactional;

/**
 * 家庭食谱主表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
public interface RecipesService extends IService<Recipes> {

    @Transactional
    Response addRecipe(Recipes recipes);
    Response getRecipesById(Recipes recipes);
    @Transactional
    Response updateRecipes(Recipes recipes);
    Response deleteRecipes(Recipes recipes);
    Response getRecipesList(RequestInfo requestInfo);

}
