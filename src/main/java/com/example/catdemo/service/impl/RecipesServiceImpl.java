package com.example.catdemo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.example.catdemo.entity.*;
import com.example.catdemo.mapper.CookingStepsMapper;
import com.example.catdemo.mapper.RecipeIngredientsMapper;
import com.example.catdemo.service.RecipesService;
import com.example.catdemo.mapper.RecipesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * 家庭食谱主表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
@Service
public class RecipesServiceImpl extends ServiceImpl<RecipesMapper, Recipes> implements RecipesService {

    @Autowired
    private RecipesMapper recipesMapper;

    @Autowired
    private RecipeIngredientsMapper recipeIngredientsMapper;

    @Autowired
    private CookingStepsMapper cookingStepsMapper;

    @Override
    @Transactional
    public Response addRecipe(Recipes recipes) {
        recipes.setCreatedAt(new java.util.Date());
        recipes.setRecipeId(UUID.randomUUID().toString());
        if (recipesMapper.insert(recipes) > 0) {
            List<RecipeIngredients> recipeIngredientsList = recipes.getRecipeIngredients();
            for (RecipeIngredients recipeIngredients : recipeIngredientsList) {
                recipeIngredients.setIngredientId(UUID.randomUUID().toString());
                recipeIngredients.setRecipeId(recipes.getRecipeId());
                if (recipeIngredientsMapper.insertSelective(recipeIngredients) <= 0) {
                    throw new RuntimeException("插入食材信息失败");
                }
            }
            List<CookingSteps> cookingStepsList = recipes.getCookingSteps();
            for (CookingSteps cookingSteps : cookingStepsList) {
                cookingSteps.setCookingStepId(UUID.randomUUID().toString());
                cookingSteps.setRecipeId(recipes.getRecipeId());
                if (cookingStepsMapper.insertSelective(cookingSteps) <= 0) {
                    throw new RuntimeException("插入烹饪步骤失败");
                }
            }
            return Response.success(recipes);
        } else {
            return Response.error("1006", "添加家庭食谱失败");
        }
    }



    @Override
    public Response getRecipesById(Recipes recipes) {
        return null;
    }

    @Override
    @Transactional
    public Response updateRecipes(Recipes recipes) {
        if(!StringUtils.hasLength(recipes.getRecipeId())){
            return addRecipe(recipes);
        } else {
            if (recipesMapper.updateByPrimaryKeySelective(recipes) > 0) {
                // 先删掉老的食材和烹饪步骤
                RecipeIngredientsExample recipeIngredientsExample = new RecipeIngredientsExample();
                recipeIngredientsExample.createCriteria().andRecipeIdEqualTo(recipes.getRecipeId());
                recipeIngredientsMapper.deleteByExample(recipeIngredientsExample);
                CookingStepsExample cookingStepsExample = new CookingStepsExample();
                cookingStepsExample.createCriteria().andRecipeIdEqualTo(recipes.getRecipeId());
                cookingStepsMapper.deleteByExample(cookingStepsExample);
                List<RecipeIngredients> recipeIngredientsList = recipes.getRecipeIngredients();
                for (RecipeIngredients recipeIngredients : recipeIngredientsList) {
                    recipeIngredients.setIngredientId(UUID.randomUUID().toString());
                    recipeIngredients.setRecipeId(recipes.getRecipeId());
                    if (recipeIngredientsMapper.insertSelective(recipeIngredients) <= 0) {
                        throw new RuntimeException("更新食材信息失败");
                    }
                }
                List<CookingSteps> cookingStepsList = recipes.getCookingSteps();
                for (CookingSteps cookingSteps : cookingStepsList) {
                    cookingSteps.setCookingStepId(UUID.randomUUID().toString());
                    cookingSteps.setRecipeId(recipes.getRecipeId());
                    if (cookingStepsMapper.insertSelective(cookingSteps) <= 0) {
                        throw new RuntimeException("更新烹饪步骤失败");
                    }
                }
            }
        }
        return Response.success(recipes);
    }

    @Override
    public Response deleteRecipes(Recipes recipes) {
        return null;
    }

    @Override
    public Response getRecipesList(RequestInfo requestInfo) {
        Recipes recipes = new Recipes();
        if (requestInfo.getData()!= null) {
            recipes = JSON.parseObject(JSON.toJSONString(requestInfo.getData()), new TypeReference<Recipes>() {
            });
        }
        if(!StringUtils.hasLength(recipes.getFamilyId()) && StringUtils.hasLength(recipes.getRecipeId()) &&  StringUtils.hasLength(recipes.getCreatorId()) ){
            return Response.error("1002", "参数不能为空");
        }
        RecipesExample  recipesExample = new RecipesExample();
        if (StringUtils.hasLength(recipes.getFamilyId())){
            recipesExample.createCriteria().andFamilyIdEqualTo(recipes.getFamilyId());
        }
        if (StringUtils.hasLength(recipes.getCreatorId())){
            recipesExample.createCriteria().andCreatorIdEqualTo(recipes.getCreatorId());
        }
        if (StringUtils.hasLength(recipes.getRecipeId())){
            recipesExample.createCriteria().andRecipeIdEqualTo(recipes.getRecipeId());
        }
        List<Recipes> recipesList = recipesMapper.selectByExample(recipesExample);
        if (ObjectUtils.isEmpty(recipesList)) {
            return Response.error("1003", "查询家庭食谱失败");
        } else {
            // 查询食材
            for (Recipes recipe : recipesList) {
                RecipeIngredientsExample recipeIngredients = new RecipeIngredientsExample();
                recipeIngredients.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
                List<RecipeIngredients> recipeIngredientsList = recipeIngredientsMapper.selectByExample(recipeIngredients);
                recipe.setRecipeIngredients(recipeIngredientsList);
                // 烹饪步骤
                CookingStepsExample cookingStepsExample = new CookingStepsExample();
                cookingStepsExample.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
                List<CookingSteps> cookingStepsList = cookingStepsMapper.selectByExampleWithBLOBs(cookingStepsExample);
                recipe.setCookingSteps(cookingStepsList);
            }
        }
        return Response.success(recipesList);
    }
}
