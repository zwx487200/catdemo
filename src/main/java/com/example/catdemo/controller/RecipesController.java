package com.example.catdemo.controller;

import com.example.catdemo.entity.Recipes;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.service.RecipesService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 家庭食谱主表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-03 11:15
 */
@RestController
@RequestMapping("/recipes")
public class RecipesController {

    @Autowired
    private RecipesService recipesService;

    @PostMapping("/addRecipes")
    public Response addRecipes( @Validated(addGroup.class) @RequestBody Recipes recipes) {
       return recipesService.addRecipe(recipes);
    }

    @PostMapping("/getRecipesList")
    public Response getRecipesById(@RequestBody RequestInfo requestInfo) {
        return recipesService.getRecipesList(requestInfo);
    }

    @PostMapping("/updateRecipes")
    public Response updateRecipes(@RequestBody Recipes recipes) {
        return recipesService.updateRecipes(recipes);
    }



}
